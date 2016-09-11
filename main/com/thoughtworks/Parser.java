package main.com.thoughtworks;

import main.com.thoughtworks.exception.InputException;

/**
 * Created by chris on 15-8-7.
 */
public interface Parser {

    public String parse(String line) throws InputException;
    static PriceCalculator priceCalculator = new PriceCalculator();
    static NumberTransalator numberTransalator = new NumberTransalator();

}
