package units.neutral;

import units.GameUnit;
import units.fight.FightUnit;
import units.fight.Hero;

import java.util.ArrayList;
import java.util.Arrays;

public final class Dealer extends GameUnit implements Trading {

    private final ArrayList<Goods> goods;

    public Dealer(String name) {
        super(name, 100, 1, 1, 0, 0, 1);
        this.goods = new ArrayList<>(Arrays.asList(Goods.POTION10, Goods.SHARPEN_SWORD, Goods.STRENGTHEN_SHIELD));
    }


    public String getThingName(int index) {
        Thing thing = goods.get(index).thing;
        return thing.name + " - за " + thing.price + " золота";
    }

    public int getGoodsSize() {
        return goods.size();
    }

    @Override
    public void trade(FightUnit player, String selectedItem) {
        int index = Integer.parseInt(selectedItem) - 1;
        int deal = player.getGold() - goods.get(index).thing.price;

        if (deal >= 0) {
            player.setGold(deal);
            this.setGold(this.getGold() + goods.get(index).thing.price);

            int characteristics = goods.get(index).thing.characteristics;

            switch (index) {
                case 0 -> {
                    player.setHealth(player.getHealth() + characteristics);
                    System.out.println("Вы восполнили жизни +" + characteristics);
                }
                case 1 -> {
                    player.setSword(player.getSword() + characteristics);
                    System.out.println("Вы увеличили атаку +" + characteristics);
                }
                case 2 -> {
                    player.setShield(player.getShield() + characteristics);
                    System.out.println("Вы увеличили защиту +" + characteristics);
                }
            }
            System.out.println("Сделка успешно совершена!");
        } else System.out.println("У вас недостаточно золота! ");
    }

    //OPTIMIZE 21.04.21 Когда отрицаешь существование Map
    private enum Goods {

        POTION10(new Thing("Лечебное зелье +10", 25, 10)),
        POTION20(new Thing("Лечебное зелье +20", 50, 20)),
        SHARPEN_SWORD(new Thing("Заточить меч +5 к атаке", 25, 5)),
        STRENGTHEN_SHIELD(new Thing("Укрепить щит +5 к защите", 25, 5));

        Thing thing;

        Goods(Thing thing) {
            this.thing = thing;
        }

    }

    private static class Thing {

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
