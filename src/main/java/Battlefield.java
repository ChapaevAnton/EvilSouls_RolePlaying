import units.FightUnit;

public class Battlefield {

    public void battle(FightUnit unitFirst, FightUnit unitSecondary) {

        Thread runBattle = new Thread(() -> {
            int moveCounter = 1;
            boolean isRunOfBattle;
            System.out.println("\u25B6 FIGHT!!!");
            do {
                if (moveCounter % 2 == 0) {
                    isRunOfBattle = fightOfBattle(unitFirst, unitSecondary);
                } else {
                    isRunOfBattle = fightOfBattle(unitSecondary, unitFirst);
                }

                moveCounter++;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } while (isRunOfBattle);
            System.out.println("\u23F9 FINISH HIM!!!");
        });

        runBattle.start();
    }

    private boolean fightOfBattle(FightUnit attackUnit, FightUnit defenceUnit) {

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


        } else if (defenceUnit.getHealth() <= 0) {
            defenceUnit.setHealth(0);
            System.out.println("\u2620" + defenceUnit + "повержен");
            return false;
        }

        return true;
    }


}
