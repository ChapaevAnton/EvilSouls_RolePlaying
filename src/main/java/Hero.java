import java.util.Random;

public final class Hero extends UnitGame implements Attackers, Defenders {

    public Hero(String name, int force, int agility) {
        super(name, 100, force, agility, 0, 0);
    }

    @Override
    public int attack() {

        int attackHit = 0;
        int powerHit = force + agility;
        int multiplier = new Random().nextInt(100);

        if (multiplier > 90) attackHit = powerHit + multiplier;
        else if (multiplier >= 50) attackHit = powerHit + multiplier / 2;
        else if (multiplier >= 20) attackHit = Math.max(force, agility);

        return attackHit;
    }

    @Override
    public int defence() {
        return 0;
    }
}
