package main.com.thoughtworks;
import main.com.thoughtworks.exception.InputException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chris on 15-8-15.
 */
public class NumberTransalator {
    private static Map<String, Character> wordMapping = new HashMap<String, Character>();
    private Transalator transalator = new Transalator();

    public String getRoman(String phrase) throws InputException {
        String[] words = phrase.split(" {1,}");
        String result = "";

        for (String word: words) {
            if (!wordMapping.containsKey(word)) {
                throw new InputException(word +  " is invalid word to convert to  the Roman numberials");
            }
            result += wordMapping.get(word);
        }
        return result;
    }
    
    public int getValue(String phrase) throws InputException {
        return transalator.getValue(getRoman(phrase));
    }

    public void generateMapping(String word, Character romanToken){
        wordMapping.put(word, romanToken);
    }
}
