import units.neutral.Dealer;

public class Test {


    public static void main(String[] args) {


        Dealer dealer = new Dealer("Торговец");
        System.out.println(dealer.getThingName(Dealer.Goods.POTION10));
        System.out.println(dealer.getThingPrice(Dealer.Goods.POTION10));
        System.out.println(dealer.getThingCharacter(Dealer.Goods.POTION10));




    }
}
