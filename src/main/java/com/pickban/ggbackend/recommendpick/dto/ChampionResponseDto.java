package com.pickban.ggbackend.recommendpick.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChampionResponseDto {
    private Long championId;
    private String championTier;
    private Long opScore;

    public ChampionResponseDto(Long championId) {
        this.championId = championId;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ChampionResponseDto) {
            return championId.equals(((ChampionResponseDto) o).championId);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return championId.hashCode();
    }

    @Override
    public String toString() {
        return String.valueOf(championId);
    }
}
