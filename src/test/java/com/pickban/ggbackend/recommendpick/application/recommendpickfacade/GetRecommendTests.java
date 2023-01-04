package com.pickban.ggbackend.recommendpick.application.recommendpickfacade;


import com.pickban.ggbackend.recommendpick.application.RecommendPickFacadeImpl;
import com.pickban.ggbackend.recommendpick.application.mapper.RecommendPickMapper;
import com.pickban.ggbackend.recommendpick.domain.processor.ChampionProcessor;
import com.pickban.ggbackend.recommendpick.domain.processor.MatchProcessor;
import com.pickban.ggbackend.recommendpick.dto.ChampionResponseDto;
import com.pickban.ggbackend.recommendpick.dto.RecommendPickDto;
import com.pickban.ggbackend.recommendpick.dto.RecommendRequestDto;
import com.pickban.ggbackend.recommendpick.utill.ApiParamEnum;
import com.pickban.ggbackend.recommendpick.utill.RecommendDtoFactory;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
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


    private List<RecommendPickDto> recommendPickDtos;
    private List<ChampionResponseDto> championResponseDtos;
    private String team;
    private String line;
    private RecommendRequestDto recommendRequestDto;

    @BeforeEach
    public void setup() {
        recommendPickDtos = new ArrayList<>();
        championResponseDtos = new ArrayList<>();
        team = ApiParamEnum.TEAM.get();
        line = ApiParamEnum.LINE.get();
        recommendRequestDto = RecommendRequestDto
                .builder()
                .bans(ApiParamEnum.BANS.get())
                .emBans(ApiParamEnum.EM_BANS.get())
                .picks(ApiParamEnum.PICKS.get())
                .emPicks( ApiParamEnum.EM_PICKS.get())
                .build();
    }

    @Nested
    @DisplayName("application layer Facade getRecommend method 테스트")
    class successCase {
        @Test
        @DisplayName("성공케이스 호출확인")
        public void successTest1() throws Exception {
            //give
            given(matchProcessor.removeDisableChamp(Mockito.anyList(), Mockito.anyString()))
                    .willReturn(championResponseDtos);
            given(matchProcessor.tierSort(Mockito.anyList()))
                    .willReturn(championResponseDtos);
            given(championProcessor.getLineChampion(Mockito.anyString()))
                    .willReturn(championResponseDtos);
            given(recommendPickMapper.champResDtoListToRecommendPickDtoList(Mockito.anyList()))
                    .willReturn(recommendPickDtos);

            //when
            List<RecommendPickDto> result = recommendPickFacade
                    .getRecommend(team, line, recommendRequestDto);

            //then
            then(matchProcessor).should(times(1)).removeDisableChamp(anyList(),anyString());
            then(matchProcessor).should(times(1)).tierSort(anyList());
            then(championProcessor).should(times(1)).getLineChampion(anyString());
            then(recommendPickMapper).should(times(1)).champResDtoListToRecommendPickDtoList(anyList());
        }
    }
}
