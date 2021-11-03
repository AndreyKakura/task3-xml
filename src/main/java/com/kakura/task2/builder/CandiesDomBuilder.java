package com.kakura.task2.builder;

import com.kakura.task2.entity.Candy;
import com.kakura.task2.entity.CaramelCandy;
import com.kakura.task2.entity.CaramelType;
import com.kakura.task2.entity.ChocolateCandy;
import com.kakura.task2.exception.CandyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.YearMonth;

public class CandiesDomBuilder extends AbstractCandiesBuilder {
    private static final Logger logger = LogManager.getLogger();
    private DocumentBuilder docBuilder;
    private static final String ELEMENT_CHOCOLATE_CANDY = "chocolate-candy";
    private static final String ELEMENT_CARAMEL_CANDY = "caramel-candy";

    public CandiesDomBuilder() {
        super();
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            logger.error("ParserConfigurationException", e);
        }
    }

    @Override
    public void buildSetCandies(String fileName) throws CandyException {
        Document doc;
        try {
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            NodeList candiesList = root.getElementsByTagName(CandyXmlTag.CHOCOLATE_CANDY.getValue());
            for (int i = 0; i < candiesList.getLength(); i++) {
                Element candyElement = (Element) candiesList.item(i);
                Candy candy = buildCandy(candyElement);
                candies.add(candy);
            }

            candiesList = root.getElementsByTagName(CandyXmlTag.CARAMEL_CANDY.getValue());
            for (int i = 0; i < candiesList.getLength(); i++) {
                Element candyElement = (Element) candiesList.item(i);
                Candy candy = buildCandy(candyElement);
                candies.add(candy);
            }

        } catch(IOException e) {
            logger.error("IOException", e);
            throw new CandyException("IOException", e);
        } catch(SAXException e) {
            logger.error("SAXException", e);
            throw new CandyException("SAXException", e);
        }
    }

    private Candy buildCandy(Element candyElement) {
        Candy candy;

        if(ELEMENT_CHOCOLATE_CANDY.equals(candyElement.getTagName())) {
            candy = new ChocolateCandy();
        } else {
            candy = new CaramelCandy();
        }

        String data;

        data = candyElement.getAttribute(CandyXmlTag.ID.getValue());
        candy.setId(Long.parseLong(data));

        data = candyElement.getAttribute(CandyXmlTag.NAME.getValue());
        candy.setName(data);

        data = candyElement.getAttribute(CandyXmlTag.EXPIRATION_DATE.getValue());
        if(!data.isEmpty()) {
            candy.setExpirationDate(YearMonth.parse(data));
        }

        data = getElementTextContent(candyElement, CandyXmlTag.ENERGY.getValue());
        candy.setEnergy(Integer.parseInt(data));

        data = getElementTextContent(candyElement, CandyXmlTag.TYPE.getValue());
        candy.setType(data);

        data = getElementTextContent(candyElement, CandyXmlTag.WATER.getValue());
        candy.getIngredients().setWater(Integer.parseInt(data));

        data = getElementTextContent(candyElement, CandyXmlTag.SUGAR.getValue());
        candy.getIngredients().setSugar(Integer.parseInt(data));

        data = getElementTextContent(candyElement, CandyXmlTag.FRUCTOSE.getValue());
        candy.getIngredients().setFructose(Integer.parseInt(data));

        data = getElementTextContent(candyElement, CandyXmlTag.COCOA.getValue());
        candy.getIngredients().setCocoa(Integer.parseInt(data));

        data = getElementTextContent(candyElement, CandyXmlTag.VANILLIN.getValue());
        candy.getIngredients().setVanillin(Integer.parseInt(data));

        data = getElementTextContent(candyElement, CandyXmlTag.PROTEINS.getValue());
        candy.getValue().setProteins(Integer.parseInt(data));

        data = getElementTextContent(candyElement, CandyXmlTag.FATS.getValue());
        candy.getValue().setFats(Integer.parseInt(data));

        data = getElementTextContent(candyElement, CandyXmlTag.CARBOHYDRATES.getValue());
        candy.getValue().setCarbohydrates(Integer.parseInt(data));

        data = getElementTextContent(candyElement, CandyXmlTag.PRODUCTION.getValue());
        candy.setProduction(data);

        if(candy instanceof ChocolateCandy) {
            ChocolateCandy temp = (ChocolateCandy) candy;
            data = getElementTextContent(candyElement, CandyXmlTag.FILLING.getValue());
            temp.setFilling(Boolean.parseBoolean(data));
            candy = temp;
        } else {
            CaramelCandy temp = (CaramelCandy) candy;
            data = getElementTextContent(candyElement, CandyXmlTag.CARAMEL_TYPE.getValue());
            temp.setCaramelType(CaramelType.valueOf(data.toUpperCase()));
            candy = temp;
        }

        return candy;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}
