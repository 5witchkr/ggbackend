package com.pickban.ggbackend.recommendpick.application.recommendpickfacade;


import com.pickban.ggbackend.recommendpick.application.RecommendPickFacadeImpl;
import com.pickban.ggbackend.recommendpick.application.mapper.RecommendPickMapper;
import com.pickban.ggbackend.recommendpick.domain.processor.ChampionProcessor;
import com.pickban.ggbackend.recommendpick.domain.processor.MatchProcessor;
import com.pickban.ggbackend.recommendpick.dto.ChampionResponseDto;
import com.pickban.ggbackend.recommendpick.dto.RecommendPickDto;
import com.pickban.ggbackend.recommendpick.utill.ApiParamEnum;
import com.pickban.ggbackend.recommendpick.utill.RecommendDtoFactory;
import org.junit.jupiter.api.*;
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


    private List<RecommendPickDto> recommendPickDtoList;
    private List<ChampionResponseDto> counterChampionList;
    private List<ChampionResponseDto> highTierChampionList;
    private List<ChampionResponseDto> removeDisableChampionList;
    private List<ChampionResponseDto> removeDisableChampionListMinus;
    private List<ChampionResponseDto> sortTierChampionList;
    private String team;
    private String line;
    private String emLine;
    private String teamChamp;
    private String emChamp;
    private String ban;

    @BeforeEach
    public void setup() {
        recommendPickDtoList = recommendDtoFactory.createRecommendPickDtoMid();
        counterChampionList = recommendDtoFactory.createCounterChampionList();
        highTierChampionList = recommendDtoFactory.createHighTierChampionList();
        removeDisableChampionList = recommendDtoFactory.createRemoveDisableChampionList();
        removeDisableChampionListMinus = recommendDtoFactory.createRemoveDisableChampionListMinus();
        sortTierChampionList = recommendDtoFactory.createSortTierChampionList();
        team = ApiParamEnum.TEAM.get();
        line = ApiParamEnum.LINE.get();
        emLine = ApiParamEnum.EMLINE.get();
        teamChamp = ApiParamEnum.TEAMCHAMP.get();
        emChamp = ApiParamEnum.EMCHAMP.get();
        ban = ApiParamEnum.BAN.get();
    }

    @Nested
    @DisplayName("application layer Facade getRecommend method 테스트")
    class successCase {
        @Test
        @DisplayName("성공케이스1: 상대라인 챔피언을 알고있을때 밴픽 추천리스트를 반환한다.")
        public void successTest1() throws Exception {
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
            given(matchProcessor.removeDisableChamp(Mockito.anyList(), Mockito.anyString()))
                    .willReturn(removeDisableChampionList);
            given(matchProcessor.tierSort(Mockito.anyList()))
                    .willReturn(sortTierChampionList);
            given(recommendPickMapper.champResDtoListToRecommendPickDtoList(Mockito.anyList()))
                    .willReturn(recommendPickDtoList);

            //when
            List<RecommendPickDto> result = recommendPickFacade
                    .getRecommend(team, line, ban, emLine, teamChamp, emChamp);

            //then
            then(championProcessor).should(times(1)).getCounter(anyString());
            then(championProcessor).should(times(0)).getTopTier(anyString());
            then(matchProcessor).should(times(1)).removeDisableChamp(anyList(),anyString());
            then(matchProcessor).should(times(1)).tierSort(anyList());
            then(recommendPickMapper).should(times(1)).champResDtoListToRecommendPickDtoList(anyList());
            assertThat(result.size(), equalTo(3));
        }

        @Test
        @DisplayName("성공케이스2: 상대라인 챔피언을 알지만 높은티어 추천리스트를 반환한다.")
        public void successTest2() throws Exception {
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
                    .willReturn(removeDisableChampionListMinus);
            given(matchProcessor.tierSort(Mockito.anyList()))
                    .willReturn(sortTierChampionList);
            given(recommendPickMapper.champResDtoListToRecommendPickDtoList(Mockito.anyList()))
                    .willReturn(recommendPickDtoList);

            //when
            List<RecommendPickDto> result = recommendPickFacade
                    .getRecommend(team, line, ban, emLine, teamChamp, emChamp);

            //then
            then(championProcessor).should(times(1)).getCounter(anyString());
            then(championProcessor).should(times(1)).getTopTier(anyString());
            then(matchProcessor).should(times(1)).removeDisableChamp(anyList(),anyString());
            then(matchProcessor).should(times(1)).tierSort(anyList());
            then(recommendPickMapper).should(times(1)).champResDtoListToRecommendPickDtoList(anyList());
            assertThat(result.size(), equalTo(3));
        }

        @Test
        @DisplayName("성공케이스3: 상대라인 챔피언을 모를때 높은티어 추천리스트를 반환한다.")
        public void successTest3() throws Exception {
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
                    .getRecommend(team, line, ban, null, teamChamp, emChamp);

            //then
            then(championProcessor).should(times(1)).getTopTier(anyString());
            then(matchProcessor).should(times(1)).removeDisableChamp(anyList(),anyString());
            then(matchProcessor).should(times(1)).tierSort(anyList());
            then(recommendPickMapper).should(times(1)).champResDtoListToRecommendPickDtoList(anyList());
            assertThat(result.size(), equalTo(3));
        }
    }
}
