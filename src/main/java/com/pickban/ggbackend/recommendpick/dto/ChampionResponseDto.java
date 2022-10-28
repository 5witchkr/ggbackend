package com.pickban.ggbackend.recommendpick.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChampionResponseDto {
    private String championName;

    //todo refactor string to enum
    private String championTier;
}
