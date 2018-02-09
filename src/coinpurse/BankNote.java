package coinpurse;

/**
 * Banknote (Valuable) with a fixed value,currency and serialNumber.
 *
 * @author Thanakrit Daorueang
 */
public class BankNote extends Money {

    /**
     * serialNumber of banknote.
     */
    private long serialNumber;
    /**
     * next serial number of next banknote.
     */
    private static long nextSerialNumber = 1000000;

    /**
     * This is the construtor of the class that set the value,currency and serial number.
     *
     * @param value    of banknote.
     * @param currency of banknote.
     */
    public BankNote(double value, String currency) {
        super(value, currency);
        this.serialNumber = nextSerialNumber;
        nextSerialNumber++;

    }

    /**
     * This return the serial number of banknote.
     *
     * @return the serial number of banknote.
     */
    public long getSerial() {
        return this.serialNumber;
    }

    /**
     * This use to print value,currency and serial number in specific form.
     *
     * @return the form of value,currency and serial number.
     */
    @Override
    public String toString() {
        return String.format("%.0f-%s [%d]", this.getValue(), this.getCurrency(), this.getSerial());
    }

}
