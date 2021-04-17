package units;

import java.util.Random;

public class GenerateUnits {

    // TODO: 17.04.2021 разработать логику генерации статов, золота и опыта, в зависимости от уровня героя
    public static FightUnit getFightUnit(int levelUnit) {

        FightUnit fightUnit;
        Random random = new Random();

        int generatorTypeUnit = random.nextInt(100);
        int force = random.nextInt(GameUnit.FORCE_BASIC) + levelUnit;
        int agility = random.nextInt(GameUnit.AGILITY_BASIC) + levelUnit;
        int gold = random.nextInt(GameUnit.GOLD_BASIC) + levelUnit;
        int experience = random.nextInt(GameUnit.EXPERIENCE_BASIC) + levelUnit;

        if (generatorTypeUnit % 2 != 0) fightUnit = new Skeleton(force, agility, gold, experience);
        else
            fightUnit = new Goblin(force, agility, gold, experience);

        return fightUnit;
    }

}
