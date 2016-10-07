package test.com.thoughtworks;

import main.com.thoughtworks.GoodsInfoParser;
import main.com.thoughtworks.MappingParser;
import main.com.thoughtworks.Parser;

/**
 * Created by chris2 on 16-9-23.
 */
public class ParserFactory {
    public Parser getParser(String line) {

//        if (line.matches("\\w+ is [IVXLCDM]{1}")) {
//            return new MappingParser();
//        }
//
//        if ( line.matches("[a-zA-Z ]+ is \\d+ Credits$")) {
//            return new GoodsInfoParser();
//        }

        return null;
    }
}
