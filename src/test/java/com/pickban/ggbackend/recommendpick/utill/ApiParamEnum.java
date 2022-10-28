package com.pickban.ggbackend.recommendpick.utill;

public enum ApiParamEnum {
    VER("156ver"),
    LINE("mid"),
    EMLINECHAMP("Viktor"),
    TEAMCHAMP("Sejuani_Camille"),
    EMTEAMCHAMP("Aphelios_LeeSin"),
    BAN("Amumu_Bard_Annie_Akali_Aatrox_Ezreal");

    private final String value;

    ApiParamEnum(String value) {
        this.value = value;
    }

    public String get() {
        return value;
    }
}
