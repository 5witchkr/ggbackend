package com.pickban.ggbackend.recommendpick.application.mapper;


import com.pickban.ggbackend.recommendpick.dto.ChampionResponseDto;
import com.pickban.ggbackend.recommendpick.dto.RecommendPickDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RecommendPickMapper {

    List<RecommendPickDto> champResDtoListToRecommendPickDtoList(List<ChampionResponseDto> championResponseDtoList);
}
