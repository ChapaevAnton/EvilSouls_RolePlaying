package units.neutral;

import units.GameUnit;

import java.util.ArrayList;
import java.util.Arrays;

public class Dealer extends GameUnit {

    ArrayList<Goods> goods;

    public Dealer(String name) {
        super(name, 100, 1, 1, 0, 0, 1);
        this.goods = new ArrayList<>(Arrays.asList(Goods.POTION10, Goods.SHARPEN_SWORD, Goods.STRENGTHEN_SHIELD));
    }


    public String getThingName(Goods item) {
        return goods.get(goods.indexOf(item)).thing.name;
    }

    public int getThingPrice(Goods item) {
        return goods.get(goods.indexOf(item)).thing.price;
    }

    public int getThingCharacter(Goods item) {
        return goods.get(goods.indexOf(item)).thing.characteristics;
    }

    public enum Goods {

        POTION10(new Thing("Лечебное зелье +10", 25, 10)),
        POTION20(new Thing("Лечебное зелье +20", 50, 20)),
        SHARPEN_SWORD(new Thing("Заточить меч", 25, 5)),
        STRENGTHEN_SHIELD(new Thing("Укрепить щит", 25, 5));

        Thing thing;

        Goods(Thing thing) {
            this.thing = thing;
        }

    }

    static class Thing {

        String name;
        int price;
        int characteristics;

        Thing(String name, int price, int characteristics) {
            this.name = name;
            this.price = price;
            this.characteristics = characteristics;
        }


    }


}
