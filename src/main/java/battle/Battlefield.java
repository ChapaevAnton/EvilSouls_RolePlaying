package battle;

import units.FightUnit;
import units.Hero;

public class Battlefield {

    public void battle(FightUnit unitFirst, FightUnit unitSecondary, BattleCallback battleCallback) {

        // OPTIMIZE: 18.04.2021 Возможно это можно сделать как имплементацию Runnable в классе Battlefield
        Thread runBattle = new Thread(() -> {
            int moveCounter = 1;
            boolean isRunOfBattle = true;
            System.out.println("\u25B6 FIGHT!!!");

            while (isRunOfBattle) {
                if (moveCounter % 2 == 0) {
                    isRunOfBattle = fightOfBattle(unitFirst, unitSecondary, battleCallback);
                } else {
                    isRunOfBattle = fightOfBattle(unitSecondary, unitFirst, battleCallback);
                }

                moveCounter++;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        });

        runBattle.start();
    }

    private boolean fightOfBattle(FightUnit attackUnit, FightUnit defenceUnit, BattleCallback battleCallback) {

        if (defenceUnit.getHealth() > 0) {

            int damageHit = attackUnit.attack() - defenceUnit.defence();

            if (damageHit < -10) {
                attackUnit.setHealth(attackUnit.getHealth() + damageHit);
                System.out.println("\u2694" + attackUnit + " нанеся слабый удар не пробил броню " + defenceUnit + ", при это раня себя на " + damageHit + " очков урона");
            } else if (damageHit <= 0) {
                defenceUnit.setHealth(defenceUnit.getHealth());
                System.out.println("\u2699" + attackUnit + " нанося удар и промахнулся по " + defenceUnit);
            } else {
                defenceUnit.setHealth(defenceUnit.getHealth() - damageHit);
                System.out.println("\u2694" + attackUnit + " нанес удар в " + damageHit + " очков урона, по " + defenceUnit);
            }


        } else if (defenceUnit.getHealth() <= 0 && defenceUnit instanceof Hero) {
            defenceUnit.setHealth(0);

            System.out.println("\u23F9 FINISH HIM!!!");
            System.out.println("\u2620" + defenceUnit + "повержен. Вы пали в бою как герой!!!");

            battleCallback.battleLos();

            return false;
        } else if (defenceUnit.getHealth() <= 0 && !(defenceUnit instanceof Hero)) {

            defenceUnit.setHealth(0);

            attackUnit.setGold(attackUnit.getGold() + defenceUnit.getGold());
            attackUnit.setExperience(attackUnit.getExperience() + defenceUnit.getExperience());

            System.out.println("\u23F9 FINISH HIM!!!");
            System.out.println("\u2620" + defenceUnit
                    + "Враг повержен. Вы получили "
                    + defenceUnit.getExperience()
                    + " единиц опыта и " + defenceUnit.getGold()
                    + " монет золота.");

            battleCallback.battleWin();

            return false;
        }

        return true;
    }


}
