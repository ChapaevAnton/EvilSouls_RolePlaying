import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameUnitTest {

    Hero hero = new Hero("hero", 10, 10);
    Skeleton skeleton = new Skeleton("skeleton", 10, 100);
    Goblin goblin = new Goblin("goblin", 10, 100);

    Attackers[] attackersUnits = {hero, skeleton, goblin};

    @Test
    void attack() {

        for (Attackers unit : attackersUnits) {
            int attackHit = unit.attack();
            assertTrue(() -> attackHit >= 0, "Unit negative attack damage: "+unit.getClass());
        }
    }

    @Test
    void defence() {
    }
}