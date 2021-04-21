package units;

import units.fight.FightUnit;
import units.fight.Goblin;
import units.fight.Skeleton;

import java.util.Random;

public final class GenerateUnits {

    // OPTIMIZE: 17.04.2021 пока логика простая - множителем является уровень игрока
    public static FightUnit getFightUnit(int levelUnit) {

        final int MIN_VALUE = 1; //для того что бы не генерировался 0

        FightUnit fightUnit;
        Random random = new Random();

        int generatorTypeUnit = random.nextInt(100);
        int force = (random.nextInt((GameUnit.FORCE_BASIC - MIN_VALUE) + 1) + MIN_VALUE) + levelUnit;
        int agility = (random.nextInt((GameUnit.AGILITY_BASIC - MIN_VALUE) + 1) + MIN_VALUE) + levelUnit;
        int gold = (random.nextInt((GameUnit.GOLD_BASIC - MIN_VALUE) + 1) + MIN_VALUE) * levelUnit;
        int experience = (random.nextInt((GameUnit.EXPERIENCE_BASIC - MIN_VALUE) + 1) + MIN_VALUE) * levelUnit;

        if (generatorTypeUnit % 2 != 0) fightUnit = new Skeleton(force, agility, gold, experience);
        else
            fightUnit = new Goblin(force, agility, gold, experience);

        return fightUnit;
    }

}
