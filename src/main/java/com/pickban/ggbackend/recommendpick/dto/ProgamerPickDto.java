package com.pickban.ggbackend.recommendpick.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProgamerPickDto {
    private String proName;
    private String proNickname;
    private RecommendPickDto recommendPickDto;
}
