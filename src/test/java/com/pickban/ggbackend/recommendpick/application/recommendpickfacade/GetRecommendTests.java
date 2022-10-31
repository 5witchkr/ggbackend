package com.pickban.ggbackend.recommendpick.application.recommendpickfacade;


import com.pickban.ggbackend.recommendpick.application.RecommendPickFacadeImpl;
import com.pickban.ggbackend.recommendpick.application.mapper.RecommendPickMapper;
import com.pickban.ggbackend.recommendpick.domain.processor.ChampionProcessor;
import com.pickban.ggbackend.recommendpick.domain.processor.MatchProcessor;
import com.pickban.ggbackend.recommendpick.dto.ChampionResponseDto;
import com.pickban.ggbackend.recommendpick.dto.RecommendPickDto;
import com.pickban.ggbackend.recommendpick.utill.ApiParamEnum;
import com.pickban.ggbackend.recommendpick.utill.RecommendDtoFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class GetRecommendTests {

    @Mock
    private ChampionProcessor championProcessor;

    @Mock
    private MatchProcessor matchProcessor;

    @Mock
    private RecommendPickMapper recommendPickMapper;

    @InjectMocks
    private RecommendPickFacadeImpl recommendPickFacade;

    @InjectMocks
    private RecommendDtoFactory recommendDtoFactory;

    @TestFactory
    @DisplayName("application layer Facade getRecommend method 테스트")
    Stream<DynamicTest> getRecommend(){

        final List<RecommendPickDto> recommendPickDtoList =
                recommendDtoFactory.createRecommendPickDtoMid();

        final List<ChampionResponseDto> counterChampionList =
                recommendDtoFactory.createCounterChampionList();

        final List<ChampionResponseDto> highTierChampionList =
                recommendDtoFactory.createHighTierChampionList();

        final List<ChampionResponseDto> removeDisableChampionList =
                recommendDtoFactory.createRemoveDisableChampionList();

        final List<ChampionResponseDto> sortTierChampionList =
                recommendDtoFactory.createSortTierChampionList();

        final String team = ApiParamEnum.TEAM.get();
        final String line = ApiParamEnum.LINE.get();
        final String emLine = ApiParamEnum.EMLINE.get();
        final String teamChamp = ApiParamEnum.TEAMCHAMP.get();
        final String emChamp = ApiParamEnum.EMCHAMP.get();
        final String ban = ApiParamEnum.BAN.get();

        return Stream.of(
                DynamicTest.dynamicTest("성공케이스1: 상대라인 챔피언을 알고있을때 밴픽 추천리스트를 반환한다.", ()-> {
                    //if (emChamp) champList = counter(emChamp);
                    //(상대챔피언의 카운터챔피언을 선정한다)
                    //그중 밴이거나 이미 선택된것들을 제거한다.
                    //비어있는 배열인지 확인한다.
                    //(높은 티어순으로 정렬한다.)
                    //tierSort(champList);
                    //dto mapper로 매핑해준다.

                    //give
                    given(championProcessor.getCounter(Mockito.anyString()))
                            .willReturn(counterChampionList);
                    given(championProcessor.getTopTier(Mockito.anyString()))
                            .willReturn(highTierChampionList);
                    given(matchProcessor.removeDisableChamp(Mockito.anyList(), Mockito.anyString()))
                            .willReturn(removeDisableChampionList);
                    given(matchProcessor.tierSort(Mockito.anyList()))
                            .willReturn(sortTierChampionList);
                    given(recommendPickMapper.champResDtoListToRecommendPickDtoList(Mockito.anyList()))
                            .willReturn(recommendPickDtoList);

                    //when
                    List<RecommendPickDto> result = recommendPickFacade
                            .getRecommend(team, line, emLine, teamChamp, emChamp, ban);

                    //then
                    then(championProcessor).should(times(1)).getCounter(anyString());
                    then(championProcessor).should(times(1)).getTopTier(anyString());
                    then(matchProcessor).should(times(1)).removeDisableChamp(anyList(),anyString());
                    then(matchProcessor).should(times(1)).tierSort(anyList());
                    then(recommendPickMapper).should(times(1)).champResDtoListToRecommendPickDtoList(anyList());
                    assertThat(result.size(), equalTo(3));
                }),
                DynamicTest.dynamicTest("성공케이스2: 상대라인 챔피언을 모를때 높은티어 추천리스트를 반환한다.", () -> {
                    //(해당라인의 높은티어 챔피언을 가져온다.)
                    //if (!chmaplist) champList = toptier(line);
                    //그중 밴이거나 이미 선택된것들을 제거한다.
                    //비어있는 배열인지 확인한다.
                    //(높은 티어순으로 정렬한다.)
                    //tierSort(champList);
                    //dto mapper로 매핑해준다.

                    //given
                    given(championProcessor.getTopTier(Mockito.anyString()))
                            .willReturn(highTierChampionList);
                    given(matchProcessor.removeDisableChamp(Mockito.anyList(), Mockito.anyString()))
                            .willReturn(removeDisableChampionList);
                    given(matchProcessor.tierSort(Mockito.anyList()))
                            .willReturn(sortTierChampionList);
                    given(recommendPickMapper.champResDtoListToRecommendPickDtoList(Mockito.anyList()))
                            .willReturn(recommendPickDtoList);

                    //when
                    List<RecommendPickDto> result = recommendPickFacade
                            .getRecommend(team, line, emLine, teamChamp, emChamp, ban);

                    //then
                    then(championProcessor).should(times(0)).getCounter(anyString());
                    then(championProcessor).should(times(1)).getTopTier(anyString());
                    then(matchProcessor).should(times(1)).removeDisableChamp(anyList(),anyString());
                    then(matchProcessor).should(times(1)).tierSort(anyList());
                    then(recommendPickMapper).should(times(1)).champResDtoListToRecommendPickDtoList(anyList());
                    assertThat(result.size(), equalTo(3));
                }),
                DynamicTest.dynamicTest("성공케이스3: 상대라인 챔피언을 알지만 높은티어 추천리스트를 반환한다.", () -> {
                    //if (emChamp) champList = counter(emChamp);
                    //(상대챔피언의 카운터챔피언을 선정한다)
                    //그중 밴이거나 이미 선택된것들을 제거한다.
                    //비어있는 배열인지 확인한다.
                    //챔피언이 남지않았을경우 높은티어를 가져온다.
                    //if (!chmaplist) champList = toptier(line);
                    //(높은 티어순으로 정렬한다.)
                    //tierSort(champList);
                    //dto mapper로 매핑해준다.

                    //given
                    given(championProcessor.getCounter(Mockito.anyString()))
                            .willReturn(counterChampionList);
                    given(championProcessor.getTopTier(Mockito.anyString()))
                            .willReturn(highTierChampionList);
                    given(matchProcessor.removeDisableChamp(Mockito.anyList(), Mockito.anyString()))
                            .willReturn(removeDisableChampionList);
                    given(matchProcessor.tierSort(Mockito.anyList()))
                            .willReturn(sortTierChampionList);
                    given(recommendPickMapper.champResDtoListToRecommendPickDtoList(Mockito.anyList()))
                            .willReturn(recommendPickDtoList);

                    //when
                    List<RecommendPickDto> result = recommendPickFacade
                            .getRecommend(team, line, emLine, teamChamp, emChamp, ban);

                    //then
                    then(championProcessor).should(times(1)).getCounter(anyString());
                    then(championProcessor).should(times(1)).getTopTier(anyString());
                    then(matchProcessor).should(times(1)).removeDisableChamp(anyList(),anyString());
                    then(matchProcessor).should(times(1)).tierSort(anyList());
                    then(recommendPickMapper).should(times(1)).champResDtoListToRecommendPickDtoList(anyList());
                    assertThat(result.size(), equalTo(3));
                })
        );
    }
}
