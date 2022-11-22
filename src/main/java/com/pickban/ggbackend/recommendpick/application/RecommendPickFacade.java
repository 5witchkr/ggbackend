package com.pickban.ggbackend.recommendpick.application;

import com.pickban.ggbackend.recommendpick.dto.ProgamerPickDto;
import com.pickban.ggbackend.recommendpick.dto.RecommendPickDto;
import com.pickban.ggbackend.recommendpick.dto.RecommendRequestDto;



import java.util.List;

public interface RecommendPickFacade {


    /**
     * 추천픽 dto 리스트를 반환하는 facade
     * @return List<RecommendPickDto>
     */
    List<RecommendPickDto> getRecommend(String team, String line, RecommendRequestDto recommendRequestDto);

    /**
     * 프로그래머 추천픽 dto 리스트를 반환하는 facade
     * @return List<ProgamerPickDto>
     */
    List<ProgamerPickDto> getRecommendProgamer(String team, String line, RecommendRequestDto recommendRequestDto);
}
