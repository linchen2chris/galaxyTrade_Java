package test.com.thoughtworks;

import main.com.thoughtworks.GoodsInfoParser;
import main.com.thoughtworks.MappingParser;
import main.com.thoughtworks.Parser;
import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by chris2 on 16-9-23.
 */
public class ParserFactoryTest {
    @Test
    public void GetParserTestTrue() {
        ParserFactory parserFactory = new ParserFactory();
        String line = "prok is V";
        Parser parser = parserFactory.getParser(line);
        assertTrue(parser instanceof MappingParser);

    }

    @Test
    public  void GetParserTestFalse() {
        ParserFactory parserFactory = new ParserFactory();
        String line = "jslkdfjlkjlskjfdlkjjlk lajdslkfj";
        Parser parser = parserFactory.getParser(line);
        assertNull(parser);

    }

    @Test
    public void getParserTestNumber() {
        ParserFactory parserFactory = new ParserFactory();
        String line = "glob glob Silver is 34 Credits";
        Parser parser = parserFactory.getParser(line);
        assertTrue(parser instanceof GoodsInfoParser);


    }
}
