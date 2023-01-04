package com.pickban.ggbackend.recommendpick.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChampionResponseDto {
    private Long championId;
    private String championTier;
    private Long opScore;

    public ChampionResponseDto() {
    }

    @Builder
    public ChampionResponseDto(Long championId,
                                    String championTier,
                                    Long opScore) {
        this.championId = championId;
        this.championTier = championTier;
        this.opScore = opScore;
    }

}
