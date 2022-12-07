package com.pickban.ggbackend.recommendpick.application;

import com.pickban.ggbackend.recommendpick.domain.entity.Champion;
import com.pickban.ggbackend.recommendpick.domain.repository.ChampionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class DevelopFacade {

    private final ChampionRepository championRepository;

//    public void updateChampData() {
//        Champion champion = championRepository.findByChampId(champId);
//        champion.setChampOpScore();
//        champion.setChampTier();
//        champion.setPosition();
//        champion.setChampName();
//    }
}
