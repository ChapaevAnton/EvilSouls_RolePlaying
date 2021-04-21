package units.fight;

import units.GameUnit;

public abstract class FightUnit extends GameUnit implements FightingUnit {

    protected int killCount; //количество убитых врагов
    protected int sword; //атака
    protected int shield; //защита

    protected FightUnit(String name, int health, int force, int agility, int gold, int experience, int level, int sword, int shield) {
        super(name, health, force, agility, gold, experience, level);
        this.sword = sword;
        this.shield = shield;
    }

    public void setKillCount(int killCount) {
        this.killCount = killCount;
    }

    public int getKillCount() {
        return killCount;
    }

    public int getSword() {
        return sword;
    }

    public void setSword(int sword) {
        this.sword = sword;
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    @Override
    public String getFullInfoUnit() {
        return String.format(
                "Имя: %s\n" +
                        "Уровень: %d Опыт: %d\n" +
                        "Здоровье: %d\n" +
                        "Сила: %d\n" +
                        "Ловкость: %d\n" +
                        "Атака: %d\n" +
                        "Защита: %d\n" +
                        "Золото: %d\n" +
                        "Убито врагов: %d\n", name, level, experience, health, force, agility, sword, shield, gold, killCount);
    }
}
