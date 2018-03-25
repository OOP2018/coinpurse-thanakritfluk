package coinpurse;

import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * A main class to create objects and connect objects together.
 * The user interface needs a reference to coin purse.
 *
 * @author Thanakrit Daorueang
 */
public class Main {

    /**
     * This use to reading the propoties file and the key of factory.
     */
    public static void init() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Purse");
        String classFactory = resourceBundle.getString("moneyfactory");
        MoneyFactory factory = null;
        try {
            factory = (MoneyFactory) Class.forName(classFactory).newInstance();
        } catch (ClassCastException cce) {
            System.out.println(classFactory + " is not type MoneyFactory");
        } catch (Exception ex) {
            System.out.println("Error creating MoneyFactory " + ex.getMessage());
        }
        if (factory == null) System.exit(1);
        MoneyFactory.setFactory(factory);
    }


    /**
     * Configure and start the application.
     *
     * @param args not used
     */
    public static void main(String[] args) {
        // 1. create a Purse
        Purse purse = new Purse(2);
        // 2. create a ConsoleDialog with a reference to the Purse object
        ConsoleDialog ui = new ConsoleDialog(purse);
        // 3. run the ConsoleDialog
        ui.run();
    }
}
