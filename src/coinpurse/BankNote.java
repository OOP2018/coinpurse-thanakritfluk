package coinpurse;

/**
 * Banknote (Valuable) with a fixed value,currency and serialNumber.
 *
 * @author Thanakrit Daorueang
 */
public class BankNote implements Valuable {
    /**
     * value of banknote.
     */
    private double value;
    /**
     * currency of banknote.
     */
    private String currency;
    /**
     * serialNumber of banknote.
     */
    private long serialNumber;
    /**
     * next serial number of next banknote.
     */
    private static long nextSerialNumber = 999999;

    /**
     * This is the construtor of the class that set the value,currency and serial number.
     *
     * @param value    of banknote.
     * @param currency of banknote.
     */
    public BankNote(double value, String currency) {
        this.value = value;
        this.currency = currency;
        this.serialNumber = nextSerialNumber + 1;

    }

    /**
     * This return the value of banknote.
     *
     * @return the value of banknote.
     */
    public double getValue() {
        return this.value;
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
     * This return the currency of banknote.
     *
     * @return the cuurency of banknote.
     */
    public String getCurrency() {
        return this.currency;
    }

    /**
     * This use to prove that the object equals or not.
     *
     * @param obj is the object to prove with this.
     * @return the boolean if equals return true and false if not equals.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        BankNote a = (BankNote) obj;
        return this.value == a.value && this.currency.equals(a.currency);
    }

    /**
     * This use to print value,currency and serial number in specific form.
     *
     * @return the form of value,currency and serial number.
     */
    @Override
    public String toString() {
        return String.format("%.0f-%s [%d]", this.value, this.currency, serialNumber);
    }

}
