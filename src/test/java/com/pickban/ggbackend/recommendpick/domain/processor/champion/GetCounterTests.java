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

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class GetCounterTests {

    @InjectMocks
    private ChampionProcessorImpl championProcessor;

    @Mock
    private ChampionRepository championRepository;

    @Mock
    private ChampionMapper championMapper;

    @TestFactory
    @DisplayName("processor layer championProcessor GetCounterTests method 테스트")
    Stream<DynamicTest> getCounterTest() {
        //todo refactor
        final String emLineChamp = "266";

        final Champion champion = Champion.builder()
                .championId(266L).championName("Aatrox").counters(List.of(1L,2L,3L)).build();
        final ChampionResponseDto championResponseDto = ChampionResponseDto.builder().build();

        return Stream.of(
                DynamicTest.dynamicTest("카운터 챔피언을 불러온다.", () -> {
                    given(championRepository.findByChampionId(Mockito.anyLong()))
                            .willReturn(Optional.ofNullable(champion));
                    given(championMapper.championToChampionResponseDto(Mockito.any(Champion.class)))
                            .willReturn(championResponseDto);

                    championProcessor.getCounter(emLineChamp);

                    then(championRepository).should(times(4))
                            .findByChampionId(Mockito.anyLong());
                    then(championMapper).should(times(3))
                            .championToChampionResponseDto(Mockito.any(Champion.class));

                }),

                DynamicTest.dynamicTest("일치하는 챔피언 id가 없을경우 예외를 던져준다.", () -> {
                })
        );
    }
}
