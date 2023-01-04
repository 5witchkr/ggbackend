package com.pickban.ggbackend.recommendpick.application;

import com.pickban.ggbackend.recommendpick.application.mapper.RecommendPickMapper;
import com.pickban.ggbackend.recommendpick.constantmodel.ChampValueConst;
import com.pickban.ggbackend.recommendpick.domain.processor.ChampionProcessor;
import com.pickban.ggbackend.recommendpick.domain.processor.MatchProcessor;
import com.pickban.ggbackend.recommendpick.dto.ChampionResponseDto;
import com.pickban.ggbackend.recommendpick.dto.ProgamerPickDto;
import com.pickban.ggbackend.recommendpick.dto.RecommendPickDto;
import com.pickban.ggbackend.recommendpick.dto.RecommendRequestDto;

import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class RecommendPickFacadeImpl implements RecommendPickFacade{

    private final ChampionProcessor championProcessor;
    private final MatchProcessor matchProcessor;
    private final RecommendPickMapper recommendPickMapper;

    public RecommendPickFacadeImpl(ChampionProcessor championProcessor, MatchProcessor matchProcessor, RecommendPickMapper recommendPickMapper) {
        this.championProcessor = championProcessor;
        this.matchProcessor = matchProcessor;
        this.recommendPickMapper = recommendPickMapper;
    }

    @Override
    public List<RecommendPickDto> getRecommend(String team, String line, RecommendRequestDto recommendRequestDto) {
        List<ChampionResponseDto> removedChampList =
                matchProcessor.removeDisableChamp(championProcessor.getLineChampion(line), parseDtoToString(recommendRequestDto));
        List<ChampionResponseDto> sortedChampList = matchProcessor.tierSort(removedChampList);
        return recommendPickMapper.champResDtoListToRecommendPickDtoList(sortedChampList);
    }

    @Override
    public List<ProgamerPickDto> getRecommendProgamer(String team, String line, RecommendRequestDto recommendRequestDto) {
        return null;
    }


    /**
     * @deprecated
     */
    private List<ChampionResponseDto> checkChampCount(List<ChampionResponseDto> removedChampList, List<ChampionResponseDto> championProcessor, String disableChampList) {
        if (removedChampList.size() < 3)  removedChampList =
                Stream.of(removedChampList, matchProcessor.removeDisableChamp(championProcessor, disableChampList))
                        .flatMap(Collection::stream)
                        .distinct()
                        .collect(Collectors.toList());
        return removedChampList;
    }

    private String parseDtoToString(RecommendRequestDto recommendRequestDto) {
        return recommendRequestDto.getBans() + ChampValueConst.UNDERSCORE_FOR_SPLIT_CHAMP
                + recommendRequestDto.getEmBans() + ChampValueConst.UNDERSCORE_FOR_SPLIT_CHAMP
                + recommendRequestDto.getPicks() + ChampValueConst.UNDERSCORE_FOR_SPLIT_CHAMP
                + recommendRequestDto.getEmPicks();
    }

}
