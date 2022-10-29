package com.pickban.ggbackend.recommendpick.utill;

public enum ApiParamEnum {

    TEAM("B"),
    LINE("mid"),
    EMLINE("Viktor"),
    TEAMCHAMP("Sejuani_Camille"),
    EMCHAMP("Aphelios_LeeSin"),
    BAN("Amumu_Bard_Annie_Akali_Aatrox_Ezreal");

    private final String value;

    ApiParamEnum(String value) {
        this.value = value;
    }

    public String get() {
        return value;
    }
}
