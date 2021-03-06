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

class CandiesStaxBuilderTest {
    private CandiesStaxBuilder staxBuilder;

    @BeforeEach
    void setUp() {
        staxBuilder = new CandiesStaxBuilder();
    }

    @AfterEach
    void tearDown() {
        staxBuilder = null;
    }

    @Test
    void buildSetCandies() throws CandyException {
        ChocolateCandy chocolateCandy = new ChocolateCandy(101, "South Night",
                YearMonth.parse("2023-11"), 380, "chocolate",
                new Ingredients(6, 11, 4, 21, 2),
                new Value(2, 9, 75), "Kommunarka", false);

        CaramelCandy caramelCandy = new CaramelCandy(102, "Duchess",
                YearMonth.parse("2022-10"), 373, "caramel",
                new Ingredients(3, 6, 26, 0, 11),
                new Value(1, 1, 93), "Rot Front", CaramelType.SALTED);

        Set<Candy> expected = new HashSet<>();
        expected.add(chocolateCandy);
        expected.add(caramelCandy);

        staxBuilder.buildSetCandies("src/test/resources/data/candies.xml");
        Set<Candy> actual = staxBuilder.getCandies();

        assertEquals(expected, actual);
    }

    @Test
    void buildSetCandiesWithMistake() {
        assertThrows(CandyException.class, () -> {
            staxBuilder.buildSetCandies("src/test/resources/data/candiesmistake.xml");
        });
    }
}