package com.pickban.ggbackend.recommendpick.dto;

import com.pickban.ggbackend.recommendpick.constantmodel.ChampValueConst;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecommendRequestDto {

    @Builder.Default
    private String bans = ChampValueConst.NOT_EXISTS_CHAMP_ID_VALUE;
    @Builder.Default
    private String emBans = ChampValueConst.NOT_EXISTS_CHAMP_ID_VALUE;
    @Builder.Default
    private String picks = ChampValueConst.NOT_EXISTS_CHAMP_ID_VALUE;
    @Builder.Default
    private String emPicks = ChampValueConst.NOT_EXISTS_CHAMP_ID_VALUE;

    public String getDisabledChampList() {
        return  this.bans +ChampValueConst.UNDERSCORE_FOR_SPLIT_CHAMP
                +this.emBans+ChampValueConst.UNDERSCORE_FOR_SPLIT_CHAMP
                +this.picks +ChampValueConst.UNDERSCORE_FOR_SPLIT_CHAMP
                +this.emPicks;
    }
}
