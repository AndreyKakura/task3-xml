package com.kakura.task2.builder;

public enum CandyXmlTag {
    CANDIES("candies"),
    CANDY("candy"),
    ID("id"),
    NAME("name"),
    EXPIRATION_DATE("expiration-date"),
    ENERGY("energy"),
    TYPE("type"),
    INGREDIENTS("ingredients"),
    WATER("water"),
    SUGAR("sugar"),
    FRUCTOSE("fructose"),
    COCOA("cocoa"),
    VANILLIN("vanillin"),
    VALUE("value"),
    PROTEINS("proteins"),
    FATS("fats"),
    CARBOHYDRATES("carbohydrates"),
    PRODUCTION("production"),
    FILLING("filling");

    private String value;
    CandyXmlTag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
