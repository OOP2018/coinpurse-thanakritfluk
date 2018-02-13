package coinpurse;

/**
 * This class use for manage banknote and coin.
 * @author Thanakrit Daorueang
 */
public class Money implements Valuable{

     double value;
     String currency;

    /**
     * This use to set the value and currency of money.
     * @param value
     * @param currency
     */
    public Money(double value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    /**
     *
     * This use to get value from money.
     * @return value of money.
     */
    public double getValue() {
        return this.value;
    }

    /**
     * This use to get currency of money.
     * @return currency of money.
     */
    public String getCurrency() {
        return this.currency;
    }

    /**
     * This use to check this and obj equals or not.
     * @param obj the object use to check with this.
     * @return true if equals and false if not.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        Valuable a = (Valuable) obj;
        return this.getValue() == a.getValue() && this.getCurrency().equals(a.getCurrency());
    }

    /**
     * This use to ompare value of this and o.
     * @param o is object that use to compare.
     * @return 1 if this is bigger than o.
     *         0 if this is equals o.
     *         -1 if this is less than o.
     */
    public int compareTo(Valuable o) {
        return Double.compare(this.getValue(),o.getValue());
    }


}
