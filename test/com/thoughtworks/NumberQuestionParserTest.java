package test.com.thoughtworks;

import main.com.thoughtworks.*;
import main.com.thoughtworks.exception.InputException;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * Created by chris on 15-8-15.
 */
public class NumberQuestionParserTest {
    @Test
    public void parseTest() throws InputException {
        Parser parser = new MappingParser(new NumberTransalator());
        parser.parse("glob is I");
        parser.parse("prok is V");
        parser.parse("pish is X");
        parser = new NumberQuestionParser(new NumberTransalator(), new PriceCalculator());
        assertThat(parser.parse("how much is pish pish pish prok ?"),is("pish pish pish prok is 35\n"));
        assertThat(parser.parse("how much is pish glob glob  glob ?"),is("pish glob glob  glob is 13\n"));
    }
}
