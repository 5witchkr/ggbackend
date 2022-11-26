package com.pickban.ggbackend.recommendpick.domain.repository;

import com.pickban.ggbackend.recommendpick.domain.entity.Champion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChampionRepository extends JpaRepository<Champion, Long> {

    Optional<Champion> findByChampName(String champName);

    Optional<Champion> findByChampId(Long champId);

    List<Champion> findByPositionAndChampTier(String position, String champTier);

    List<Champion> findByPosition(String position);

}
