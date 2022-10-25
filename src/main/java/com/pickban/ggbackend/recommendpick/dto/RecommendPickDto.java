package com.pickban.ggbackend.recommendpick.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecommendPickDto {
    private String recommendChamp;
    private String recommendRank;
    private String ChampTier;
}