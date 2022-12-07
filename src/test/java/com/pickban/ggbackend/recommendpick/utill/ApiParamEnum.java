package com.pickban.ggbackend.recommendpick.utill;

public enum ApiParamEnum {

    TEAM("B"),  //Blue팀
    LINE("mid"),    //미드라인
    PICKS("91_134"),    //세주아니, 카밀
    EM_PICKS("147_73"),  //아펠리오스, 리신
    BANS("124_51_114"),  //바드, 아칼리, 아트록스
    EM_BANS("90_47");    //빅토르, 이즈리얼

    private final String value;

    ApiParamEnum(String value) {
        this.value = value;
    }

    public String get() {
        return value;
    }
}
