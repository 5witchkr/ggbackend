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

    public ChampionResponseDto(Long champId) {
        this.champId = champId;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ChampionResponseDto) {
            return champId.equals(((ChampionResponseDto) o).champId);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return champId.hashCode();
    }

    @Override
    public String toString() {
        return String.valueOf(champId);
    }
}
