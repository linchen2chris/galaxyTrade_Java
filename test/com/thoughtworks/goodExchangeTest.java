package test.com.thoughtworks;

import main.com.thoughtworks.GoodsExchange;
import main.com.thoughtworks.NumberTransalator;
import main.com.thoughtworks.Parser;
import main.com.thoughtworks.PriceCalculator;
import main.com.thoughtworks.exception.InputException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by chris2 on 16-9-23.
 */
public class goodExchangeTest {
    @Test
    public void generateCorrectParser() throws InputException {
        String line = "how many Silver is glob Gold ?";
        Parser parser = new GoodsExchange(new NumberTransalator(), new PriceCalculator());
        String result = parser.parse(line);
        assertThat(result, is("glob Gold is 3 Silver"));
    }
}
