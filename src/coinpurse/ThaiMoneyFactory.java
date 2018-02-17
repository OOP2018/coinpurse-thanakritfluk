package coinpurse;

/**
 * This class is the class that use to manage about thai money factory.
 * @author Thanakrit Daorueang.
 */
public class ThaiMoneyFactory extends MoneyFactory {
    private final String TH_CUR = "Baht";

    /**
     * This use to set the serial number of Thai factory.
     */
    public ThaiMoneyFactory() {
        BankNote.setNextSerialNumber(1000000);
    }

    /**
     * @param value the value that user input.
     * @return
     */
    @Override
    public Valuable createMoney(double value) {
        if (value == 0.25 || value == 0.50 || value == 1 || value == 2 || value == 5 || value == 10)
            return new Coin(value, TH_CUR);
        else if (value == 20 || value == 50 || value == 100 || value == 500 || value == 1000)
            return new BankNote(value, TH_CUR);
        else throw new IllegalArgumentException("Thailand don't have that value");
    }

}
