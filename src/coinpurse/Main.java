package coinpurse;

import java.util.ArrayList;
import java.util.List;

/**
 * A main class to create objects and connect objects together.
 * The user interface needs a reference to coin purse.
 * @author Thanakrit Daorueang
 */
public class Main {

    /**
     * Configure and start the application.
     * @param args not used
     */
    public static void main( String[] args ) {
    	//TODO follow the steps in the sequence diagram on Lab sheet.

//        List<Coin> coins = new ArrayList<Coin>();
//        coins.add(new Coin(10.0,"Baht"));
//        coins.add(new Coin(0.5,"Baht"));
//        coins.add(new Coin(2.0,"Baht"));
//        coins.add(new Coin(1.0,"Baht"));
//        System.out.println(coins);
//        java.util.Collections.sort(coins);
//        System.out.println(coins);

        // 1. create a Purse
    	Purse purse = new Purse(10);
        // 2. create a ConsoleDialog with a reference to the Purse object
    	ConsoleDialog ui = new ConsoleDialog(purse);
        // 3. run the ConsoleDialog
    	ui.run();

    }
}
