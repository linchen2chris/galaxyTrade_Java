package main.com.thoughtworks;

import main.com.thoughtworks.exception.InputException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chris on 15-8-15.
 */
public class GoodsInfoParser implements Parser {

    NumberTransalator numberTransalator;
    private PriceCalculator priceCalculator;

    public GoodsInfoParser(NumberTransalator numberTransalator, PriceCalculator priceCalculator) {
        this.numberTransalator=numberTransalator;
        this.priceCalculator = priceCalculator;
    }

    @Override
    public String parse(String line) throws InputException {
        // "glob glob Silver is 34 credits"
        Pattern pattern = Pattern.compile("([a-zA-Z ]+) ([a-zA-Z]+) is (\\d+) Credits$");
        Matcher matcher = pattern.matcher(line);
        if (matcher.matches()) {
            int goodsNumber = numberTransalator.getValue(matcher.group(1));
            String goodsName = matcher.group(2);
            Double goodsTotal = Double.parseDouble(matcher.group(3));
            priceCalculator.generatePriceList(goodsName, goodsNumber, goodsTotal);
            return "";
        } else {
            return "I have no idea what you are talking about";
        }
    }
}
