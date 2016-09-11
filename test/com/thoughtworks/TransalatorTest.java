package test.com.thoughtworks;

import main.com.thoughtworks.exception.InputException;
import main.com.thoughtworks.Transalator;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * Created by chris on 15-8-8.
 */
public class TransalatorTest{
    @Test
    public void shouldTransalateSingleRoman() throws InputException {
        Transalator transalator = new Transalator();
        assertThat(transalator.getValue("I"), is(1));
        assertThat(transalator.getValue("V"), is(5));
        assertThat(transalator.getValue("X"), is(10));
        assertThat(transalator.getValue("L"), is(50));
        assertThat(transalator.getValue("C"), is(100));
        assertThat(transalator.getValue("D"), is(500));
        assertThat(transalator.getValue("M"), is(1000));
    }

    @Test
    public void shouldTransalateSortedRoman() throws InputException {
        Transalator transalator = new Transalator();
        assertThat(transalator.getValue("MDCLXVI"),is(1666));
        assertThat(transalator.getValue("MMXI"), is(2011));
        assertThat(transalator.getValue("MMMCCCXXXIII"),is(3333));
        assertThat(transalator.getValue("MMMDCCCLXXXVIII"),is(3888));
    }

    @Test
    public void shouldTransalateUnsortedRoman() throws InputException {
        Transalator transalator = new Transalator();
        assertThat(transalator.getValue("IV"),is(4));
        assertThat(transalator.getValue("IX"),is(9));
        assertThat(transalator.getValue("XL"),is(40));
        assertThat(transalator.getValue("XC"),is(90));
        assertThat(transalator.getValue("CD"),is(400));
        assertThat(transalator.getValue("CM"),is(900));
    }
    @Test
    public void shouldlegalRomanToken(){
        Transalator transalator = new Transalator();
        assertThat(transalator.isLegalRomanNumerials("ABC"),is(false));
        assertThat(transalator.isLegalRomanNumerials("CA"),is(false));
        assertThat(transalator.isLegalRomanNumerials("MMIXB"),is(false));
    }
    @Test
    public void checkillegalRepeatRomanNumerials(){
        Transalator transalator = new Transalator();
        assertThat(transalator.isLegalRomanNumerials("IIII"),is(false));
        assertThat(transalator.isLegalRomanNumerials("XXXX"),is(false));
        assertThat(transalator.isLegalRomanNumerials("CCCC"),is(false));
        assertThat(transalator.isLegalRomanNumerials("MMMM"),is(false));
        assertThat(transalator.isLegalRomanNumerials("VV"),is(false));
        assertThat(transalator.isLegalRomanNumerials("LL"),is(false));
        assertThat(transalator.isLegalRomanNumerials("DD"),is(false));
        assertThat(transalator.isLegalRomanNumerials("XXXIX"),is(true));
    }
    @Test
    public void checklegalMinus(){
        Transalator transalator = new Transalator();
        assertThat(transalator.isLegalRomanNumerials("IV"), is(true));
        assertThat(transalator.isLegalRomanNumerials("IX"),is(true));
        assertThat(transalator.isLegalRomanNumerials("XL"),is(true));
        assertThat(transalator.isLegalRomanNumerials("XC"),is(true));
        assertThat(transalator.isLegalRomanNumerials("CD"),is(true));
        assertThat(transalator.isLegalRomanNumerials("CM"),is(true));
    }
    @Test
    public void checkIllegalMinus(){
        Transalator transalator = new Transalator();
        assertThat(transalator.isLegalRomanNumerials("IL"),is(false));
        assertThat(transalator.isLegalRomanNumerials("MIC"),is(false));
        assertThat(transalator.isLegalRomanNumerials("ID"),is(false));
        assertThat(transalator.isLegalRomanNumerials("IM"),is(false));
        assertThat(transalator.isLegalRomanNumerials("XD"),is(false));
        assertThat(transalator.isLegalRomanNumerials("XM"),is(false));
        assertThat(transalator.isLegalRomanNumerials("VX"),is(false));
        assertThat(transalator.isLegalRomanNumerials("LC"),is(false));
        assertThat(transalator.isLegalRomanNumerials("DM"),is(false));
        assertThat(transalator.isLegalRomanNumerials("LM"),is(false));
    }
    @Test(expected = InputException.class)
    public void IllegalRomanNumerialsExceptionTest() throws InputException {
        Transalator transalator = new Transalator();
        transalator.getValue("DJFD");
    }
}
