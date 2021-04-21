package units.fight;

import java.util.Random;

public final class Skeleton extends FightUnit {

    public Skeleton(int force, int agility, int gold, int experience) {

        super("skeleton", 100, force, agility, gold, experience,1,0,0);
    }

    @Override
    public int attack() {

        int attackHit = 0;
        int powerHit = force + agility;
        int multiplier = new Random().nextInt(100);

        if (multiplier > 50) attackHit = powerHit + multiplier / 2;
        else if (multiplier >= 40) attackHit = Math.max(force, agility);

        return attackHit;
    }

    @Override
    public int defence() {
        int defenceHit = Math.max(force, agility);
        int multiplier = new Random().nextInt(defenceHit);
        return defenceHit + multiplier;
    }
}