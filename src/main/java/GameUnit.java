public abstract class GameUnit {

    protected String name; //имя
    protected int health; //здоровье
    protected int force; //сила
    protected int agility; //ловкость
    protected int gold; //золото
    protected int experience; //опыт

    protected GameUnit(String name, int health, int force, int agility, int gold, int experience) {
        this.name = name;
        this.health = health;
        this.force = force;
        this.agility = agility;
        this.gold = gold;
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", health=" + health +
                '}';
    }

    protected int getHealth() {
        return health;
    }

}
