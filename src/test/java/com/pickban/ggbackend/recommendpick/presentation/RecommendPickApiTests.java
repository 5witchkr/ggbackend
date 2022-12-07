package com.pickban.ggbackend.recommendpick.presentation;


import com.google.gson.Gson;
import com.pickban.ggbackend.recommendpick.application.RecommendPickFacade;
import com.pickban.ggbackend.recommendpick.domain.MockDataSave;
import com.pickban.ggbackend.recommendpick.dto.ProgamerPickDto;
import com.pickban.ggbackend.recommendpick.dto.RecommendPickDto;
import com.pickban.ggbackend.recommendpick.dto.RecommendRequestDto;
import com.pickban.ggbackend.recommendpick.utill.ApiParamEnum;
import com.pickban.ggbackend.recommendpick.utill.RecommendDtoFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;

import org.junit.jupiter.api.TestFactory;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;
import java.util.stream.Stream;

import static com.pickban.ggbackend.ApiDocumentUtils.getRequestPreProcessor;
import static com.pickban.ggbackend.ApiDocumentUtils.getResponsePreProcessor;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RecommendPickApi.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
public class RecommendPickApiTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @MockBean
    private RecommendPickFacade recommendPickFacade;

    @MockBean
    private MockDataSave mockDataSave;

    @InjectMocks
    private RecommendDtoFactory recommendDtoFactory;


    @DisplayName("밴픽 추천 리스트 Presentation Layer")
    @TestFactory
    Stream<DynamicTest> dynamicTests(){

        final List<RecommendPickDto> recommendPickDtoList =
                recommendDtoFactory.createRecommendPickDtoMid();

        final List<ProgamerPickDto> progamerPickDtoList =
                recommendDtoFactory.createProgamerPickDtoMid();

        final String team = ApiParamEnum.TEAM.get();
        final String line = ApiParamEnum.LINE.get();
        final String bans = ApiParamEnum.BANS.get();
        final String emBans = ApiParamEnum.EM_BANS.get();
        final String picks = ApiParamEnum.PICKS.get();
        final String emPicks = ApiParamEnum.EM_PICKS.get();

        return Stream.of(
                DynamicTest.dynamicTest("밴픽 추천 리스트를 조회한다.",
                        ()->{
                    given(recommendPickFacade.getRecommend(
                            Mockito.anyString(),
                            Mockito.anyString(),
                            Mockito.any(RecommendRequestDto.class))).willReturn(recommendPickDtoList);
                    ResultActions actions = mockMvc.perform(
                            get("/api/recommend")
                                    .param("team", team)
                                    .param("line", line)
                                    .param("bans", bans)
                                    .param("emBans", emBans)
                                    .param("picks", picks)
                                    .param("emPicks",emPicks)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .contentType(MediaType.APPLICATION_JSON)
                            );
                    actions.andExpect(status().isOk())
                            .andDo(document(
                                    "get-recommend",
                                    getRequestPreProcessor(),
                                    getResponsePreProcessor(),
                                    requestParameters(
                                            parameterWithName("team").description("팀 진영 (필수입력) value=[B, R]"),
                                            parameterWithName("line").description("선택라인 (필수입력) value=[top, jg, mid, adc, sup]"),
                                            parameterWithName("bans").description("아군 밴 챔피언목록 (선택입력)").optional(),
                                            parameterWithName("emBans").description("적군 밴 챔피언목록 (선택입력)").optional(),
                                            parameterWithName("picks").description("아군 챔피언목록 (선택입력)").optional(),
                                            parameterWithName("emPicks").description("적군 챔피언목록 (선택입력)").optional()
                                    ),
                                    responseFields(
                                            fieldWithPath("[]").type(JsonFieldType.ARRAY).description("추천 챔피언 목록"),
                                            fieldWithPath("[].championId").type(JsonFieldType.NUMBER).description("추천 챔피언 ID"),
                                            fieldWithPath("[].championTier").type(JsonFieldType.STRING).description("추천 챔피언 티어")
                                    )
                            ));

                }),
                DynamicTest.dynamicTest("프로그래머밴픽 추천 리스트를 조회한다.",
                        ()->{
                            given(recommendPickFacade.getRecommendProgamer(
                                    Mockito.anyString(),
                                    Mockito.anyString(),
                                    Mockito.any(RecommendRequestDto.class))).willReturn(progamerPickDtoList);
                            ResultActions actions = mockMvc.perform(
                                    get("/api/recommend/progamer")
                                            .param("team", team)
                                            .param("line", line)
                                            .param("bans", bans)
                                            .param("emBans", emBans)
                                            .param("picks", picks)
                                            .param("emPicks",emPicks)
                                            .accept(MediaType.APPLICATION_JSON)
                                            .contentType(MediaType.APPLICATION_JSON)
                            );
                            actions.andExpect(status().isOk())
                                    .andDo(document(
                                            "get-recommend-progamer",
                                            getRequestPreProcessor(),
                                            getResponsePreProcessor(),
                                            requestParameters(
                                                    parameterWithName("team").description("팀 진영 (필수입력) value=[B, R]"),
                                                    parameterWithName("line").description("선택라인 (필수입력) value=[top, jg, mid, adc, sup]"),
                                                    parameterWithName("bans").description("아군 밴 챔피언목록 (선택입력)").optional(),
                                                    parameterWithName("emBans").description("적군 밴 챔피언목록 (선택입력)").optional(),
                                                    parameterWithName("picks").description("아군 챔피언목록 (선택입력)").optional(),
                                                    parameterWithName("emPicks").description("적군 챔피언목록 (선택입력)").optional()
                                            ),
                                            responseFields(
                                                    fieldWithPath("[]").type(JsonFieldType.ARRAY).description("추천 프로게이머 목록"),
                                                    fieldWithPath("[].progamerName").type(JsonFieldType.STRING).description("프로게이머 이름"),
                                                    fieldWithPath("[].progamerNickname").type(JsonFieldType.STRING).description("프로게이머 닉네임"),
                                                    fieldWithPath("[].recommendPickDto").type(JsonFieldType.OBJECT).description("프로게이머 추천 챔피언"),
                                                    fieldWithPath("[].recommendPickDto.championId").type(JsonFieldType.NUMBER).description("프로게이머 챔피언 ID"),
                                                    fieldWithPath("[].recommendPickDto.championTier").type(JsonFieldType.STRING).description("프로게이머 챔피언 티어")
                                            )
                                    ));

                        })
        );
    }
}
