package com.pickban.ggbackend.recommendpick.application;

import com.pickban.ggbackend.recommendpick.dto.RecommendPickResponseDto;

public interface RecommendPickFacade {


    /**
     * 추천픽 response dto를 반환하는 facade
     * @param line
     * @param ban
     * @param emLineChamp
     * @param teamChamp
     * @param emTeamChamp
     * @return RecommendPickResponseDto
     */
    RecommendPickResponseDto getRecommend(String line, String ban, String emLineChamp, String teamChamp, String emTeamChamp);
}
