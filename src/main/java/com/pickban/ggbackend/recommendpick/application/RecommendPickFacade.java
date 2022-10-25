package com.pickban.ggbackend.recommendpick.application;

import com.pickban.ggbackend.recommendpick.dto.RecommendPickResponseDto;

public interface RecommendPickFacade {

    RecommendPickResponseDto getRecommend(String line, String emLineChamp, String teamChamp, String emTeamChamp);
}
