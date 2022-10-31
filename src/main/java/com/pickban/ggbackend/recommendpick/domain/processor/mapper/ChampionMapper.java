package com.pickban.ggbackend.recommendpick.domain.processor.mapper;


import com.pickban.ggbackend.recommendpick.domain.entity.Champion;
import com.pickban.ggbackend.recommendpick.dto.ChampionResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChampionMapper {
    ChampionResponseDto championToChampionResponseDto(Champion champion);

    List<ChampionResponseDto> championListToChampionResponseDtoList(List<Champion> championList);
}
