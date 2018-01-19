package coinpurse;

public class Coin {
    private double value;
    private String currency;

    public Coin(double value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    public double getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object arg) {

        return false;
    }

    public int compareTo(Coin coin) {
        
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%0.2f-%d", getValue(), getCurrency());
    }
}
