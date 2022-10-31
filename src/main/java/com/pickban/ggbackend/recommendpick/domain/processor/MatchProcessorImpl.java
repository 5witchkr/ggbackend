package com.pickban.ggbackend.recommendpick.domain.processor;


import com.pickban.ggbackend.recommendpick.domain.repository.ChampionRepository;
import com.pickban.ggbackend.recommendpick.dto.ChampionResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


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
//        List<Champion> disabledList = new ArrayList<>();
//        championResponseDtoList.stream().filter(champ -> disabledList != champ.getChampId());
        return championResponseDtoList;
    }
}
