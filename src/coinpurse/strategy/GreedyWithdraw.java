package coinpurse.strategy;

import coinpurse.Valuable;
import coinpurse.ValueComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This use to withdraw use logic same like in the old purse lab.
 * @author Thanakrit Daorueang
 */
public class GreedyWithdraw implements WithdrawStrategy {

    private Comparator<Valuable> comp = new ValueComparator();

    /**
     * This use to return the list of item that can withdraw by request amount.
     * @param amount the value that want to withdraw.
     * @param items the list of purse.
     */
    @Override
    public List<Valuable> withdraw(Valuable amount, List<Valuable> items) {
        if (amount.getValue() <= 0 || amount == null) return null;
        List<Valuable> templist = new ArrayList<>();
        Collections.sort(items);
        double amountNeededToWithdraw = amount.getValue();

        for (int i = items.size() - 1; i >= 0; i--) {
            if (amountNeededToWithdraw == 0) break;
            if (amountNeededToWithdraw > 0 && amount.getCurrency().equals(items.get(i).getCurrency())) {
                if (amountNeededToWithdraw - items.get(i).getValue() >= 0) {
                    amountNeededToWithdraw -= items.get(i).getValue();
                    templist.add(items.get(i));
//                    items.remove(i);
                }
            }
        }
        List <Valuable> array = new ArrayList<>();
        array = templist;
        if (amountNeededToWithdraw > 0) {
            items.addAll(templist);
            return null;
        }
        return array;
    }

    /**
     * This use to sum the total value in the list.
     * @param money the list that are requested.
     * @return the total value that have in the list.
     */
    public double getTotalValue(List<Valuable> money){
        double total = 0;
        for (Valuable value:money){
            total += value.getValue();
        }
        return total;
    }

}
