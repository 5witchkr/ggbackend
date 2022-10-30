package com.pickban.ggbackend.recommendpick.utill;

import com.pickban.ggbackend.recommendpick.dto.ChampionResponseDto;
import com.pickban.ggbackend.recommendpick.dto.ProgamerPickDto;
import com.pickban.ggbackend.recommendpick.dto.RecommendPickDto;
import com.pickban.ggbackend.recommendpick.dto.RecommendPickResponseDto;


import java.util.List;

public class RecommendDtoFactory {

    /**
     * Lissandra
     * @return RecommendPickDto
     */
    public RecommendPickDto createRecommendPickDtoLissandra() {
        return RecommendPickDto.builder()
                .champId(113)
                .champName("Lissandra")
                .ChampTier("1")
                .build();
    }


    /**
     * Ahri
     * @return RecommendPickDto
     */
    public RecommendPickDto createRecommendPickDtoAhri() {
        return RecommendPickDto.builder()
                .champId(89)
                .champName("Ahri")
                .ChampTier("2")
                .build();
    }


    /**
     * Sylas
     * @return RecommendPickDto
     */
    public RecommendPickDto createRecommendPickDtoSylas() {
        return RecommendPickDto.builder()
                .champId(143)
                .champName("Sylas")
                .ChampTier("1")
                .build();
    }

    /**
     * Azir
     * @return RecommendPickDto
     */
    public RecommendPickDto createRecommendPickDtoAzir() {
        return RecommendPickDto.builder()
                .champId(121)
                .champName("Azir")
                .ChampTier("2")
                .build();
    }


    /**
     * Faker - Sylas
     * @return ProgramerPickDto
     */
    public ProgamerPickDto createProgamerPickDtoFaker() {
        return ProgamerPickDto.builder()
                .proName("Faker")
                .proNickname("hide on bush")
                .recommendPickDto(createRecommendPickDtoSylas())
                .build();
    }


    /**
     * Chovy - Azir
     * @return ProgramerPickDto
     */
    public ProgamerPickDto createProgamerPickDtoChovy() {
        return ProgamerPickDto.builder()
                .proName("Chovy")
                .proNickname("Gen.G Chovy")
                .recommendPickDto(createRecommendPickDtoAzir())
                .build();
    }


    /**
     * Recommend endpoint response dto
     * @recommendListSize 3
     * @progamerPickListSize 2
     * @return RecommendPickResponseDto
     */
    public RecommendPickResponseDto createRecommendPickResponseDtoMid() {
        return RecommendPickResponseDto.builder()
                .recommendPickList(
                        List.of(createRecommendPickDtoLissandra(), createRecommendPickDtoAhri(), createRecommendPickDtoSylas()))
                .progamerPickList(List.of(createProgamerPickDtoFaker(), createProgamerPickDtoChovy()))
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
