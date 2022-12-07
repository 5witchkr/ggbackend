package com.pickban.ggbackend.recommendpick.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProgamerPickDto {
    private String progamerName;
    private String progamerNickname;
    private RecommendPickDto recommendPickDto;
}
