package com.pickban.ggbackend.recommendpick.dto;

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
    private String ban = "0";
    @Builder.Default
    private String emLine = "0";
    @Builder.Default
    private String teamChamp = "0";
    @Builder.Default
    private String emChamp = "0";

    public String getDisabledChampList() {
        return  this.ban+"_"+this.emLine+"_"+this.teamChamp+"_"+this.emChamp;
    }


}
