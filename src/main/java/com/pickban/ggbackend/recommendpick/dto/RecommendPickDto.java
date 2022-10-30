package com.pickban.ggbackend.recommendpick.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecommendPickDto {
    private long champId;
    private String ChampTier;
}