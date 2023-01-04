package com.pickban.ggbackend.recommendpick.dto;


import lombok.*;

@Getter
@Setter
public class RecommendPickDto {
    private Long championId;
    private String championTier;

    public RecommendPickDto(){}

    @Builder
    public RecommendPickDto(Long championId,
     String championTier){
        this.championId = championId;
        this.championTier = championTier;
    }
}