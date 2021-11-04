package com.kakura.task2.main;

import com.kakura.task2.builder.*;
import com.kakura.task2.entity.ChocolateCandy;
import com.kakura.task2.entity.Ingredients;
import com.kakura.task2.entity.Value;
import com.kakura.task2.exception.CandyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.YearMonth;

public class Main {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws CandyException {

        ChocolateCandy chocolateCandy1 = new ChocolateCandy(101, "South Night",
                YearMonth.parse("2023-11"), 380, "chocolate",
                new Ingredients(6, 11, 4, 21, 2),
                new Value(2, 9, 75), "Kommunarka", false);

        ChocolateCandy chocolateCandy2 = new ChocolateCandy(101, "South Night",
                YearMonth.parse("2023-11"), 380, "chocolate",
                new Ingredients(6, 11, 4, 21, 2),
                new Value(2, 9, 75), "Kommunarka", false);

        System.out.println(chocolateCandy1.hashCode());
        System.out.println(chocolateCandy2.hashCode());
        System.out.println(chocolateCandy1.equals(chocolateCandy2));

        String type = "stax";
        //String type = "sax";
        //String type = "dom";
        AbstractCandiesBuilder builder = CandyBuilderFactory.createCandyBuilder(type);
        builder.buildSetCandies("src/main/resources/candies.xml");
        System.out.println(builder.getCandies());
    }
}
