package coinpurse.strategy;

import coinpurse.Valuable;

import java.util.ArrayList;
import java.util.List;

/**
 * This calss use to process the withdraw by recursion.
 * @author Thanakrit Daorueang
 */
public class RecursiveWithdraw implements WithdrawStrategy {


    /**
     * This use to find the list of money that can withdraw by recursion process.
     * @param amount value that need to withdraw.
     * @param valuables the purse that contain the money or coin available to withdraw.
     * @return
     */
    @Override
    public List<Valuable> withdraw(Valuable amount, List<Valuable> valuables) {
        return helpRecursion(amount.getValue(), valuables);
    }

    public List<Valuable> helpRecursion(double amount, List<Valuable> money) {
        if (amount == 0) return new ArrayList<Valuable>();
        if (money.size() == 0 && amount!=0 || amount < 0) return null;
        List<Valuable> withdrawList = helpRecursion(amount - money.get(0).getValue(), money.subList(1, money.size()));
        if (withdrawList != null) {
            withdrawList.add(money.get(0));
            return withdrawList;
        } else return helpRecursion(amount, money.subList(1, money.size()));
    }

    /**
     * This use to sum the total value in the list.
     * @param money the list that are requested.
     * @return the total value that have in the list.
     */
    public double getTotalValue(List<Valuable> money) {
        double total = 0;
        for (Valuable value : money) {
            total += value.getValue();
        }
        return total;
    }

}
