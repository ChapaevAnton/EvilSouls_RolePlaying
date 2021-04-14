import units.FightUnit;
import units.Hero;
import units.Skeleton;

public class WorldGame {

    public static void main(String[] args) {


        FightUnit player = new Hero("player", 5, 5);
        FightUnit skeleton = new Skeleton("skeleton", 5, 100);


        new Battlefield().battle(player,skeleton);

    }

}
