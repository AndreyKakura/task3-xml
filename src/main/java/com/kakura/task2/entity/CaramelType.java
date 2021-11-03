package com.kakura.task2.entity;

public enum CaramelType {
    SALTED("salted"),
    LOLLIPOP("lollipop"),
    FRUIT("fruit");
    private String value;

    CaramelType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
