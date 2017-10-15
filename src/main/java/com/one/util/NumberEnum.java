package com.one.util;


public enum  NumberEnum {

    MIN_NUMBER(1000L),
    MAX_NUMBER(9999L);

    private Long number;

    NumberEnum(long l) {
        this.number = l;
    }

    public Long getNumber() {
        return number;
    }
}
