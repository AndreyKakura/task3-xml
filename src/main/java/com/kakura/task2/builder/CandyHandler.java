package com.kakura.task2.builder;

import com.kakura.task2.entity.Candy;
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
    private EnumSet<CandyXmlTag> ingredientsWithText;
    private EnumSet<CandyXmlTag> valueWithText;
    private static final String ELEMENT_CANDY = "candy";

    public CandyHandler() {
        candies = new HashSet<Candy>();
        ingredientsWithText = EnumSet.range(CandyXmlTag.WATER, CandyXmlTag.VANILLIN);
        valueWithText = EnumSet.range(CandyXmlTag.PROTEINS, CandyXmlTag.CARBOHYDRATES);
    }

    public Set<Candy> getCandies() {
        return candies;
    }

    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if (ELEMENT_CANDY.equals(qName)) {
            current = new Candy();
            current.setId(Long.parseLong(attrs.getValue(0)));
            current.setName(attrs.getValue(1));
            current.setExpirationDate(YearMonth.parse(attrs.getValue(2))); //warning
        } else {
            CandyXmlTag temp = CandyXmlTag.valueOf(qName.toUpperCase().replace('-', '_'));
            if (ingredientsWithText.contains(temp) || valueWithText.contains(temp)) {
                currentXmlTag = temp;
            }
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if(ELEMENT_CANDY.equals(qName)) {
            candies.add(current);
        }
    }

    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length).strip();
        if(currentXmlTag!=null) {
            switch(currentXmlTag) {
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
                //case FILLING
            }
        }
    }


}