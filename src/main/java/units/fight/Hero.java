package units.fight;

import java.util.Random;

public final class Hero extends FightUnit {

    public static int LEVEL_UP = 100;

    public Hero(String name, int force, int agility) {

        super(name, 100, force, agility, 100, 0, 1, 0, 0);
    }

    @Override
    public int attack() {

        int attackHit = 0;
        int powerHit = force + agility;
        int multiplier = new Random().nextInt(100);

        if (multiplier > 90) attackHit = powerHit + multiplier;
        else if (multiplier >= 70) attackHit = powerHit + multiplier / 2;
        else if (multiplier >= 50) attackHit = Math.max(force, agility);

        return attackHit;
    }

    @Override
    public int defence() {
        int defenceHit = Math.max(force, agility);
        int multiplier = new Random().nextInt(defenceHit);
        return defenceHit + multiplier;
    }

}
