package test.com.thoughtworks;

import main.com.thoughtworks.exception.InputException;
import main.com.thoughtworks.PriceCalculator;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by chris on 15-8-8.
 */
public class PriceCalculatorTest {
    @Test
    public void GeneratePriceListTest() throws InputException {
        PriceCalculator priceListCalculator = new PriceCalculator();
        assertThat(priceListCalculator.generatePriceList("Golden",4,57800), is(14450.0));
        assertThat(priceListCalculator.generatePriceList("Silver", 2, 34), is(17.0));
        assertThat(priceListCalculator.generatePriceList("Iron", 20,3910), is(195.5));
    }
    @Test
    public void CalculateTotalPriceTest() throws InputException {
        PriceCalculator priceListCalculator = new PriceCalculator();
        priceListCalculator.generatePriceList("Golden",4,57800);
        priceListCalculator.generatePriceList("Silver", 2, 34);
        priceListCalculator.generatePriceList("Iron", 20,3910) ;
        assertThat(priceListCalculator.calculateTotalPrice("Golden", 4), is(57800.0));
        assertThat(priceListCalculator.calculateTotalPrice("Silver", 4), is(68.0));
        assertThat(priceListCalculator.calculateTotalPrice("Iron", 4),is(782.0));
    }
    @Test(expected = InputException.class)
    public void IllegalGoodsNameTest() throws InputException {
        PriceCalculator priceListCalculator = new PriceCalculator();
        priceListCalculator.generatePriceList("Golden",4,57800);
        priceListCalculator.generatePriceList("Silver", 2, 34);
        priceListCalculator.generatePriceList("Iron", 20, 3910);
        priceListCalculator.calculateTotalPrice("Mud", 4);

    }
    @Test(expected = InputException.class)
    public void IllegalGoodsQuantityTest() throws InputException {
        PriceCalculator priceListCalculator = new PriceCalculator();
        priceListCalculator.generatePriceList("Golden",4,57800);
        priceListCalculator.generatePriceList("Silver", 2, 34);
        priceListCalculator.generatePriceList("Iron", 20, 3910);
        priceListCalculator.calculateTotalPrice("Golden", -4);
    }
    @Test
    public void GetPriceListTest() throws InputException {
        PriceCalculator priceListCalculator = new PriceCalculator();
        priceListCalculator.generatePriceList("Golden",4,57800);
        assertThat(priceListCalculator.getPrice("Golden"), is(14450.0));
    }

}
