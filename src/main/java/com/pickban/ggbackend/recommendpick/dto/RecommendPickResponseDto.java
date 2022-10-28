package com.pickban.ggbackend.recommendpick.dto;


import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecommendPickResponseDto {
    private String position;
    private List<RecommendPickDto> recommendPickList;
    private List<ProgamerPickDto> progamerPickList;
}
