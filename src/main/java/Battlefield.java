import units.FightUnit;

public class Battlefield {

    public void battle(FightUnit unitFirst, FightUnit unitSecondary) {

        Thread runBattle = new Thread(() -> {
            int moveCounter = 1;
            boolean isRunOfBattle;

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
        });

        runBattle.start();
    }

    private boolean fightOfBattle(FightUnit attackUnit, FightUnit defenceUnit) {

        int damageHit = attackUnit.attack() - defenceUnit.defence();
        int currentHealthDefenceUnit = defenceUnit.getHealth() - damageHit;
        defenceUnit.setHealth(currentHealthDefenceUnit);


        if (defenceUnit.getHealth() > 0) {
            System.out.println("\u2694" + attackUnit + "нанес удар в " + damageHit + " очков урона, по " + defenceUnit);
        } else {
            System.out.println("\u2699" + attackUnit + "нанося удар и промахнулся по " + defenceUnit);
        }

        if (defenceUnit.getHealth() <= 0) {
            defenceUnit.setHealth(0);
            System.out.println("\u2620" + defenceUnit + "повержен");
            return false;
        }

        return true;
    }


}
