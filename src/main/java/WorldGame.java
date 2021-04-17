import battle.BattleCallback;
import battle.Battlefield;
import units.FightUnit;
import units.GenerateUnits;
import units.Hero;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WorldGame {

    public static FightUnit player;

    public static void main(String[] args) {


        //загрузка логотипа
        final Path logo = Paths.get("src/main/resources/logo.txt");
        final Path logoPath = logo.toAbsolutePath();

        try (BufferedReader input = Files.newBufferedReader(logoPath, StandardCharsets.UTF_8)) {
            String line;
            while ((line = input.readLine()) != null) {
                System.out.println("\u001B[31m" + line);
            }
        } catch (IOException err) {
            err.printStackTrace();
        }




        player = new Hero("player", 5, 5);

        FightUnit skeleton = GenerateUnits.getFightUnit(player.getLevel());

        System.out.println(player.getFullInfoUnit());
        System.out.println(skeleton.getFullInfoUnit());

        new Battlefield().battle(player, skeleton, new BattleCallback() {
            @Override
            public void battleWin() {

            }

            @Override
            public void battleLos() {
                System.out.println("GAME OVER");
            }
        });

    }

}
