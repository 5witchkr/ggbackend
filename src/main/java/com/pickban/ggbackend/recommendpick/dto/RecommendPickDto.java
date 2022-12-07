package com.pickban.ggbackend.recommendpick.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecommendPickDto {
    private Long championId;
    private String championTier;
}