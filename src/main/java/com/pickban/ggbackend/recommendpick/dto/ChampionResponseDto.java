package com.pickban.ggbackend.recommendpick.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChampionResponseDto {
    private Long champId;
    private String champTier;
    private Long champOpScore;
}
