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
    private String ban = ChampValueConst.NOT_EXISTS_CHAMP_ID_VALUE;
    @Builder.Default
    private String emLine = ChampValueConst.NOT_EXISTS_CHAMP_ID_VALUE;
    @Builder.Default
    private String teamChamp = ChampValueConst.NOT_EXISTS_CHAMP_ID_VALUE;
    @Builder.Default
    private String emChamp = ChampValueConst.NOT_EXISTS_CHAMP_ID_VALUE;

    public String getDisabledChampList() {
        return  this.ban+ChampValueConst.UNDERSCORE_FOR_SPLIT_CHAMP
                +this.emLine+ChampValueConst.UNDERSCORE_FOR_SPLIT_CHAMP
                +this.teamChamp+ChampValueConst.UNDERSCORE_FOR_SPLIT_CHAMP
                +this.emChamp;
    }
}
