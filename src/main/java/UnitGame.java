public abstract class UnitGame {

    protected String name; //имя
    protected int health; //здоровье
    protected int force; //сила
    protected int agility; //ловкость
    protected int gold; //золото
    protected int experience; //опыт

    public UnitGame(String name, int health, int force, int agility, int gold, int experience) {
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
}
