package com.pickban.ggbackend.recommendpick.presentation;


import com.google.gson.Gson;
import com.pickban.ggbackend.recommendpick.application.RecommendPickFacade;
import com.pickban.ggbackend.recommendpick.dto.RecommendPickResponseDto;
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

import java.util.stream.Stream;

import static com.pickban.ggbackend.ApiDocumentUtils.getRequestPreProcessor;
import static com.pickban.ggbackend.ApiDocumentUtils.getResponsePreProcessor;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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

    @InjectMocks
    private RecommendDtoFactory recommendDtoFactory;


    @DisplayName("밴픽 추천 리스트 Presentation Layer")
    @TestFactory
    Stream<DynamicTest> dynamicTests(){

        final RecommendPickResponseDto recommendPickResponseDto =
                recommendDtoFactory.createRecommendPickResponseDtoMid();

        final String ver = ApiParamEnum.VER.get();
        final String line = ApiParamEnum.LINE.get();
        final String emLineChamp = ApiParamEnum.EMLINECHAMP.get();
        final String teamChamp = ApiParamEnum.TEAMCHAMP.get();
        final String emTeamChamp = ApiParamEnum.EMTEAMCHAMP.get();
        final String ban = ApiParamEnum.BAN.get();

        return Stream.of(
                DynamicTest.dynamicTest("밴픽 추천 리스트를 조회한다.",
                        ()->{
                    given(recommendPickFacade.getRecommend(Mockito.anyString(),
                            Mockito.anyString(),
                            Mockito.anyString(),
                            Mockito.anyString(),
                            Mockito.anyString())).willReturn(recommendPickResponseDto);
                    ResultActions actions = mockMvc.perform(
                            get("/api/{ver}", ver)
                                    .param("line", line)
                                    .param("ban", ban)
                                    .param("emLineChamp", emLineChamp)
                                    .param("teamChamp", teamChamp)
                                    .param("emTeamChamp",emTeamChamp)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .contentType(MediaType.APPLICATION_JSON)
                            );
                    actions.andExpect(status().isOk())
                            .andDo(document(
                                    "get-recommend",
                                    getRequestPreProcessor(),
                                    getResponsePreProcessor(),
                                    pathParameters(
                                            parameterWithName("ver").description("LOL 버전 (필수입력)")
                                    ),
                                    requestParameters(
                                            parameterWithName("line").description("선택라인 (필수입력)"),
                                            parameterWithName("ban").description("밴 챔피언 (필수입력)"),
                                            parameterWithName("emLineChamp").description("상대라이너 챔피언 (선택입력)"),
                                            parameterWithName("teamChamp").description("아군 챔피언 (선택입력)"),
                                            parameterWithName("emTeamChamp").description("적군 챔피언 (선택입력)")
                                    ),
                                    responseFields(
                                            fieldWithPath("position").type(JsonFieldType.STRING).description("선택 포지션"),
                                            fieldWithPath("recommendPickList").type(JsonFieldType.ARRAY).description("추천 리스트"),
                                            fieldWithPath("recommendPickList[].recommendChamp").type(JsonFieldType.STRING).description("추천 챔피언"),
                                            fieldWithPath("recommendPickList[].recommendRank").type(JsonFieldType.STRING).description("추천점수"),
                                            fieldWithPath("recommendPickList[].champTier").type(JsonFieldType.STRING).description("챔피언 티어"),
                                            fieldWithPath("progamerPickList").type(JsonFieldType.ARRAY).description("프로게이머 픽"),
                                            fieldWithPath("progamerPickList[].proName").type(JsonFieldType.STRING).description("프로게이머 이름"),
                                            fieldWithPath("progamerPickList[].proNickname").type(JsonFieldType.STRING).description("프로게이머 닉네임"),
                                            fieldWithPath("progamerPickList[].championName").type(JsonFieldType.STRING).description("프로게이머 챔피언")
                                    )
                            ));

                })
        );
    }
}
