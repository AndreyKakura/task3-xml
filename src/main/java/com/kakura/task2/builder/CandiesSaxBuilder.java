package com.kakura.task2.builder;

import com.kakura.task2.entity.Candy;
import com.kakura.task2.exception.CandyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Set;

public class CandiesSaxBuilder {
    private static final Logger logger = LogManager.getLogger();
    private Set<Candy> candies;
    private CandyHandler handler = new CandyHandler();
    private XMLReader reader;

    public CandiesSaxBuilder() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            reader = saxParser.getXMLReader();
        } catch (ParserConfigurationException | SAXException e) {
            logger.error(e);
        }
        reader.setErrorHandler(new CandyErrorHandler());
        reader.setContentHandler(handler);
    }

    public Set<Candy> getCandies() {
        return candies;
    }

    public void buildSetCandies(String fileName) throws CandyException {
        try {
            reader.parse(fileName);
        } catch(IOException e) {
            logger.error("IOException", e);
            throw new CandyException("IOException", e);
        } catch(SAXException e) {
            logger.error("SAXException", e);
            throw new CandyException("SAXException", e);
        }
        candies = handler.getCandies();
    }
}