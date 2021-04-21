package battle;

import units.fight.FightUnit;
import units.fight.Hero;

public final class Battlefield {

    public void battle(FightUnit unitFirst, FightUnit unitSecondary, BattleCallback battleCallback) {

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

    }

    private boolean fightOfBattle(FightUnit attackUnit, FightUnit defenceUnit, BattleCallback battleCallback) {

        if (defenceUnit.getHealth() > 0) {
            int attack = attackUnit.attack() + attackUnit.getSword();
            int defence = defenceUnit.defence() + defenceUnit.getShield();
            int damageHit = attack - defence;

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
        }

        if (defenceUnit.getHealth() <= 0 && defenceUnit instanceof Hero) {
            defenceUnit.setHealth(0);
            System.out.println("\u23F9 FINISH HIM!!!");
            battleCallback.battleLos();
            return false;

        } else if (defenceUnit.getHealth() <= 0 && !(defenceUnit instanceof Hero)) {
            defenceUnit.setHealth(0);
            //начисляем опыт и золото победителю
            attackUnit.setGold(attackUnit.getGold() + defenceUnit.getGold());
            attackUnit.setExperience(attackUnit.getExperience() + defenceUnit.getExperience());
            attackUnit.setKillCount(attackUnit.getKillCount() + 1);
            System.out.println("\u23F9 FINISH HIM!!!");
            //повышение уровня пока есть для этого опыт
            while (attackUnit.getExperience() >= 200) {
                attackUnit.setLevel(attackUnit.getLevel() + 1);
                attackUnit.setExperience(attackUnit.getExperience() - 200);
                System.out.println("\u23EB Ваш уровень повышен!");
            }

            battleCallback.battleWin();
            return false;
        }

        return true;
    }

}
