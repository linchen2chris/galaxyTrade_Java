package main.com.thoughtworks;
import main.com.thoughtworks.exception.InputException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chris on 15-8-8.
 */
public class PriceCalculator {
    public double generatePriceList(String goodsName, int quantity, double totalPrice) throws InputException {
        if (totalPrice < 0 ||quantity <= 0) {
            throw new InputException("Illegal totalPrice or quantity");
        }
        priceList.put(goodsName, totalPrice / quantity);
        return totalPrice / quantity;
    }

    public double calculateTotalPrice(String goodsName, int quantity) throws InputException {
        if (!priceList.containsKey(goodsName)) {
            throw new InputException(goodsName + " is invalid goods name!");
        }
        if (quantity < 0) {
            throw new InputException(quantity + " is invalid quantity!");
        }
        return priceList.get(goodsName) * quantity;
    }

    private static Map<String, Double> priceList = new HashMap<String, Double>();// the price list store the goods name and its price per Credits.

    public double getPrice(String targetGoodsName) {
        return priceList.get(targetGoodsName);
    }
}
