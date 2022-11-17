package com.pickban.ggbackend.recommendpick.enummodel;

public enum TeamEnum {
    BLUE("Blue"),
    RED("Red");

    private final String value;

    TeamEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
