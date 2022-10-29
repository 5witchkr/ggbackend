package com.pickban.ggbackend.recommendpick.application;

import com.pickban.ggbackend.recommendpick.dto.RecommendPickResponseDto;

public interface RecommendPickFacade {


    /**
     * 추천픽 response dto를 반환하는 facade
     * @param team
     * @param line
     * @param ban
     * @param emLine
     * @param teamChamp
     * @param emChamp
     * @return RecommendPickResponseDto
     */
    RecommendPickResponseDto getRecommend(String team, String line, String ban, String emLine, String teamChamp, String emChamp);
}
