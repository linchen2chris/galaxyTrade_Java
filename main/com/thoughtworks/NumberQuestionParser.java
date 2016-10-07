package main.com.thoughtworks;

import main.com.thoughtworks.exception.InputException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chris on 15-8-15.
 */
public class NumberQuestionParser implements Parser {
    private NumberTransalator numberTransalator;
    private PriceCalculator priceCalculator;

    public NumberQuestionParser(NumberTransalator numberTransalator, PriceCalculator priceCalculator) {
        this.numberTransalator = numberTransalator;
        this.priceCalculator = priceCalculator;
    }

    @Override
    public String parse(String line) throws InputException {
        Pattern pattern = Pattern.compile("^how much is ([a-zA-Z ]+) \\?$");
        Matcher matcher = pattern.matcher(line);
        if (matcher.matches()) {
            String numberPhrase = matcher.group(1);
            int number = numberTransalator.getValue(numberPhrase);
            return numberPhrase + " is " + number + "\n";
        } else {
            return "I have no idea what you are talking about";
        }
    }
}
