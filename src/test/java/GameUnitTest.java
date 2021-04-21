import org.junit.jupiter.api.Test;
import units.fight.FightingUnit;
import units.fight.Goblin;
import units.fight.Hero;
import units.fight.Skeleton;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GameUnitTest {

    Hero hero = new Hero("hero", 10, 10);
    Skeleton skeleton = new Skeleton(10, 10, 100, 100);
    Goblin goblin = new Goblin(10, 10, 100, 100);

    FightingUnit[] fightingUnits = {hero, skeleton, goblin};

    @Test
    void attack() {

        for (FightingUnit unit : fightingUnits) {
            int attackHit = unit.attack();
            assertTrue(() -> attackHit >= 0, "Unit negative attack damage: " + unit.getClass());
        }
    }

    @Test
    void defence() {

        for (FightingUnit unit : fightingUnits) {
            int defenderHit = unit.defence();
            assertTrue(() -> defenderHit >= 0, "Unit negative defender block: " + unit.getClass());
        }

    }
}