package coinpurse;

import java.util.Comparator;

/**
 *
 * Comparator for Valuable class.
 * @author Thanakrit Daoraueang
 *
 */
public class ValueComparator implements Comparator<Valuable> {
    /**
     * Compare two objects that implement Valuable.
     * First compare them by currency, so that "Baht" < "Dollar".
     * If both objects have the same currency, order them by value.
     */
    public int compare(Valuable a, Valuable b) {
        if (a.getValue() - b.getValue() == 0)
            return 0;
        else if (a.getValue() - b.getValue() > 0)
            return 1;
        else return -1;
    }
}
