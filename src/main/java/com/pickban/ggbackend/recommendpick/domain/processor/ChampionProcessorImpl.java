package com.pickban.ggbackend.recommendpick.domain.processor;

import com.pickban.ggbackend.recommendpick.domain.entity.Champion;
import com.pickban.ggbackend.recommendpick.domain.processor.mapper.ChampionMapper;
import com.pickban.ggbackend.recommendpick.domain.repository.ChampionRepository;
import com.pickban.ggbackend.recommendpick.dto.ChampionResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@RequiredArgsConstructor
public class ChampionProcessorImpl implements ChampionProcessor{

    private final ChampionRepository championRepository;
    private final ChampionMapper championMapper;

    @Override
    public List<ChampionResponseDto> getCounter(String emLineChamp) {
        Champion champion = championRepository.findByChampionId(Long.valueOf(emLineChamp))
                .orElseThrow(() -> new NullPointerException("Not Found Champion!!"));
                
        List<Long> counterList = champion.getCounters();
        List<ChampionResponseDto> championResponseDtoList = new ArrayList<>();
        counterList.forEach(champId -> championResponseDtoList.add(
                championMapper.championToChampionResponseDto(
                        championRepository.findByChampionId(champId)
                                .orElseThrow(() -> new NullPointerException("Not Found Champion!!!")))));
        return championResponseDtoList;
    }

    @Override
    public List<ChampionResponseDto> getTopTier(String line) {
        List<Champion> championList = championRepository.findByPositionAndChampionTier(line, "1Tier");
        return championMapper.championListToChampionResponseDtoList(championList);
    }

    @Override
    public List<ChampionResponseDto> getLineTier(String line, String tier) {
        List<Champion> championList = championRepository.findByPositionAndChampionTier(line, tier);
        return championMapper.championListToChampionResponseDtoList(championList);
    }

    @Override
    public List<ChampionResponseDto> getLineChampion(String line) {
        List<Champion> championList = championRepository.findByPosition(line);
        return championMapper.championListToChampionResponseDtoList(championList);
    }
}
