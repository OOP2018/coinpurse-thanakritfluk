package coinpurse;

import java.util.ArrayList;
import java.util.List;

public class MoneyUtil {

    public static void main(String[] args) {
        List<Coin> coins = new ArrayList<Coin>();
        coins.add(new Coin(10.0, "Baht"));
        coins.add(new Coin(0.5, "Baht"));
        coins.add(new Coin(25.0, "Dollar"));
        coins.add(new Coin(2.0, "Baht"));
        coins.add(new Coin(2.0, "Dollar"));
        coins.add(new Coin(1.0, "Baht"));
        printCoins(coins);
        sortCoins(coins);
        printCoins(coins);

        List<Coin> testFilter = filterByCurrency(coins,"Dollar");
        System.out.println("Sort Currency: "+testFilter);

    }

    /**
     * This method use to sort coin from big to small.
     *
     * @param coins is the list include value and currency
     */
    public static void sortCoins(List coins) {
        java.util.Collections.sort(coins);
    }

    /**
     * This method use to print all the coin value in list.
     *
     * @param coins is the list include value and currency
     */
    public static void printCoins(List<Coin> coins) {
        System.out.println(coins);
    }


    /**
     * This method use to sort the coin with same currency and return by list.
     * @param coins is the list contain value and currency of coins.
     * @param currency ts the currency of types that use to check.
     * @return the list of the coin that sort by currency
     */
    public static List<Coin> filterByCurrency(List<Coin> coins,String currency){
        List<Coin> sortCurrency = new ArrayList<Coin>();
        for(Coin a : coins) {
            if(a.getCurrency().toLowerCase().equals(currency.toLowerCase())) {
                sortCurrency.add(a);
            }
        }
        return sortCurrency;

    }


}
