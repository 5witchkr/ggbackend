package com.pickban.ggbackend.recommendpick.application;

import com.pickban.ggbackend.recommendpick.application.mapper.RecommendPickMapper;
import com.pickban.ggbackend.recommendpick.domain.processor.ChampionProcessor;
import com.pickban.ggbackend.recommendpick.domain.processor.MatchProcessor;
import com.pickban.ggbackend.recommendpick.dto.ChampionResponseDto;
import com.pickban.ggbackend.recommendpick.dto.ProgamerPickDto;
import com.pickban.ggbackend.recommendpick.dto.RecommendPickDto;
import com.pickban.ggbackend.recommendpick.dto.RecommendRequestDto;
import com.pickban.ggbackend.recommendpick.enummodel.LineEnum;
import com.pickban.ggbackend.recommendpick.enummodel.TeamEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class RecommendPickFacadeImpl implements RecommendPickFacade{

    private final ChampionProcessor championProcessor;
    private final MatchProcessor matchProcessor;
    private final RecommendPickMapper recommendPickMapper;

    @Override
    public List<RecommendPickDto> getRecommend(TeamEnum team, LineEnum line, RecommendRequestDto recommendRequestDto) {
        String disableChampList = recommendRequestDto.getDisabledChampList();

        //getCounterOrTopTier without removedChamp
        //todo refactor getCounterOrTopTier -> getCounterOrHighScoreChamp
        List<ChampionResponseDto> removedChampList = matchProcessor
                .removeDisableChamp(getCounterOrTopTier(line, recommendRequestDto.getEmLine()), disableChampList);

        removedChampList = checkChampCount(removedChampList, championProcessor.getTopTier(line), disableChampList);
        removedChampList = checkChampCount(removedChampList, championProcessor.getMiddleTier(line), disableChampList);

        List<ChampionResponseDto> sortedChampList = matchProcessor.tierSort(removedChampList);

        return recommendPickMapper.champResDtoListToRecommendPickDtoList(sortedChampList);
    }

    @Override
    public List<ProgamerPickDto> getRecommendProgamer(TeamEnum team, LineEnum line, RecommendRequestDto recommendRequestDto) {
        return null;
    }

    private List<ChampionResponseDto> checkChampCount(List<ChampionResponseDto> removedChampList, List<ChampionResponseDto> championProcessor, String disableChampList) {
        if (removedChampList.size() < 3)  removedChampList = matchProcessor
                .removeDisableChamp(championProcessor, disableChampList);
        return removedChampList;
    }

    private List<ChampionResponseDto> getCounterOrTopTier(LineEnum line, String emLine) {
        List<ChampionResponseDto> champDtoList;
        if (emLine.equals("0")) {
            champDtoList = championProcessor.getTopTier(LineEnum);
        } else {
            champDtoList = championProcessor.getCounter(emLine);
        }
        return champDtoList;
    }

}
