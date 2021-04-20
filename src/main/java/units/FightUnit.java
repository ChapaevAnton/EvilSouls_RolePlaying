package units;

public abstract class FightUnit extends GameUnit implements FightingUnit {

    protected int killCount;

    protected FightUnit(String name, int health, int force, int agility, int gold, int experience, int level) {
        super(name, health, force, agility, gold, experience, level);
    }

    public void setKillCount(int killCount) {
        this.killCount = killCount;
    }

    public int getKillCount() {
        return killCount;
    }

    @Override
    public String getFullInfoUnit() {
        return String.format(
                "Имя: %s\n" +
                        "Уровень: %d Опыт: %d\n" +
                        "Здоровье: %d\n" +
                        "Сила: %d\n" +
                        "Ловкость: %d\n" +
                        "Золото: %d\n" +
                        "Убито врагов: %d\n", name, level, experience, health, force, agility, gold, killCount);
    }
}
