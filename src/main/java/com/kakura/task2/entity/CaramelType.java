package com.kakura.task2.entity;

public enum CaramelType {
    SALTED("salted"),
    LOLLIPOP("lollipop"),
    FRUIT("fruit");
    private String value;

    private static final char UNDERSCORE = '_';
    private static final char HYPHEN = '-';

    CaramelType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CaramelType valueOfXmlContent(String content) {
        return CaramelType.valueOf(content.toUpperCase().replace(HYPHEN, UNDERSCORE));
    }
}
