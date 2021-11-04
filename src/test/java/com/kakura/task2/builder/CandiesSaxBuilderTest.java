package com.kakura.task2.builder;

import com.kakura.task2.entity.*;
import com.kakura.task2.exception.CandyException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.YearMonth;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CandiesSaxBuilderTest {
    private CandiesSaxBuilder saxBuilder;

    @BeforeEach
    void setUp() {
        saxBuilder = new CandiesSaxBuilder();
    }

    @AfterEach
    void tearDown() {
        saxBuilder = null;
    }

    @Test
    void buildSetCandies() throws CandyException {
        ChocolateCandy chocolateCandy = new ChocolateCandy(101, "South Night",
                YearMonth.parse("2023-11"), 380, "chocolate",
                new Ingredients(6, 11, 4, 21, 2),
                new Value(2, 9, 75), "Kommunarka", false);

        CaramelCandy  caramelCandy = new CaramelCandy(102, "Duchess",
                YearMonth.parse("2022-10"), 373, "caramel",
                new Ingredients(3, 6, 26, 0, 11),
                new Value(1, 1, 93), "Rot Front", CaramelType.SALTED);

        Set<Candy> expected = new HashSet<>();
        expected.add(chocolateCandy);
        expected.add(caramelCandy);

        saxBuilder.buildSetCandies("src/test/resources/data/candies.xml");
        Set<Candy> actual = saxBuilder.getCandies();
        assertEquals(expected, actual);
    }

    @Test
    public void buildSetCandiesWithError() {
        assertThrows(CandyException.class, () -> {
            saxBuilder.buildSetCandies("src/test/resources/data/candiesmistake.xml");
        });
    }

}