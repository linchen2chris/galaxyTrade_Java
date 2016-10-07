package test.com.thoughtworks;

import main.com.thoughtworks.*;
import main.com.thoughtworks.exception.InputException;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * Created by chris on 15-8-15.
 */
public class PriceQuestionParserTest {
    @Test
    public void parseTest() throws InputException {
        Parser parser = new MappingParser(new NumberTransalator());
        parser.parse("glob is I");
        parser.parse("prok is V");
        parser.parse("pish is X");
        parser = new GoodsInfoParser(new NumberTransalator(), new PriceCalculator());
        parser.parse("glob glob Silver is 34 Credits");
        parser.parse("glob prok Gold is 800 Credits");
        parser = new PriceQuestionParser(new NumberTransalator(), new PriceCalculator());
        assertThat(parser.parse("how many Credits is glob prok Silver ?"),is("glob prok Silver is 68 Credits\n"));
    }
}
