package com.pickban.ggbackend.recommendpick.domain.processor.match;

import com.pickban.ggbackend.recommendpick.domain.processor.MatchProcessorImpl;
import com.pickban.ggbackend.recommendpick.dto.ChampionResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@ExtendWith(MockitoExtension.class)
public class TierSortTests {

    @InjectMocks
    private MatchProcessorImpl matchProcessor;


    @TestFactory
    @DisplayName("processor layer MatchProcessor tierSort method 테스트")
    Stream<DynamicTest> tierSortTest() {

        //todo refactor
        final int returnSize = 3;

        final List<ChampionResponseDto> beforeTierSort = new ArrayList<>(
                List.of(
                        ChampionResponseDto.builder().opScore(90L).build(),
                        ChampionResponseDto.builder().opScore(100L).build(),
                        ChampionResponseDto.builder().opScore(80L).build(),
                        ChampionResponseDto.builder().opScore(77L).build()
                )
        );
        final List<ChampionResponseDto> afterTierSort = new ArrayList<>(
                List.of(
                        ChampionResponseDto.builder().opScore(100L).build(),
                        ChampionResponseDto.builder().opScore(90L).build(),
                        ChampionResponseDto.builder().opScore(80L).build()
                )
        );

        return Stream.of(
                DynamicTest.dynamicTest("점수(OPScore)순으로 정렬한다.", () -> {
                    List<ChampionResponseDto> result = matchProcessor.tierSort(beforeTierSort);

                    assertThat(result.get(0).getOpScore())
                            .isEqualTo(afterTierSort.get(0).getOpScore());
                    assertThat(result.get(1).getOpScore())
                            .isEqualTo(afterTierSort.get(1).getOpScore());

                }),

                DynamicTest.dynamicTest("상위 3개만 리턴한다.", () -> {
                    List<ChampionResponseDto> result = matchProcessor.tierSort(beforeTierSort);

                    assertThat(result.size()).isEqualTo(returnSize);
                })
        );
    }
}
