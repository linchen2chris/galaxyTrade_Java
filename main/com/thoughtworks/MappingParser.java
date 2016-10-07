package main.com.thoughtworks;

import main.com.thoughtworks.exception.InputException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chris on 15-8-15.
 */
public class MappingParser implements Parser {

    private NumberTransalator numberTransalator;

    public MappingParser(NumberTransalator numberTransalator) {

        this.numberTransalator = numberTransalator;
    }

    @Override
    public String parse(String line) throws InputException {
        Pattern pattern = Pattern.compile("(\\w+) is ([IVXLCDM]){1}");
        Matcher matcher = pattern.matcher(line);
        if (matcher.matches()) {
            numberTransalator.generateMapping(matcher.group(1), matcher.group(2).charAt(0));
            return "";
        } else {
            return "I have no idea what you are talking about";
        }

    }
}
