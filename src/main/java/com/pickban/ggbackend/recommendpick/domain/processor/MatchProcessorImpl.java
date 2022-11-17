package com.pickban.ggbackend.recommendpick.domain.processor;


import com.pickban.ggbackend.recommendpick.domain.repository.ChampionRepository;
import com.pickban.ggbackend.recommendpick.dto.ChampionResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MatchProcessorImpl implements MatchProcessor{

    private final ChampionRepository championRepository;

    @Override
    public List<ChampionResponseDto> tierSort(List<ChampionResponseDto> championResponseDtoList) {
        List<ChampionResponseDto> championResponseDto = championResponseDtoList.stream()
                .sorted((a, b) -> (int) (b.getChampOpScore() - a.getChampOpScore()))
                .collect(Collectors.toList());
        return championResponseDto.subList(0,3);
    }

    @Override
    public List<ChampionResponseDto> removeDisableChamp(List<ChampionResponseDto> championResponseDtoList, String disableChampList) {
        //제한 챔피언을 제외하고 리턴해준다.
        return championResponseDtoList.stream()
                .filter(champ -> !convertDisableChampList(disableChampList).contains(champ.getChampId()))
                .collect(Collectors.toList());
    }

    private List<Long> convertDisableChampList(String disableChampList) {
        List<Long> disableChampLists;
        try {
            disableChampLists = Arrays.stream(disableChampList.split("_"))
                    .map(Long::parseLong)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException("Validate Error DisableChampList");
        }
        return disableChampLists;
    }
}
