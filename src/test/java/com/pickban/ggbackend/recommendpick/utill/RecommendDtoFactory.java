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
                .championId(113L)
                .championTier("1Tier")
                .build();
    }


    /**
     * Ahri 89
     * @return RecommendPickDto
     */
    public RecommendPickDto createRecommendPickDtoAhri() {
        return RecommendPickDto.builder()
                .championId(89L)
                .championTier("2Tier")
                .build();
    }


    /**
     * Sylas 143
     * @return RecommendPickDto
     */
    public RecommendPickDto createRecommendPickDtoSylas() {
        return RecommendPickDto.builder()
                .championId(143L)
                .championTier("1Tier")
                .build();
    }

    /**
     * Azir 121
     * @return RecommendPickDto
     */
    public RecommendPickDto createRecommendPickDtoAzir() {
        return RecommendPickDto.builder()
                .championId(121L)
                .championTier("2Tier")
                .build();
    }


    /**
     * Faker - Sylas
     * @return ProgramerPickDto
     */
    public ProgamerPickDto createProgamerPickDtoFaker() {
        return ProgamerPickDto.builder()
                .progamerName("Faker")
                .progamerNickname("hide on bush")
                .recommendPickDto(createRecommendPickDtoSylas())
                .build();
    }


    /**
     * Chovy - Azir
     * @return ProgramerPickDto
     */
    public ProgamerPickDto createProgamerPickDtoChovy() {
        return ProgamerPickDto.builder()
                .progamerName("Chovy")
                .progamerNickname("Gen.G Chovy")
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
                .builder().championId(143L).championTier("1Tier").build();
        ChampionResponseDto championResponseDto2 = ChampionResponseDto
                .builder().championId(89L).championTier("2Tier").build();
        ChampionResponseDto championResponseDto3 = ChampionResponseDto
                .builder().championId(113L).championTier("1Tier").build();
        ChampionResponseDto championResponseDto4 = ChampionResponseDto
                .builder().championId(121L).championTier("2Tier").build();

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
                .builder().championId(143L).championTier("1Tier").build();
        ChampionResponseDto championResponseDto2 = ChampionResponseDto
                .builder().championId(113L).championTier("1Tier").build();
        ChampionResponseDto championResponseDto3 = ChampionResponseDto
                .builder().championId(51L).championTier("1Tier").build();

        return List.of(championResponseDto1,championResponseDto2, championResponseDto3);
    }

    /**
     * 현재게임에서 사용가능한 챔피언리스트를 반환해준다.
     * @size 3
     * @return List<ChampionResponseDto>
     */
    public List<ChampionResponseDto> createRemoveDisableChampionList() {
        ChampionResponseDto championResponseDto1 = ChampionResponseDto
                .builder().championId(143L).championTier("1Tier").build();
        ChampionResponseDto championResponseDto2 = ChampionResponseDto
                .builder().championId(121L).championTier("2Tier").build();
        ChampionResponseDto championResponseDto3 = ChampionResponseDto
                .builder().championId(113L).championTier("1Tier").build();
        return List.of(championResponseDto1, championResponseDto2, championResponseDto3);
    }

    /**
     * 현재게임에서 사용가능한 챔피언리스트를 반환해준다.
     * @size 2
     * @return List<ChampionResponseDto>
     */
    public List<ChampionResponseDto> createRemoveDisableChampionListMinus() {
        ChampionResponseDto championResponseDto1 = ChampionResponseDto
                .builder().championId(143L).championTier("1Tier").build();
        ChampionResponseDto championResponseDto2 = ChampionResponseDto
                .builder().championId(121L).championTier("2Tier").build();
        return List.of(championResponseDto1, championResponseDto2);
    }

    /**
     * 티어별로 정렬된 챔피언 Dto의 리스트
     * @size 3
     * @return List<ChampionResponseDto>
     */
    public List<ChampionResponseDto> createSortTierChampionList() {
        ChampionResponseDto championResponseDto1 = ChampionResponseDto
                .builder().championId(143L).championTier("1Tier").build();
        ChampionResponseDto championResponseDto2 = ChampionResponseDto
                .builder().championId(121L).championTier("2Tier").build();
        ChampionResponseDto championResponseDto3 = ChampionResponseDto
                .builder().championId(121L).championTier("2Tier").build();
        return List.of(championResponseDto1, championResponseDto2, championResponseDto3);
    }

    /**
     * removeDisableChampTest에 사용되기위한 Input 챔피언Dto 리스트.
     * 1번, 3번, 6번, 143번, 121번, 113번 챔피언Dto를 포함하고있다.
     * @size 6
     * @return List<ChampionResponseDto>
     */
    public List<ChampionResponseDto> createChampionListForInputRemoveTest() {
        ChampionResponseDto championResponseDto1 = ChampionResponseDto
                .builder().championId(1L).championTier("1Tier").build();
        ChampionResponseDto championResponseDto2 = ChampionResponseDto
                .builder().championId(3L).championTier("1Tier").build();
        ChampionResponseDto championResponseDto3 = ChampionResponseDto
                .builder().championId(6L).championTier("1Tier").build();
        ChampionResponseDto championResponseDto4 = ChampionResponseDto
                .builder().championId(143L).championTier("1Tier").build();
        ChampionResponseDto championResponseDto5 = ChampionResponseDto
                .builder().championId(121L).championTier("2Tier").build();
        ChampionResponseDto championResponseDto6 = ChampionResponseDto
                .builder().championId(113L).championTier("1Tier").build();
        return List.of(championResponseDto1, championResponseDto2, championResponseDto3, championResponseDto4, championResponseDto5, championResponseDto6);
    }
}
