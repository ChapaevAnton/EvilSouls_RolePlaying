package units.neutral;

import units.GameUnit;

public class Dealer extends GameUnit {

    Goods[] goods;

    public Dealer(String name) {
        super(name, 100, 1, 1, 0, 0, 1);
        this.goods = new Goods[]{Goods.POTION, Goods.SHARPEN_SWORD, Goods.STRENGTHEN_SHIELD};
    }


    public String getThingName(int index) {
        return goods[index].thing.name;
    }


    enum Goods {

        POTION(new Thing("Лечебное зелье", 25, 10)),
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
