package com.pickban.ggbackend.recommendpick.enummodel;

public enum TierEnum {
    TIER1("1Tier"),
    TIER2("2Tier"),
    TIER3("3Tier"),
    TIER4("4Tier"),
    TIER5("5Tier");

    private final String value;

    TierEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
