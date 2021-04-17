package units;

public abstract class FightUnit extends GameUnit implements FightingUnit {

    protected FightUnit(String name, int health, int force, int agility, int gold, int experience, int level) {
        super(name, health, force, agility, gold, experience, level);
    }
}
