package com.kakura.task2.builder;

public enum CandyXmlTag {
    CANDIES("candies"),
    CANDY("candy"),
    CHOCOLATE_CANDY("chocolate-candy"),
    CARAMEL_CANDY("caramel-candy"),
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
    FILLING("filling"),
    CARAMEL_TYPE("caramel-type");

    private String value;

    CandyXmlTag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
