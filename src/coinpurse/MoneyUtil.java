package coinpurse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * this is testing coin class.
 * @author Thanakrit Daorueang
 */
public class MoneyUtil {

    public static void main(String[] args) {
        List<Valuable> valuables = new ArrayList<>();
        valuables.add(new BankNote(150 , "Bath"));
        valuables.add(new BankNote(300,"Bath"));
        valuables.add( new BankNote(0.5, "Bath"));
        valuables.add(new Coin(10.0, "Baht"));
        valuables.add(new Coin(0.5, "Baht"));
        valuables.add(new Coin(25.0, "Dollar"));
        valuables.add(new Coin(2.0, "Baht"));
        valuables.add(new Coin(2.0, "Dollar"));
        valuables.add(new Coin(1.0, "Baht"));
        printCoins(valuables);
        sortCoins(valuables);
        printCoins(valuables);

        List<Valuable> testFilter = filterByCurrency(valuables,"Dollar");
        System.out.println("Sort Currency: "+testFilter);

    }

    /**
     * This method use to sort coin from big to small.
     *
     * @param valuables is the list include value and currency
     */
    public static void sortCoins(List<Valuable> valuables) {
        Comparator<Valuable> comp = new ValueComparator();
        valuables.sort(comp);
    }

    /**
     * This method use to print all the coin value in list.
     *
     * @param valuables is the list include value and currency
     */
    public static void printCoins(List<Valuable> valuables) {
        System.out.println("All we have: "+valuables);
    }


    /**
     * This method use to sort the coin with same currency and return by list.
     * @param valuables is the list contain value and currency of valuables.
     * @param currency ts the currency of types that use to check.
     * @return the list of the coin that sort by currency
     */
    public static List<Valuable> filterByCurrency(List<Valuable> valuables,String currency){
        List<Valuable> sortCurrency = new ArrayList<Valuable>();
        for(Valuable a : valuables) {
            if(a.getCurrency().toLowerCase().equals(currency.toLowerCase())) {
                sortCurrency.add(a);
            }
        }
        return sortCurrency;

    }


}
