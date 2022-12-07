package com.pickban.ggbackend.recommendpick.domain.processor.match;


import com.pickban.ggbackend.recommendpick.domain.processor.MatchProcessorImpl;
import com.pickban.ggbackend.recommendpick.dto.ChampionResponseDto;
import com.pickban.ggbackend.recommendpick.utill.RecommendDtoFactory;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * 픽 못하는 챔피언을 추천챔피언리스트에서 제외시켜준다.
 *
 */
@ExtendWith(MockitoExtension.class)
public class RemoveDisableChampTests {

    @InjectMocks
    private MatchProcessorImpl matchProcessor;

    @InjectMocks
    private RecommendDtoFactory recommendDtoFactory;


    @TestFactory
    @DisplayName("processor layer MatchProcessor removeDisableChamp method 테스트")
    Stream<DynamicTest> removeDisableChamp(){

        final List<ChampionResponseDto> championResponseDtoList = recommendDtoFactory.createChampionListForInputRemoveTest();
        final String disableChampList = "1_2_3_4_5_6";
        final String disableChampListIsBlank = "0_0_0_0";
        final String disableChampListIsError = "____%$#";
        final List<ChampionResponseDto> removedChampList = recommendDtoFactory.createRemoveDisableChampionList();

        return Stream.of(
                DynamicTest.dynamicTest("성공케이스: 비활성화 챔피언을 리스트에서 제외시켜준다.", ()-> {


                    List<ChampionResponseDto> resultList =
                            matchProcessor.removeDisableChamp(championResponseDtoList, disableChampList);


                    assertThat(resultList.get(0).getChampionId(), equalTo(removedChampList.get(0).getChampionId()));
                    assertThat(resultList.get(2).getChampionId(), equalTo(removedChampList.get(2).getChampionId()));
                    assertThat(resultList.size(), equalTo(removedChampList.size()));
                }),
                DynamicTest.dynamicTest("성공케이스: 비활성화 챔피언이 없을경우(isBlank) 그대로 리턴해준다.", ()-> {


                    List<ChampionResponseDto> resultList =
                            matchProcessor.removeDisableChamp(championResponseDtoList, disableChampListIsBlank);


                    assertThat(resultList.get(0).getChampionId(), equalTo(championResponseDtoList.get(0).getChampionId()));
                    assertThat(resultList.size(), equalTo(championResponseDtoList.size()));
                }),
                DynamicTest.dynamicTest("실패케이스: 비활성화 챔피언이 없을경우(Null) 예외를 던져준다.", ()-> {

                    assertThatThrownBy(() -> matchProcessor.removeDisableChamp(championResponseDtoList, null))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("Error DisableChampList");
                }),
                DynamicTest.dynamicTest("실패케이스: 비활성챔피언 리스트의 입력포멧이 잘못된경우 예외를 던져준다.", ()-> {

                    Exception exception = Assertions.assertThrows(Exception.class, () -> {
                        matchProcessor.removeDisableChamp(championResponseDtoList, disableChampListIsError);
                    });

                    assertThat(exception.getMessage(), equalTo("Validate Error DisableChampList"));
                })
        );
    }
}
