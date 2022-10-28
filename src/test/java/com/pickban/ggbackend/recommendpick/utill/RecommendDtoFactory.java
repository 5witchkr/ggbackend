package com.pickban.ggbackend.recommendpick.utill;

import com.pickban.ggbackend.recommendpick.dto.ChampionResponseDto;
import com.pickban.ggbackend.recommendpick.dto.ProgamerPickDto;
import com.pickban.ggbackend.recommendpick.dto.RecommendPickDto;
import com.pickban.ggbackend.recommendpick.dto.RecommendPickResponseDto;


import java.util.List;

public class RecommendDtoFactory {

    /**
     * 챔피언 추천픽 Dto
     * @champ Lisandra
     * @return RecommendPickDto
     */
    public RecommendPickDto createRecommendPickDtoLissandra() {
        return RecommendPickDto.builder()
                .recommendChamp("Lissandra")
                .recommendRank("78")
                .ChampTier("1")
                .build();
    }

    /**
     * 챔피언 추천픽 Dto
     * @champ Ahri
     * @return RecommendPickDto
     */
    public RecommendPickDto createRecommendPickDtoAhri() {
        return RecommendPickDto.builder()
                .recommendChamp("Ahri")
                .recommendRank("68")
                .ChampTier("2")
                .build();
    }

    /**
     * 챔피언 추천픽 Dto
     * @champ Sylas
     * @return RecommendPickDto
     */
    public RecommendPickDto createRecommendPickDtoSylas() {
        return RecommendPickDto.builder()
                .recommendChamp("Sylas")
                .recommendRank("56")
                .ChampTier("1")
                .build();
    }

    /**
     * 프로게이머픽 Dto
     * @progamer Faker
     * @return ProgamerPickDto
     */
    public ProgamerPickDto createProgamerPickDtoFaker() {
        return ProgamerPickDto.builder()
                .proName("Faker")
                .proNickname("hide on bush")
                .championName("Sylas")
                .build();
    }

    /**
     * 프로게이머픽 Dto
     * @progamer Chovy
     * @return ProgamerPickDto
     */
    public ProgamerPickDto createProgamerPickDtoChovy() {
        return ProgamerPickDto.builder()
                .proName("Chovy")
                .proNickname("Gen.G Chovy")
                .championName("Azir")
                .build();
    }


    /**
     * Recommend endpoint response dto
     * @line mid
     * @recommendListSize 3
     * @progamerPickListSize 2
     * @return RecommendPickResponseDto
     */
    public RecommendPickResponseDto createRecommendPickResponseDtoMid() {
        return RecommendPickResponseDto.builder()
                .recommendPickList(
                        List.of(createRecommendPickDtoLissandra(), createRecommendPickDtoAhri(), createRecommendPickDtoSylas()))
                .progamerPickList(List.of(createProgamerPickDtoFaker(), createProgamerPickDtoChovy()))
                .position("mid")
                .build();
    }

    /**
     * 카운터 챔피언리스트
     * @championListSize 4
     * @return List<ChampionResponseDto>
     */
    public List<ChampionResponseDto> createCounterChampionList() {
        ChampionResponseDto championResponseDto1 = ChampionResponseDto
                .builder().championName("Sylas").championTier("1Tier").build();
        ChampionResponseDto championResponseDto2 = ChampionResponseDto
                .builder().championName("Ahri").championTier("2Tier").build();
        ChampionResponseDto championResponseDto3 = ChampionResponseDto
                .builder().championName("Lissandra").championTier("1Tier").build();
        ChampionResponseDto championResponseDto4 = ChampionResponseDto
                .builder().championName("Azir").championTier("2Tier").build();

        return List.of(championResponseDto1, championResponseDto2, championResponseDto3, championResponseDto4);
    };

    /**
     * 하이티어 챔피언리스트
     * @championListSize 3
     * @return List<ChampionResponseDto>
     */
    public List<ChampionResponseDto> createHighTierChampionList() {
        ChampionResponseDto championResponseDto1 = ChampionResponseDto
                .builder().championName("Sylas").championTier("1Tier").build();
        ChampionResponseDto championResponseDto2 = ChampionResponseDto
                .builder().championName("Lissandra").championTier("1Tier").build();
        ChampionResponseDto championResponseDto3 = ChampionResponseDto
                .builder().championName("Akali").championTier("1Tier").build();

        return List.of(championResponseDto1,championResponseDto2, championResponseDto3);
    };
}
