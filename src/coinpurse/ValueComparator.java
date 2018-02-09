package coinpurse;

import java.util.Comparator;

/**
 * Comparator for Valuable class.
 *
 * @author Thanakrit Daoraueang
 */
public class ValueComparator implements Comparator<Valuable> {
    /**
     * Compare two objects that implement Valuable.
     * First compare them by the alphabet of currency, so that "Baht" < "Dollar".
     * If both objects have the same currency, order them by value.
     */
    public int compare(Valuable a, Valuable b) {
        if (a.getCurrency().toLowerCase().equals(b.getCurrency().toLowerCase())) {
            return Double.compare(a.getValue(),b.getValue());
        } else {
           return a.getCurrency().compareTo(b.getCurrency());
        }
    }
}
