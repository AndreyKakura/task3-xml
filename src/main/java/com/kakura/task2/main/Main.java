package com.kakura.task2.main;

import com.kakura.task2.builder.CandiesSaxBuilder;
import com.kakura.task2.builder.CandyXmlTag;
import com.kakura.task2.exception.CandyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws CandyException {
        CandiesSaxBuilder saxBuilder = new CandiesSaxBuilder();
        saxBuilder.buildSetCandies("src/main/resources/candies.xml");
        System.out.println(saxBuilder.getCandies());
    }
}
