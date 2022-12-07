package com.pickban.ggbackend.recommendpick.domain.repository;

import com.pickban.ggbackend.recommendpick.domain.entity.Champion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChampionRepository extends JpaRepository<Champion, Long> {

    Optional<Champion> findByChampionName(String championName);

    Optional<Champion> findByChampionId(Long championId);

    List<Champion> findByPositionAndChampionTier(String position, String championTier);

    List<Champion> findByPosition(String position);

}
