package com.pickban.ggbackend.recommendpick.domain.processor;


import com.pickban.ggbackend.recommendpick.constantmodel.ChampValueConst;
import com.pickban.ggbackend.recommendpick.dto.ChampionResponseDto;
import com.pickban.ggbackend.recommendpick.enummodel.ExceptionMsgEnum;
import org.springframework.stereotype.Component;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MatchProcessorImpl implements MatchProcessor{

    @Override
    public List<ChampionResponseDto> tierSort(List<ChampionResponseDto> championResponseDtoList) {
        List<ChampionResponseDto> championResponseDto = championResponseDtoList.stream()
                .sorted((a, b) -> (int) (b.getOpScore() - a.getOpScore()))
                .collect(Collectors.toList());
        if (championResponseDto.size() < 3) {
            return championResponseDto;
        }
        return championResponseDto.subList(0,3);
    }

    @Override
    public List<ChampionResponseDto> removeDisableChamp(List<ChampionResponseDto> championResponseDtoList, String disableChampList) {
        return championResponseDtoList.stream()
                .filter(champ -> !convertDisableChampList(disableChampList).contains(champ.getChampionId()))
                .collect(Collectors.toList());
    }

    private List<Long> convertDisableChampList(String disableChampList) {
        List<Long> disableChampLists;
        try {
            disableChampLists = Arrays.stream(disableChampList.split(ChampValueConst.UNDERSCORE_FOR_SPLIT_CHAMP))
                    .map(Long::parseLong)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionMsgEnum.VALIDATE_ERROR_DISABLE_CHAMP_LIST.getValue());
        }
        return disableChampLists;
    }
}
