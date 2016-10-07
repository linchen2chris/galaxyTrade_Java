package main.com.thoughtworks;

import main.com.thoughtworks.exception.InputException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chris2 on 16-9-23.
 */
public class GoodsExchange implements Parser {

    private NumberTransalator numberTransalator;
    private PriceCalculator priceCalcultor;

    public GoodsExchange(NumberTransalator numberTransalator, PriceCalculator priceCalcultor) {

        this.numberTransalator = numberTransalator;
        this.priceCalcultor = priceCalcultor;
    }
    @Override
    public String parse(String line) throws InputException {
        Pattern pattern = Pattern.compile("^how many (\\w+) is (\\w+) (\\w+) \\?");
        Matcher matcher = pattern.matcher(line);
        if (matcher.matches()) {
            int goodsNum = numberTransalator.getValue(matcher.group(2));
            String targetGoodsName = matcher.group(1);
            String sourceGoodsName = matcher.group(3);

            double totalCredits = priceCalcultor.calculateTotalPrice(sourceGoodsName, goodsNum);
            double targetNum = totalCredits / priceCalcultor.getPrice(targetGoodsName);
            String result = matcher.group(2) + ' ' + matcher.group(3) + " is " + targetNum + matcher.group(1);
                    //"golb Gold is 3 Silver"
            return result;
        }
        return "I have no idea";
    }
}
