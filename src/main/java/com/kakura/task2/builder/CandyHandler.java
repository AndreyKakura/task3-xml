package com.kakura.task2.builder;

import com.kakura.task2.entity.Candy;
import com.kakura.task2.entity.CaramelCandy;
import com.kakura.task2.entity.CaramelType;
import com.kakura.task2.entity.ChocolateCandy;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.time.YearMonth;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class CandyHandler extends DefaultHandler {
    private Set<Candy> candies;
    private Candy current;
    private CandyXmlTag currentXmlTag;
    private EnumSet<CandyXmlTag> withText;
    private static final String ELEMENT_CHOCOLATE_CANDY = "chocolate-candy";
    private static final String ELEMENT_CARAMEL_CANDY = "caramel-candy";

    public CandyHandler() {
        candies = new HashSet<Candy>();
        withText = EnumSet.of(CandyXmlTag.ENERGY, CandyXmlTag.TYPE,
                CandyXmlTag.WATER, CandyXmlTag.SUGAR, CandyXmlTag.FRUCTOSE,
                CandyXmlTag.COCOA, CandyXmlTag.VANILLIN,
                CandyXmlTag.PROTEINS, CandyXmlTag.FATS, CandyXmlTag.CARBOHYDRATES,
                CandyXmlTag.PRODUCTION, CandyXmlTag.FILLING, CandyXmlTag.CARAMEL_TYPE);
    }

    public Set<Candy> getCandies() {
        return candies;
    }

    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if (ELEMENT_CHOCOLATE_CANDY.equals(qName) || ELEMENT_CARAMEL_CANDY.equals(qName)) {
            if (ELEMENT_CHOCOLATE_CANDY.equals(qName)) {
                current = new ChocolateCandy();
            } else {
                current = new CaramelCandy();
            }
            current.setId(Long.parseLong(attrs.getValue(0)));
            current.setName(attrs.getValue(1));
            if (attrs.getLength() == 3) {
                current.setExpirationDate(YearMonth.parse(attrs.getValue(2))); //warning
            }

        } else {
            CandyXmlTag temp = CandyXmlTag.valueOf(qName.toUpperCase().replace('-', '_'));
            if (withText.contains(temp)) {
                currentXmlTag = temp;
            }
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if (ELEMENT_CHOCOLATE_CANDY.equals(qName) || ELEMENT_CARAMEL_CANDY.equals(qName)) {
            candies.add(current);
        }
    }

    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length).strip();
        if (currentXmlTag != null) {
            switch (currentXmlTag) {
                case ENERGY -> current.setEnergy(Integer.parseInt(data));
                case TYPE -> current.setType(data);
                case WATER -> current.getIngredients().setWater(Integer.parseInt(data));
                case SUGAR -> current.getIngredients().setSugar(Integer.parseInt(data));
                case FRUCTOSE -> current.getIngredients().setFructose(Integer.parseInt(data));
                case COCOA -> current.getIngredients().setCocoa(Integer.parseInt(data));
                case VANILLIN -> current.getIngredients().setVanillin(Integer.parseInt(data));
                case PROTEINS -> current.getValue().setProteins(Integer.parseInt(data));
                case FATS -> current.getValue().setFats(Integer.parseInt(data));
                case CARBOHYDRATES -> current.getValue().setCarbohydrates(Integer.parseInt(data));
                case PRODUCTION -> current.setProduction(data);
                case FILLING -> {
                    ChocolateCandy temp = (ChocolateCandy) current;
                    temp.setFilling(Boolean.parseBoolean(data));
                    current = temp;
                }
                case CARAMEL_TYPE -> {
                    CaramelCandy temp = (CaramelCandy) current;
                    temp.setCaramelType(CaramelType.valueOf(data.toUpperCase()));
                    current = temp;
                }
                default -> throw new EnumConstantNotPresentException(
                        currentXmlTag.getDeclaringClass(), currentXmlTag.name());
            }
        }
        currentXmlTag = null;
    }


}
