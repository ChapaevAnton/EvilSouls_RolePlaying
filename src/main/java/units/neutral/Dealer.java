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


    public String getThingName(int index) {
        return goods.get(index).thing.name;
    }

    public int getThingPrice(int index) {
        return goods.get(index).thing.price;
    }

    public int getThingCharacter(int index) {
        return goods.get(index).thing.characteristics;
    }

    public ArrayList<Goods> getGoods() {
        return goods;
    }

    //OPTIMIZE 21.04.21 Когда отрицаешь существование Map
    enum Goods {

        POTION10(new Thing("Лечебное зелье +10", 25, 10)),
        POTION20(new Thing("Лечебное зелье +20", 50, 20)),
        SHARPEN_SWORD(new Thing("Заточить меч +5", 25, 5)),
        STRENGTHEN_SHIELD(new Thing("Укрепить щит +5", 25, 5));

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
