package com.pickban.ggbackend.recommendpick.application;

import com.pickban.ggbackend.recommendpick.dto.RecommendPickResponseDto;
import org.springframework.stereotype.Service;


@Service
public class RecommendPickFacadeImpl implements RecommendPickFacade{
    @Override
    public RecommendPickResponseDto getRecommend(String line, String ban, String emLineChamp, String teamChamp, String emTeamChamp) {
        return null;
    }
}
