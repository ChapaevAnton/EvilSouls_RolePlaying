package units.neutral;

import units.GameUnit;
import units.fight.FightUnit;

public final class Dealer extends GameUnit implements Trading {

    public Dealer(String name) {
        super(name, 100, 1, 1, 0, 0, 1);
    }

    @Override
    public void trade(FightUnit player, Goods selectedItem) {

        int deal = player.getGold() - selectedItem.thing.price;

        if (deal >= 0) {
            player.setGold(deal);
            this.setGold(this.getGold() + selectedItem.thing.price);

            int characteristics = selectedItem.thing.characteristics;

            //какие характеристики улучшаются
            switch (selectedItem) {
                case POTION10, POTION20 -> {
                    player.setHealth(player.getHealth() + characteristics);
                    System.out.println("Вы восполнили жизни +" + characteristics);
                }
                case SHARPEN_SWORD -> {
                    player.setSword(player.getSword() + characteristics);
                    System.out.println("Вы увеличили атаку +" + characteristics);
                }
                case STRENGTHEN_SHIELD -> {
                    player.setShield(player.getShield() + characteristics);
                    System.out.println("Вы увеличили защиту +" + characteristics);
                }
            }
            System.out.println("Сделка успешно совершена!");
        } else System.out.println("У вас недостаточно золота! ");
    }

    //OPTIMIZE 21.04.21 Когда отрицаешь существование Map
    public enum Goods {

        POTION10(new Thing(25, 10)),
        POTION20(new Thing(50, 20)),
        SHARPEN_SWORD(new Thing(25, 5)),
        STRENGTHEN_SHIELD(new Thing(25, 5));

        Thing thing;

        Goods(Thing thing) {
            this.thing = thing;
        }

    }

    private static class Thing {

        int price;
        int characteristics;

        Thing(int price, int characteristics) {

            this.price = price;
            this.characteristics = characteristics;
        }

    }

}
