package main.com.thoughtworks;

import main.com.thoughtworks.exception.InputException;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chris on 15-8-15.
 */
public class PriceQuestionParser implements Parser {
    @Override
    public String parse(String line) throws InputException {
        //"how many Credits is glob prok Iron ?"
        Pattern pattern = Pattern.compile("^how many Credits is ([a-zA-Z ]+) ([a-zA-Z]+) \\?$");
        Matcher matcher = pattern.matcher(line);
        if (matcher.matches()) {
            String goodsNumberStr = matcher.group(1);
            int goodsMumber = numberTransalator.getValue(goodsNumberStr);
            String goodsName = matcher.group(2);
            double totalPrice = priceCalculator.calculateTotalPrice(goodsName, goodsMumber);
            DecimalFormat df = new DecimalFormat("#.#");
            return goodsNumberStr + " " + goodsName + " is " + df.format(totalPrice) + " Credits\n";
        } else {
            return "I have no idea what you are talking about";
        }
    }
}
