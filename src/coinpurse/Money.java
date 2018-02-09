package coinpurse;

public class Money implements Valuable{

     double value;
     String currency;

    public Money(double value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    public double getValue() {
        return this.value;
    }

    public String getCurrency() {
        return this.currency;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        Valuable a = (Valuable) obj;
        return this.getValue() == a.getValue() && this.getCurrency().equals(a.getCurrency());
    }

    public int compareTo(Valuable o) {
        return Double.compare(this.getValue(),o.getValue());
    }


}
