package units;

public abstract class GameUnit {

    static public final int FORCE_BASIC = 5;
    static public final int AGILITY_BASIC = 5;
    static public final int GOLD_BASIC = 100;
    static public final int EXPERIENCE_BASIC = 100;


    protected String name; //имя
    protected int health; //здоровье
    protected int force; //сила
    protected int agility; //ловкость
    protected int gold; //золото
    protected int experience; //опыт
    protected int level; //уровень

    protected GameUnit(String name, int health, int force, int agility, int gold, int experience, int level) {
        this.name = name;
        this.health = health;
        this.force = force;
        this.agility = agility;
        this.gold = gold;
        this.experience = experience;
        this.level = level;
    }

    @Override
    public String toString() {
        return name + "(" + health + ")";
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getFullInfoUnit() {
        return String.format(
                "Имя: %s\n" +
                        "Уровень: %d Опыт: %d\n" +
                        "Здоровье: %d\n" +
                        "Сила: %d\n" +
                        "Ловкость: %d\n" +
                        "Золото: %d\n", name, level, experience, health, force, agility, gold);
    }

}
