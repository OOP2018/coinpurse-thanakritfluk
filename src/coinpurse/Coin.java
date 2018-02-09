package coinpurse;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 *
 * @author Thanakrit Daorueang
 */

public class Coin extends Money{


    /**
     * @param value    is the value of money.
     * @param currency is the currency value of money.
     */

    public Coin(double value, String currency) {
       super(value,currency);
    }

    /**
     * This method use to return the string in form of value and currency.
     *
     * @return String include value and currency.
     */
    @Override
    public String toString() {
        return this.getValue() + "-" + this.getCurrency();
    }
}