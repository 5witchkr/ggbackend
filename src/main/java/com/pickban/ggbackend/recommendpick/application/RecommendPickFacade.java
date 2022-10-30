package com.pickban.ggbackend.recommendpick.application;

import com.pickban.ggbackend.recommendpick.dto.ProgamerPickDto;
import com.pickban.ggbackend.recommendpick.dto.RecommendPickDto;

import java.util.List;

public interface RecommendPickFacade {


    /**
     * 추천픽 dto 리스트를 반환하는 facade
     * @param team
     * @param line
     * @param ban
     * @param emLine
     * @param teamChamp
     * @param emChamp
     * @return List<RecommendPickDto>
     */
    List<RecommendPickDto> getRecommend(String team, String line, String ban, String emLine, String teamChamp, String emChamp);

    /**
     * 프로그래머 추천픽 dto 리스트를 반환하는 facade
     * @param team
     * @param line
     * @param ban
     * @param emLine
     * @param teamChamp
     * @param emChamp
     * @return List<ProgamerPickDto>
     */
    List<ProgamerPickDto> getRecommendProgamer(String team, String line, String ban, String emLine, String teamChamp, String emChamp);
}
