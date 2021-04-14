import java.util.Random;

public final class Skeleton extends GameUnit implements Attackers, Defenders {

    public Skeleton(String name, int gold, int experience) {
        super(name, 100, 5, 8, gold, experience);
    }

    @Override
    public int attack() {

        int attackHit = 0;
        int powerHit = force + agility;
        int multiplier = new Random().nextInt(100);

        if (multiplier > 50) attackHit = powerHit + multiplier / 2;
        else if (multiplier >= 20) attackHit = Math.max(force, agility);;

        return attackHit;
    }

    @Override
    public int defence() {
        return 0;
    }
}