package com.pickban.ggbackend.recommendpick.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProgamerPickDto {
    private String progamerName;
    private String progamerNickname;
    private RecommendPickDto recommendPickDto;

    public ProgamerPickDto() {
    }
    @Builder
    public ProgamerPickDto(String progamerName,
                                String progamerNickname,
                                RecommendPickDto recommendPickDto) {
        this.progamerName = progamerName;
        this.progamerNickname = progamerNickname;
        this.recommendPickDto = recommendPickDto;
    }


}
