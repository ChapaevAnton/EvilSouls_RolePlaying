package units.fight;

import java.util.Random;

public final class Goblin extends FightUnit {

    public Goblin(int force, int agility, int gold, int experience) {
        super("goblin", 100, force, agility, gold, experience, 1);
    }

    @Override
    public int attack() {
        int attackHit = 0;
        int powerHit = force + agility;
        int multiplier = new Random().nextInt(100);

        if (multiplier > 80) attackHit = powerHit + multiplier / 2;
        else if (multiplier >= 20) attackHit = Math.max(force, agility) * 2;

        return attackHit;
    }

    @Override
    public int defence() {
        int defenceHit = Math.max(force, agility);
        int multiplier = new Random().nextInt(defenceHit);
        return defenceHit + multiplier;
    }
}