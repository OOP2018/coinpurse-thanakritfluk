package coinpurse;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 *
 * @author Thanakrit Daorueang
 */

public class Coin implements Comparable<Coin> {

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

    public double getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }


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
//        else if (this.getValue()-coin.getValue()<0)
        else return -1;

    }

    @Override
    public String toString() {
        return value + "-" + currency;
    }
}
