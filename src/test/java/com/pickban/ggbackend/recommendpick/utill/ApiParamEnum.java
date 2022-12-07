package com.pickban.ggbackend.recommendpick.utill;

public enum ApiParamEnum {

    TEAM("B"),  //Blue팀
    LINE("mid"),    //미드라인
    EMLINE("90"),   //빅토르
    TEAMCHAMP("91_134"),    //세주아니, 카밀
    EMCHAMP("147_73"),  //아펠리오스, 리신
    BAN("124_51_114_47");    //바드, 아칼리, 아트록스, 이즈리얼

    private final String value;

    ApiParamEnum(String value) {
        this.value = value;
    }

    public String get() {
        return value;
    }
}
