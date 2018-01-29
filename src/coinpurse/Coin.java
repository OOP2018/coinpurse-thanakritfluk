package coinpurse;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 *
 * @author Thanakrit Daorueang
 */

public class Coin implements Comparable<Coin> , Valuable {

    private double value;
    private String currency;

    /**
     * @param value    is the value of money.
     * @param currency is the currency value of money.
     */

    public Coin(double value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    /**
     * This can get value of coin.
     *
     * @return the value of coin
     */
    public double getValue() {
        return value;
    }


    /**
     * This can get currency of coin.
     *
     * @return the currency of coin
     */
    public String getCurrency() {
        return currency;
    }


    /**
     * Comparing two objects if they are the same returning
     * a boolean type data.
     *
     * @param arg
     * @return true of false
     */
    @Override
    public boolean equals(Object arg) {
        if (arg == null) return false;
        if (arg.getClass() != this.getClass()) return false;
        Coin coin = (Coin) arg;
        return this.currency.equals(((Coin) arg).currency) && this.value == ((Coin) arg).value;

    }

    /**
     * This medthod is use to use to compare between 2 coin value.
     *
     * @param coin is the obj to compare.
     * @return number of result that compare value.
     */
    public int compareTo(Coin coin) {
        if (this.getValue() - coin.getValue() == 0)
            return 0;
        else if (this.getValue() - coin.getValue() > 0)
            return 1;
        else return -1;

    }

    /**
     * This method use to return the string in form of value and currency.
     *
     * @return String include value and currency.
     */
    @Override
    public String toString() {
        return value + "-" + currency;
    }
}