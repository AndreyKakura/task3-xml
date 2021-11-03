package com.kakura.task2.builder;

import com.kakura.task2.entity.*;
import com.kakura.task2.exception.CandyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.YearMonth;

public class CandiesStaxBuilder extends AbstractCandiesBuilder {
    private static final Logger logger = LogManager.getLogger();

    private static final char UNDERSCORE = '_';
    private static final char HYPHEN = '-';

    private XMLInputFactory inputFactory;

    public CandiesStaxBuilder() {
        super();
        inputFactory = XMLInputFactory.newInstance();
    }


    @Override
    public void buildSetCandies(String fileName) throws CandyException {
        XMLStreamReader reader;
        String name;
        try (FileInputStream inputStream = new FileInputStream(new File(fileName))) {
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (name.equals(CandyXmlTag.CHOCOLATE_CANDY.getValue())
                            || name.equals(CandyXmlTag.CARAMEL_CANDY.getValue())) {
                        Candy candy = buildCandy(reader);
                        candies.add(candy);
                    }
                }
            }

        } catch (XMLStreamException e) {
            logger.error("XMLStreamException", e);
            throw new CandyException("XMLStreamException", e);
        } catch (FileNotFoundException e) {
            logger.error("FileNotFoundException", e);
            throw new CandyException("FileNotFoundException", e);
        } catch (IOException e) {
            logger.error("IOException", e);
            throw new CandyException("IOException", e);
        }
    }

    private Candy buildCandy(XMLStreamReader reader) throws XMLStreamException {
        Candy candy;
        if (reader.getLocalName().equals(CandyXmlTag.CHOCOLATE_CANDY.getValue())) {
            candy = new ChocolateCandy();
        } else {
            candy = new CaramelCandy();
        }

        candy.setId(Long.parseLong(reader.getAttributeValue(null, CandyXmlTag.ID.getValue())));
        candy.setName(reader.getAttributeValue(null, CandyXmlTag.NAME.getValue()));

        String content = reader.getAttributeValue(null, CandyXmlTag.EXPIRATION_DATE.getValue());
        if (content != null) {
            candy.setExpirationDate(YearMonth.parse(content));
        }

        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (CandyXmlTag.valueOf(name.toUpperCase().replace(HYPHEN, UNDERSCORE))) {
                        case ENERGY -> candy.setEnergy(Integer.parseInt(getXMLText(reader)));
                        case TYPE -> candy.setType(getXMLText(reader));
                        case INGREDIENTS -> candy.setIngredients(getXMLIngredients(reader));
                        case VALUE -> candy.setValue(getXMLValue(reader));
                        case PRODUCTION -> candy.setProduction(getXMLText(reader));
                        case FILLING -> {
                            ChocolateCandy temp = (ChocolateCandy) candy;
                            temp.setFilling(Boolean.parseBoolean(getXMLText(reader)));
                            candy = temp;
                        }
                        case CARAMEL_TYPE -> {
                            CaramelCandy temp = (CaramelCandy) candy;
                            temp.setCaramelType(CaramelType.valueOfXmlContent(getXMLText(reader)));
                            candy = temp;
                        }
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (name.equals(CandyXmlTag.CHOCOLATE_CANDY.getValue())
                            || name.equals(CandyXmlTag.CARAMEL_CANDY.getValue())) {
                        return candy;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <chocolate-candy> or <caramel-candy>");
    }

    private Ingredients getXMLIngredients(XMLStreamReader reader) throws XMLStreamException {
        Ingredients ingredients = new Ingredients();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (CandyXmlTag.valueOf(name.toUpperCase())) {
                        case WATER -> ingredients.setWater(Integer.parseInt(getXMLText(reader)));
                        case SUGAR -> ingredients.setSugar(Integer.parseInt(getXMLText(reader)));
                        case FRUCTOSE -> ingredients.setFructose(Integer.parseInt(getXMLText(reader)));
                        case COCOA -> ingredients.setCocoa(Integer.parseInt(getXMLText(reader)));
                        case VANILLIN -> ingredients.setVanillin(Integer.parseInt(getXMLText(reader)));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (name.equals(CandyXmlTag.INGREDIENTS.getValue())) {
                        return ingredients;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <ingredients>");
    }

    private Value getXMLValue(XMLStreamReader reader) throws XMLStreamException {
        Value value = new Value();

        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (CandyXmlTag.valueOf(name.toUpperCase())) {
                        case PROTEINS -> value.setProteins(Integer.parseInt(getXMLText(reader)));
                        case FATS -> value.setFats(Integer.parseInt(getXMLText(reader)));
                        case CARBOHYDRATES -> value.setCarbohydrates(Integer.parseInt(getXMLText(reader)));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (name.equals(CandyXmlTag.VALUE.getValue())) {
                        return value;
                    }
            }

        }
        throw new XMLStreamException("Unknown element in tag <ingredients>");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }

}
