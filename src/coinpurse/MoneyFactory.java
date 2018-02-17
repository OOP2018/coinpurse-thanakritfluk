package coinpurse;

/**
 * This class use to manage the MoneyFactory to get instance,set factory and create money.
 * @author Thanakrit Daorueang.
 */
public abstract class MoneyFactory {

    /**
     * This is the instance of money factory.
     */
    private static MoneyFactory ourInstance;

    /**
     * This use to get instance of money factory
     * @return the instance of money factory.
     */
    public static MoneyFactory getInstance() {
        return ourInstance;
    }

    /**
     * This use to protect money factory.
     */
    protected MoneyFactory() {
    }

    /**
     * This is the abstract to create money.
     * @param value the value that user input.
     * @return Valuable.
     */
    public abstract Valuable createMoney(double value);

    /**
     * This use to create the money of factory.
     * @param value the string that contain the value.
     * @return the value in type double.
     */
    public Valuable createMoney(String value) {
        try {
            return createMoney(Double.parseDouble(value));
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("It's not a number.");
        }

    }

    /**
     * This use to set f to be the instance.
     * @param f the money factory.
     */
    public static void setFactory(MoneyFactory f) {
        ourInstance = f;
    }

}
