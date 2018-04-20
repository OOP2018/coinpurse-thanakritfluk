package coinpurse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * this is testing coin class.
 *
 * @author Thanakrit Daorueang
 */
public class MoneyUtil {

    public static void main(String[] args) {
        List<Valuable> valuables = new ArrayList<>();
        valuables.add(new Coin(10.0, "Baht"));
        valuables.add(new Coin(0.5, "Baht"));
        valuables.add(new Coin(25.0, "Dollar"));
        valuables.add(new Coin(2.0, "Baht"));
        valuables.add(new Coin(2.0, "Dollar"));
        valuables.add(new Coin(1.0, "Baht"));
        printCoins(valuables);
        sortMoney(valuables);
        printCoins(valuables);

        List<Valuable> testFilter = filterByCurrency(valuables, "Dollar");
        System.out.println("Sort Currency: " + testFilter);

    }

    /**
     * This method use to sort coin from big to small.
     *
     * @param valuables is the list include value and currency
     */
    public static void sortMoney(List<? extends Valuable> valuables) {
        Comparator<Valuable> comp = new ValueComparator();
        valuables.sort(comp);
    }

    /**
     * This method use to print all the coin value in list.
     *
     * @param valuables is the list include value and currency
     */
    public static void printCoins(List<Valuable> valuables) {
        System.out.println("All we have: " + valuables);
    }


    /**
     * This method use to sort the coin with same currency and return by list.
     *
     * @param valuables is the list contain value and currency of valuables.
     * @param currency  ts the currency of types that use to check.
     * @return the list of the coin that sort by currency
     */
    public static <E extends Valuable> List<E> filterByCurrency(List<E> valuables, String currency) {
        List<E> sortCurrency = new ArrayList<>();
        for (E a : valuables) {
            if (a.getCurrency().toLowerCase().equals(currency.toLowerCase())) {
                sortCurrency.add(a);
            }
        }
        return sortCurrency;

    }

    /**
     * Return the larger argument, based on sort order, using
     * the objects' own compareTo method for comparing.
     *
     * @param args one or more Comparable objects to compare.
     * @return the argument that would be last if sorted the elements.
     * @throws IllegalArgumentException if no arguments given.
     */
    public static <E extends Comparable<? super E>> E max(E... args) {
        E max = args[0];
        for (E a : args) if (max.compareTo(a) < 0) max = a;
        return max;
    }
}
