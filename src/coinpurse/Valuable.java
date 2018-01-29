package coinpurse;

/**
 * An interface for objects having a monetary value and currency.
 *
 * @author Thanakrit Daowrueang
 */
public interface Valuable {

    /**
     * Get the monetary value of this object, in its own currency.
     *
     * @return the value of this object
     */

    double getValue();

    String getCurrency();
}
