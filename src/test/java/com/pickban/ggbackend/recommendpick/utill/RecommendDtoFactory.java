package com.pickban.ggbackend.recommendpick.utill;

import com.pickban.ggbackend.recommendpick.dto.ChampionResponseDto;
import com.pickban.ggbackend.recommendpick.dto.ProgamerPickDto;
import com.pickban.ggbackend.recommendpick.dto.RecommendPickDto;


import java.util.List;

public class RecommendDtoFactory {

    /**
     * Lissandra 113
     * @return RecommendPickDto
     */
    public RecommendPickDto createRecommendPickDtoLissandra() {
        return RecommendPickDto.builder()
                .champId(113L)
                .champTier("1Tier")
                .build();
    }


    /**
     * Ahri 89
     * @return RecommendPickDto
     */
    public RecommendPickDto createRecommendPickDtoAhri() {
        return RecommendPickDto.builder()
                .champId(89L)
                .champTier("2Tier")
                .build();
    }


    /**
     * Sylas 143
     * @return RecommendPickDto
     */
    public RecommendPickDto createRecommendPickDtoSylas() {
        return RecommendPickDto.builder()
                .champId(143L)
                .champTier("1Tier")
                .build();
    }

    /**
     * Azir 121
     * @return RecommendPickDto
     */
    public RecommendPickDto createRecommendPickDtoAzir() {
        return RecommendPickDto.builder()
                .champId(121L)
                .champTier("2Tier")
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
     * RecommendPick Dto Midline
     * @size 3
     * @return List<RecommendPickDto>
     */
    public List<RecommendPickDto> createRecommendPickDtoMid() {
        return List.of(createRecommendPickDtoLissandra(),
                createRecommendPickDtoAhri(),
                createRecommendPickDtoSylas());
    }


    /**
     * ProgamerPick Dto Midline
     * @size 2
     * @return List<ProgamerPickDto>
     */
    public List<ProgamerPickDto> createProgamerPickDtoMid() {
        return List.of(createProgamerPickDtoFaker(),
                createProgamerPickDtoChovy());
    }

    /**
     * 카운터 챔피언리스트
     * @championListSize 4
     * @return List<ChampionResponseDto>
     */
    public List<ChampionResponseDto> createCounterChampionList() {
        ChampionResponseDto championResponseDto1 = ChampionResponseDto
                .builder().champId(143L).champTier("1Tier").build();
        ChampionResponseDto championResponseDto2 = ChampionResponseDto
                .builder().champId(89L).champTier("2Tier").build();
        ChampionResponseDto championResponseDto3 = ChampionResponseDto
                .builder().champId(113L).champTier("1Tier").build();
        ChampionResponseDto championResponseDto4 = ChampionResponseDto
                .builder().champId(121L).champTier("2Tier").build();

        return List.of(championResponseDto1, championResponseDto2, championResponseDto3, championResponseDto4);
    }

    /**
     * 하이티어 챔피언리스트
     * 143-Sylas 113-Lissandra 51-Akali
     * @championListSize 3
     * @return List<ChampionResponseDto>
     */
    public List<ChampionResponseDto> createHighTierChampionList() {
        ChampionResponseDto championResponseDto1 = ChampionResponseDto
                .builder().champId(143L).champTier("1Tier").build();
        ChampionResponseDto championResponseDto2 = ChampionResponseDto
                .builder().champId(113L).champTier("1Tier").build();
        ChampionResponseDto championResponseDto3 = ChampionResponseDto
                .builder().champId(51L).champTier("1Tier").build();

        return List.of(championResponseDto1,championResponseDto2, championResponseDto3);
    }

    public List<ChampionResponseDto> createRemoveDisableChampionList() {
        ChampionResponseDto championResponseDto1 = ChampionResponseDto
                .builder().champId(143L).champTier("1Tier").build();
        ChampionResponseDto championResponseDto2 = ChampionResponseDto
                .builder().champId(121L).champTier("2Tier").build();
        ChampionResponseDto championResponseDto3 = ChampionResponseDto
                .builder().champId(113L).champTier("1Tier").build();
        return List.of(championResponseDto1, championResponseDto2, championResponseDto3);
    }

    public List<ChampionResponseDto> createSortTierChampionList() {
        ChampionResponseDto championResponseDto1 = ChampionResponseDto
                .builder().champId(143L).champTier("1Tier").build();
        ChampionResponseDto championResponseDto2 = ChampionResponseDto
                .builder().champId(121L).champTier("2Tier").build();
        ChampionResponseDto championResponseDto3 = ChampionResponseDto
                .builder().champId(121L).champTier("2Tier").build();
        return List.of(championResponseDto1, championResponseDto2, championResponseDto3);
    }
}
