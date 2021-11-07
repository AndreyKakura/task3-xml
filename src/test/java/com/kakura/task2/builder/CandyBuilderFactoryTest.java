package com.kakura.task2.builder;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CandyBuilderFactoryTest {


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void createCandyBuilder(String typeParser, Class<? extends AbstractCandiesBuilder> expected) {
        Class<? extends AbstractCandiesBuilder> actual = CandyBuilderFactory.createCandyBuilder(typeParser).getClass();
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(Arguments.of("sax", CandiesSaxBuilder.class),
                Arguments.of("stax", CandiesStaxBuilder.class),
                Arguments.of("dom", CandiesDomBuilder.class));
    }
}