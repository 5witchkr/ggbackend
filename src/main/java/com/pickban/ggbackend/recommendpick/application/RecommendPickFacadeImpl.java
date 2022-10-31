package com.pickban.ggbackend.recommendpick.application;

import com.pickban.ggbackend.recommendpick.domain.processor.ChampionProcessor;
import com.pickban.ggbackend.recommendpick.domain.processor.MatchProcessor;
import com.pickban.ggbackend.recommendpick.dto.ProgamerPickDto;
import com.pickban.ggbackend.recommendpick.dto.RecommendPickDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class RecommendPickFacadeImpl implements RecommendPickFacade{

    private final ChampionProcessor championProcessor;
    private final MatchProcessor matchProcessor;

    @Override
    public List<RecommendPickDto> getRecommend(String team, String line, String ban, String emLine, String teamChamp, String emChamp) {
        return null;
    }

    @Override
    public List<ProgamerPickDto> getRecommendProgamer(String team, String line, String ban, String emLine, String teamChamp, String emChamp) {
        return null;
    }
}
