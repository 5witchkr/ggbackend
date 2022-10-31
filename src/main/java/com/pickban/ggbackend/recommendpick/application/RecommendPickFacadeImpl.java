package com.pickban.ggbackend.recommendpick.application;

import com.pickban.ggbackend.recommendpick.application.mapper.RecommendPickMapper;
import com.pickban.ggbackend.recommendpick.domain.processor.ChampionProcessor;
import com.pickban.ggbackend.recommendpick.domain.processor.MatchProcessor;
import com.pickban.ggbackend.recommendpick.dto.ChampionResponseDto;
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
    private final RecommendPickMapper recommendPickMapper;

    @Override
    public List<RecommendPickDto> getRecommend(String team, String line, String ban, String emLine, String teamChamp, String emChamp) {
        List<ChampionResponseDto> champDtoList;
        //get champ list
        if (!emLine.isEmpty() || !emLine.isBlank()) {
            champDtoList = championProcessor.getCounter(emLine);
        } else {
            champDtoList = championProcessor.getTopTier(line);
        }
        //todo refactor stream form
        //remove
        List<ChampionResponseDto> removedChampList = matchProcessor
                .removeDisableChamp(champDtoList, ban+"_"+emLine+"_"+teamChamp+"_"+emChamp);

        //todo add champ logic
        if (removedChampList.size() < 3) championProcessor.getTopTier(line);

        //sort tier
        List<ChampionResponseDto> sortedChampList = matchProcessor.tierSort(removedChampList);

        //response mapping
        return recommendPickMapper.champResDtoListToRecommendPickDtoList(sortedChampList);
    }

    @Override
    public List<ProgamerPickDto> getRecommendProgamer(String team, String line, String ban, String emLine, String teamChamp, String emChamp) {
        return null;
    }
}
