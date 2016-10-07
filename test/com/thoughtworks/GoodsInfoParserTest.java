package test.com.thoughtworks;

import main.com.thoughtworks.*;
import main.com.thoughtworks.exception.InputException;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * Created by chris on 15-8-15.
 */
public class GoodsInfoParserTest {
    @Test
    public void parseTest() throws InputException {
        Parser parser = new MappingParser(new NumberTransalator());
        parser.parse("glob is I");
        parser = new GoodsInfoParser(new NumberTransalator(), new PriceCalculator());
        assertThat(parser.parse("glob glob Silver is 34 Credits"),is(""));

    }
}
