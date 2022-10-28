package com.pickban.ggbackend.recommendpick.domain.processor;

import com.pickban.ggbackend.recommendpick.dto.ChampionResponseDto;

import java.util.List;

public interface ChampionProcessor {

    /**
     * 상대방의 카운터챔피언을 반환하는 로직
     * @param emLineChamp
     * @return List<ChampionResponseDto>
     */
    List<ChampionResponseDto> getCounter(String emLineChamp);

    /**
     * 해당라인의 높은티어 챔피언을 반환하는 로직
     * @param line
     * @return List<ChampionResponseDto>
     */
    List<ChampionResponseDto> getTopTier(String line);
}
