package com.pickban.ggbackend.recommendpick.enummodel;

public enum ExceptionMsgEnum {
    NOT_FOUND("Not Found Champion!!"),
    VALIDATE_ERROR_DISABLE_CHAMP_LIST("Validate Error DisableChampList");

    private final String value;

    ExceptionMsgEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
