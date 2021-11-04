package com.kakura.task2.main;

import com.kakura.task2.builder.*;
import com.kakura.task2.exception.CandyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws CandyException {
        String type = "stax";
        //String type = "sax";
        //String type = "dom";
        AbstractCandiesBuilder builder = CandyBuilderFactory.createCandyBuilder(type);
        builder.buildSetCandies("src/main/resources/candies.xml");
        System.out.println(builder.getCandies());
    }
}
