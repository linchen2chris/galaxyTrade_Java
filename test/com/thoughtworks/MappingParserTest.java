package test.com.thoughtworks;

import main.com.thoughtworks.MappingParser;
import main.com.thoughtworks.Parser;
import main.com.thoughtworks.exception.InputException;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * Created by chris on 15-8-15.
 */
public class MappingParserTest {
    @Test
    public void parseTest() throws InputException {
        Parser parser = new MappingParser();
        assertThat(parser.parse("glob is I"),is(""));
        assertThat(parser.parse("prok is V"), is(""));
        assertThat(Parser.numberTransalator.getRoman("glob glob"),is("II"));
        assertThat(Parser.numberTransalator.getValue("glob glob"),is(2));
    }

}
