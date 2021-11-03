package com.kakura.task2.main;

import com.kakura.task2.builder.CandiesDomBuilder;
import com.kakura.task2.builder.CandiesSaxBuilder;
import com.kakura.task2.builder.CandiesStaxBuilder;
import com.kakura.task2.builder.CandyXmlTag;
import com.kakura.task2.exception.CandyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws CandyException {
        CandiesStaxBuilder staxBuilder = new CandiesStaxBuilder();
        staxBuilder.buildSetCandies("src/main/resources/candies.xml");
        System.out.println(staxBuilder.getCandies());
    }
}
