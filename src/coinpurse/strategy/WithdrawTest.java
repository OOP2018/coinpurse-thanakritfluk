package coinpurse.strategy;
import coinpurse.Coin;
import coinpurse.Money;
import coinpurse.Valuable;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

/**
 * This use to test for Withdraw Strategy by using Junit.
 * @author Thanakrit Daorueang
 *
 */
public class WithdrawTest {

    private List<Valuable> money;
    private WithdrawStrategy strategy;


    /**
     * This use to set up the test before run any method.
     */
    @Before
    public void setUp() {
        strategy = new GreedyWithdraw();
        money = new ArrayList<>();
    }

    /**
     * This use to test the over withdraw than the purse have.
     */
    @Test
    public void testGreedyWithdraw() {
        Valuable amount = new Money(250, "Baht");
        money.add(new Coin(1, "Baht"));
        money.add(new Money(25, "Baht"));
        assertTrue(strategy.withdraw(amount, money) == null);
    }

    /**
     * This use to test withdraw all the money in purse.
     */
    @Test
    public void testWithdrawAll() {
        Valuable amount = new Money(150, "Baht");
        money.add(new Money(100, "Baht"));
        money.add(new Money(50, "Baht"));
        List<Valuable> copyList = new ArrayList<>(money);
        copyList.removeAll(strategy.withdraw(amount, money));
        assertEquals(Collections.emptyList(), copyList);
    }


    /**
     * This use to test withdraw the zero value.
     */
    @Test
    public void testWithdrawZero() {
        Valuable amount = new Money(0, "Baht");
        money.add(new Money(50, "Baht"));
        assertTrue(strategy.withdraw(amount, money) == null);
    }

    /**
     * This use to test withdraw the different currency that purse have.
     */
    @Test
    public void testWithdrawWrongCurrency() {
        Valuable amount = new Money(10, "Baht");
        money.add(new Money(2, "Ringgit"));
        assertTrue(strategy.withdraw(amount, money) == null);
    }

    /**
     * This use to test withdraw all item in the purse except one item.
     */
    @Test
    public void testWithdrawExceptOneItem() {
        money.add(new Money(1,"Baht"));
        money.add(new Money(20,"Baht"));
        money.add(new Money(0.5,"Baht"));
        money.add(new Money(10,"Baht"));
        List<Valuable> result = strategy.withdraw(new Money(31, "Baht"), money);
        assertEquals(3, result.size());
    }

    /**
     * This use to test the withdraw with basic step.
     */
    @Test
    public void testEasyWithdraw() {
        money.add(new Money(1,"Baht"));
        money.add(new Money(20,"Baht"));
        money.add(new Money(0.5,"Baht"));
        money.add(new Money(10,"Baht"));
        List<Valuable> result = strategy.withdraw(new Money(31 , "Baht"),money);
        assertTrue(result!=null);
    }


    }
