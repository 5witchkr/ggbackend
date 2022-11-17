package com.pickban.ggbackend.recommendpick.application;

import com.pickban.ggbackend.recommendpick.dto.ProgamerPickDto;
import com.pickban.ggbackend.recommendpick.dto.RecommendPickDto;
import com.pickban.ggbackend.recommendpick.dto.RecommendRequestDto;
import com.pickban.ggbackend.recommendpick.enummodel.LineEnum;
import com.pickban.ggbackend.recommendpick.enummodel.TeamEnum;

import java.util.List;

public interface RecommendPickFacade {


    /**
     * 추천픽 dto 리스트를 반환하는 facade
     * @return List<RecommendPickDto>
     */
    List<RecommendPickDto> getRecommend(TeamEnum team, LineEnum line, RecommendRequestDto recommendRequestDto);

    /**
     * 프로그래머 추천픽 dto 리스트를 반환하는 facade
     * @return List<ProgamerPickDto>
     */
    List<ProgamerPickDto> getRecommendProgamer(TeamEnum team, LineEnum line, RecommendRequestDto recommendRequestDto);
}
