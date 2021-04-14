public final class Goblin extends UnitGame implements Attackers,Defenders {

    public Goblin(String name, int gold, int experience) {
        super(name, 100, 8, 2, gold, experience);
    }

    @Override
    public int attack() {
        return 0;
    }

    @Override
    public int defence() {
        return 0;
    }
}