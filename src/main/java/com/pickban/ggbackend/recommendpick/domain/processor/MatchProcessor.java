package com.pickban.ggbackend.recommendpick.domain.processor;

import com.pickban.ggbackend.recommendpick.dto.ChampionResponseDto;

import java.util.List;

public interface MatchProcessor {

    /**
     * 챔피언리스트의 우선순위를 계산하는 로직
     * @param championResponseDtoList
     * @return List<ChampionResponseDto>
     */
    List<ChampionResponseDto> tierSort(List<ChampionResponseDto> championResponseDtoList);

    /**
     * 픽할수없는 상태의 챔피언을 추천에서 제외시켜주는 로직
     * @param championResponseDtoList
     * @param disableChampList
     * @return List<ChampionResponseDto>
     */
    List<ChampionResponseDto> removeDisableChamp(List<ChampionResponseDto> championResponseDtoList, String disableChampList);
}
