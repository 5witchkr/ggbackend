package com.pickban.ggbackend.recommendpick.domain.processor.champion;


import com.pickban.ggbackend.recommendpick.domain.entity.Champion;
import com.pickban.ggbackend.recommendpick.domain.processor.ChampionProcessorImpl;
import com.pickban.ggbackend.recommendpick.domain.processor.mapper.ChampionMapper;
import com.pickban.ggbackend.recommendpick.domain.repository.ChampionRepository;
import com.pickban.ggbackend.recommendpick.dto.ChampionResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class GetLineChampionTests {
    @InjectMocks
    private ChampionProcessorImpl championProcessor;

    @Mock
    private ChampionRepository championRepository;

    @Mock
    private ChampionMapper championMapper;

    @TestFactory
    @DisplayName("processor layer championProcessor GetLineChampion method 테스트")
    Stream<DynamicTest> getLineChampionTest() {
        final List<Champion> champions = new ArrayList<>();
        final List<ChampionResponseDto> championResponseDtos = new ArrayList<>();

        return Stream.of(
                DynamicTest.dynamicTest("해당라인의 챔피언리스트를 가져온다.", () -> {
                    given(championRepository.findByPosition(Mockito.anyString()))
                            .willReturn(champions);
                    given(championMapper.championListToChampionResponseDtoList(Mockito.anyList()))
                            .willReturn(championResponseDtos);

                    championProcessor.getLineChampion("mid");

                    then(championRepository).should(times(1))
                            .findByPosition(Mockito.anyString());
                    then(championMapper).should(times(1))
                            .championListToChampionResponseDtoList(Mockito.anyList());

                })
        );
    }
}

