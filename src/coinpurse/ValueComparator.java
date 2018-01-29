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
        String baht = "Baht";
        String dollar = "Dollar";
        if (a.getCurrency().equals(b.getCurrency())) return 0;
        if (a.getCurrency().equals(dollar) && b.getCurrency().equals(baht)) return 1;
        return -1;
    }
}
