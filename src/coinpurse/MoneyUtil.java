package coinpurse;

import java.util.ArrayList;
import java.util.List;

public class MoneyUtil {

    public static void main(String[] args) {
        List<Coin> coins = new ArrayList<Coin>();
        coins.add(new Coin(10.0, "Baht"));
        coins.add(new Coin(0.5, "Baht"));
        coins.add(new Coin(2.0, "Baht"));
        coins.add(new Coin(1.0, "Baht"));
        printCoins(coins);
        sortCoins(coins);
        printCoins(coins);
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
    public static void printCoins(List coins) {
        System.out.println(coins);
    }


}
