package coinpurse;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * This use to tset all of money factory it can work correctly or not.
 * @author Thanakrit Daorueang.
 */
public class MoneyFactoryTest {

    /**
     * This use to test singleton of money factory.
     */
    @Test
    public void testSingleton() {
        MoneyFactory a = MoneyFactory.getInstance();
        MoneyFactory b = MoneyFactory.getInstance();
        assert (a == b);
    }

    /**
     * This use to test Thai money factory that it can create money and set currency correct or not.
     */
    @Test
    public void testThaiMoney() {
        MoneyFactory a = new ThaiMoneyFactory();
        assertEquals(10.0, a.createMoney(10).getValue());
        assertEquals(20.0, a.createMoney(20).getValue());
        assertEquals(50.0, a.createMoney(50).getValue());
        assertEquals(100.0, a.createMoney(100).getValue());
        assertEquals("Baht", a.createMoney(100).getCurrency());
    }

    /**
     * This use to test Malay money factory that it can create money and set currency correct or not.
     */
    @Test
    public void testMalayMoney() {
        MoneyFactory a = new MalayMoneyFactory();
        assertEquals(0.20, a.createMoney(0.20).getValue());
        assertEquals(0.05, a.createMoney(0.05).getValue());
        assertEquals(50.0, a.createMoney(50).getValue());
        assertEquals(100.0, a.createMoney(100).getValue());
        assertEquals("Sen", a.createMoney(0.20).getCurrency());
        assertEquals("Ringgit", a.createMoney(100).getCurrency());
    }

    /**
     * This use to test that it can set the factory to Thai money factory correct or not.
     */
    @Test
    public void testSetThaiFactory() {
        MoneyFactory.setFactory(new ThaiMoneyFactory());
        MoneyFactory a = MoneyFactory.getInstance();
        assertTrue(a instanceof ThaiMoneyFactory);
    }

    /**
     * This use to test that it can set the factory to Malay money factory correct or not.
     */
    @Test
    public void testSetMalayFactory() {
        MoneyFactory.setFactory(new MalayMoneyFactory());
        MoneyFactory b = MoneyFactory.getInstance();
        assertTrue(b instanceof MalayMoneyFactory);
    }


}
