package coinpurse;

/**
 * This use to test for thai money factory and malay money factory it can work correctly or not.
 * @author Thanakrit Daorueang.
 */
public class MoneyFactoryDemo {

    public static void main(String[] args) {
        System.out.println("Test create Thai money");
        MoneyFactory thaiFactory = new ThaiMoneyFactory();
        MoneyFactory malayFactory = new MalayMoneyFactory();
        MoneyFactory.setFactory(thaiFactory);
        MoneyFactory a = MoneyFactory.getInstance();
        Valuable thai1 = a.createMoney(10);
        System.out.println(thai1.toString());
        Valuable thai2 = a.createMoney(50);
        System.out.println(thai2.toString());
        Valuable thai3 = a.createMoney(500);
        System.out.println(thai3.toString());


        System.out.println("\nTest create Malay money");
        MoneyFactory.setFactory(malayFactory);
        MoneyFactory b = MoneyFactory.getInstance();
        Valuable malay1 = b.createMoney(0.1);
        System.out.println(malay1.toString());
        Valuable malay2 = b.createMoney(0.05);
        System.out.println(malay2.toString());
        Valuable malay3 = b.createMoney(100);
        System.out.println(malay3.toString());

        System.out.println("\nTest create Thai money again");
        MoneyFactory.setFactory(thaiFactory);
        a = MoneyFactory.getInstance();
        thai1 = a.createMoney(100);
        System.out.println(thai1.toString());

    }

}
