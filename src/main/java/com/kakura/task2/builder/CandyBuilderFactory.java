package com.kakura.task2.builder;

public class CandyBuilderFactory {
    private enum TypeParser {
        SAX, STAX, DOM
    }

    private CandyBuilderFactory() {

    }

    public static AbstractCandiesBuilder createCandyBuilder(String typeParser) {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM -> {
                return new CandiesDomBuilder();
            }
            case STAX -> {
                return new CandiesStaxBuilder();
            }
            case SAX -> {
                return new CandiesSaxBuilder();
            }
            default -> throw new EnumConstantNotPresentException(
                    type.getDeclaringClass(), type.name());

        }
    }
}
