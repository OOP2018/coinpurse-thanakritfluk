package coinpurse.strategy;

import coinpurse.Valuable;

import java.util.List;

/**
 * This class use to find and return list from a list of purse.
 *
 * @author Thanakrit Daorueang
 */
public interface WithdrawStrategy {

    /**
     * This use to find the list of item that can withdraw.
     * @param amount value that need to withdraw.
     * @param valuables the purse that contain the money or coin available to withdraw.
     * @return the list of money that can withdraw by not modify the purse.
     */
    List<Valuable> withdraw(Valuable amount, List<Valuable> valuables);


    /**
     * This use to find the total values of list.
     * @param baht the list of purse.
     * @return the double value all in the list.
     */
    double getTotalValue(List<Valuable> baht);
}
