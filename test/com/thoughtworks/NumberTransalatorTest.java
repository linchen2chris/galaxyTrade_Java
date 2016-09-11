package test.com.thoughtworks;

import main.com.thoughtworks.NumberTransalator;
import main.com.thoughtworks.exception.InputException;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * Created by chris on 15-8-15.
 */
public class NumberTransalatorTest {
    @Test
    public void transalateToRomanTest() throws InputException {
        NumberTransalator numberTransalator = new NumberTransalator();
        numberTransalator.generateMapping("glob",'I');
        numberTransalator.generateMapping("prok",'V');
        numberTransalator.generateMapping("pish",'X');
        numberTransalator.generateMapping("tegj",'L');
        assertThat(numberTransalator.getRoman("glob glob"),is("II"));
        assertThat(numberTransalator.getRoman("pish tegj"),is("XL"));
    }

    @Test(expected = InputException.class)
    public void illegalPhrase() throws InputException {
        NumberTransalator numberTransalator = new NumberTransalator();
        numberTransalator.generateMapping("glob",'I');
        numberTransalator.generateMapping("prok",'V');
        numberTransalator.generateMapping("pish",'X');
        numberTransalator.generateMapping("tegj", 'L');
        numberTransalator.getRoman("chris glob");
    }

    @Test
    public void transalateToNumber() throws InputException {
        NumberTransalator numberTransalator = new NumberTransalator();
        numberTransalator.generateMapping("glob",'I');
        numberTransalator.generateMapping("prok",'V');
        numberTransalator.generateMapping("pish",'X');
        numberTransalator.generateMapping("tegj",'L');
        assertThat(numberTransalator.getValue("glob glob"), is(2));
        assertThat(numberTransalator.getValue("tegj pish prok glob"), is(66));
    }

    @Test(expected = InputException.class)
    public void illegalPhraseToNum() throws InputException {
        NumberTransalator numberTransalator = new NumberTransalator();
        numberTransalator.generateMapping("glob",'I');
        numberTransalator.generateMapping("prok",'V');
        numberTransalator.generateMapping("pish",'X');
        numberTransalator.generateMapping("tegj", 'L');
        numberTransalator.getValue("chris glob");
    }

}
