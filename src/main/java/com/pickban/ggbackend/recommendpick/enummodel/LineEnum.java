package com.pickban.ggbackend.recommendpick.enummodel;

public enum LineEnum {

    TOP("top"),
    JG("jg"),
    MID("mid"),
    ADC("adc"),
    SUP("sup");

    private final String value;

    LineEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
