import java.util.Random;

public final class Goblin extends GameUnit implements Attackers, Defenders {

    public Goblin(String name, int gold, int experience) {
        super(name, 100, 8, 2, gold, experience);
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