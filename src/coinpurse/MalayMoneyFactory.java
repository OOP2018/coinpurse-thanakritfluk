package coinpurse;

/**
 * This class is the class that use to manage about malay money factory.
 * @author Thanakrit Daorueang.
 */
public class MalayMoneyFactory extends MoneyFactory {
    private final String malayCoin = "Sen";
    private final String malayBank = "Ringgit";

    /**
     * This use to set the serialnumber of Malay factory.
     */
    public MalayMoneyFactory() {
        BankNote.setNextSerialNumber(1000000);
    }

    /**
     * @param value the value that user input.
     * @return
     */
    @Override
    public Valuable createMoney(double value) {
        if (value == 0.05 || value == 0.10 || value == 0.20 || value == 0.50) return new Coin(value, malayCoin);
        else if (value == 1 || value == 2 || value == 5 || value == 10 || value == 20 || value == 50 || value == 100)
            return new BankNote(value, malayBank);
        else throw new IllegalArgumentException("Malay don't have that value");
    }
}
