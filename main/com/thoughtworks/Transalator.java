package main.com.thoughtworks;
import main.com.thoughtworks.exception.InputException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chris on 15-8-8.
 */
public class Transalator {
    public int getValue(String romanStr) throws InputException {
        if (!isLegalRomanNumerials(romanStr)) {
            throw new InputException(romanStr + " is illegal Roman Numerials");
        }
        int result = 0;
        int length = romanStr.length();
        char[] romanArr = romanStr.toCharArray();

        for (int i = 0; i < length; ) {
            if (i == length - 1 || romanMap.get(romanArr[i]) >= romanMap.get(romanArr[i + 1])) {
                result += romanMap.get(romanArr[i]);
                i++;
            } else {
                result += romanMap.get(romanArr[i + 1]) - romanMap.get(romanArr[i]);
                i = i + 2;
            }
        }
        return result;
    }

    private static Map<Character, Integer> romanMap = new HashMap<Character, Integer>();
    static {
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
    }

    public boolean isLegalRomanNumerials(String romanNumerials) {

        if (!romanNumerials.matches("[IVXLCDM]+")) {
            return  false;
        }

        String[] illegalSubString = {"IIII", "XXXX", "CCCC", "MMMM", "VV", "LL", "DD", "IL", "IC", "ID", "IM", "XD", "XM", "VX", "VL", "VD", "VM", "LC", "LD", "LM", "DM"};

        for (String subString: illegalSubString) {
            if (romanNumerials.contains(subString))
                return false;
        }
        return true;
    }
}
