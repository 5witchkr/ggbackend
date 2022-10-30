package com.pickban.ggbackend.recommendpick.application;

import com.pickban.ggbackend.recommendpick.dto.ProgamerPickDto;
import com.pickban.ggbackend.recommendpick.dto.RecommendPickDto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RecommendPickFacadeImpl implements RecommendPickFacade{

    @Override
    public List<RecommendPickDto> getRecommend(String team, String line, String ban, String emLine, String teamChamp, String emChamp) {
        return null;
    }

    @Override
    public List<ProgamerPickDto> getRecommendProgamer(String team, String line, String ban, String emLine, String teamChamp, String emChamp) {
        return null;
    }
}
