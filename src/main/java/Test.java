import units.neutral.Dealer;

public class Test {


    public static void main(String[] args) {


        Dealer dealer = new Dealer("Торговец");
        System.out.println(dealer.getThingName(0));
        System.out.println(dealer.getThingName(1));
        System.out.println(dealer.getThingName(2));

    }
}
