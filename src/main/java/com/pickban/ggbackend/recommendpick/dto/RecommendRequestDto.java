package com.pickban.ggbackend.recommendpick.dto;

import com.pickban.ggbackend.recommendpick.constantmodel.ChampValueConst;
import lombok.*;


@Getter
@Setter
public class RecommendRequestDto {

    private String bans;
    private String emBans;
    private String picks;
    private String emPicks;

    @Builder
    public RecommendRequestDto(String bans, String emBans, String picks, String emPicks) {
        this.bans = bans;
        this.emBans = emBans;
        this.picks = picks;
        this.emPicks = emPicks;
    }
}
