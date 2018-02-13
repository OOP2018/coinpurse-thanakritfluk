package coinpurse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * A coin purse contains valuable.
 * You can insert valuable, withdraw money, check the balance,
 * and check if the purse is full.
 *
 * @author Thanakrit Daorueang
 */
public class Purse {
    /**
     * Comparator of valuable.
     */
    private Comparator<Valuable> comp = new ValueComparator();
    /**
     * Collection of objects in the purse.
     */
    private List<Valuable> money;

    /**
     * Capacity is maximum number of items the purse can hold.
     * Capacity is set when the purse is created and cannot be changed.
     */
    private final int capacity;

    /**
     * Create a purse with a specified capacity.
     *
     * @param capacity is maximum number of valuable you can put in purse.
     */
    public Purse(int capacity) {
        money = new ArrayList<>();
        this.capacity = capacity;
    }

    /**
     * Count and return the number of valuable in the purse.
     * This is the number of valuable, not their value.
     *
     * @return the number of valuable in the purse
     */
    public int count() {
        return money.size();
    }

    /**
     * Get the total value of all items in the purse.
     *
     * @return the total value of items in the purse.
     */
    public double getBalance() {
        double total = 0;
        for (Valuable a : money) {
            total += a.getValue();
        }
        return total;
    }


    /**
     * Return the capacity of the coin purse.
     *
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * PurseUtil whether the purse is full.
     * The purse is full if number of items in purse equals
     * or greater than the purse capacity.
     *
     * @return true if purse is full.
     */
    public boolean isFull() {
        if (count() < this.capacity) {
            return false;
        }
        return true;
    }

    /**
     * Insert a valuable into the purse.
     * The valuable is only inserted if the purse has space for it
     * and the valuable has positive value.  No worthless valuable!
     *
     * @param valuable is a valuable object to insert into purse
     * @return true if valuable inserted, false if can't insert
     */
    public boolean insert(Valuable valuable) {
        // if the purse is already full then can't insert anything.
        if (valuable.getValue() == 0) {
            return false;
        } else {
            if (isFull()) {
                return false;
            }
            money.add(valuable);
            return true;
        }
    }

    /**
     * Withdraw the requested amount of money.
     * Return an array of valuable withdrawn from purse,
     * or return null if cannot withdraw the amount requested.
     *
     * @param amount is the amount to withdraw
     * @return array of Coin objects for money withdrawn,
     * or null if cannot withdraw requested amount.
     */
    public Valuable[] withdraw(Valuable amount) {
        if (amount.getValue() <= 0 || amount == null) return null;
        List<Valuable> templist = new ArrayList<>();
        money.sort(comp);
        double amountNeededToWithdraw = amount.getValue();

        for (int i = money.size() - 1; i >= 0; i--) {
            if (amountNeededToWithdraw == 0) break;
            if (amountNeededToWithdraw > 0 && amount.getCurrency().equals(money.get(i).getCurrency())) {
                if (amountNeededToWithdraw - money.get(i).getValue() >= 0) {
                    amountNeededToWithdraw -= money.get(i).getValue();
                    templist.add(money.get(i));
                    money.remove(i);
                }
            }
        }
        Valuable[] array = new Valuable[templist.size()];
        array = templist.toArray(array);
        if (amountNeededToWithdraw > 0) {
            money.addAll(templist);
            return null;
        }

        return array;

    }

    /**
     * Withdraw the requested amount of money with baht currency only.
     * Return an array of valuable withdrawn from purse,
     * or return null if cannot withdraw the amount requested.
     *
     * @param amount is the amount to withdraw
     * @return array of Coin objects for money withdrawn,
     * or null if cannot withdraw requested amount.
     */
    public Valuable[] withdraw(double amount) {
        return withdraw(new Money(amount, "Baht"));
    }


    /**
     * toString returns a string description of the purse contents.
     * It can return whatever is a useful description.
     */

    public String toString() {
        return String.format("Money in the purse: %.2f", getBalance());

    }


}
