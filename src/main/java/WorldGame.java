import units.FightUnit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WorldGame {

    public static FightUnit player;

    public static void main(String[] args) throws IOException {


        //загрузка логотипа
        final Path logo = Paths.get("src/main/resources/logo.txt");
        final Path logoPath = logo.toAbsolutePath();

        try (BufferedReader loadLogo = Files.newBufferedReader(logoPath, StandardCharsets.UTF_8)) {
            String line;
            while ((line = loadLogo.readLine()) != null) {
                System.out.println("\u001B[31m" + line);
            }
        } catch (IOException err) {
            err.printStackTrace();
        }

        // TODO: 17.04.2021 разработка главного меню игры

        //enter для продолжения
        String selected;
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        selected = console.readLine();

        System.out.println("Добро пожаловать в ад!!!\n1. Создать героя\n2. Выход\nВведите команду");

        selected = console.readLine();
        //главное меню программы
        switch (selected) {
            case "1" -> {
                System.out.println("Создание героя...");
            }

            case "2" -> {
                System.out.println("Работа программы завершена...");
            }

            default -> {
                System.out.println("Несуществующая команда, повторите ввод...");
            }
        }


//        player = new Hero("player", 5, 5);
//
//        FightUnit skeleton = GenerateUnits.getFightUnit(player.getLevel());
//
//        System.out.println(player.getFullInfoUnit());
//        System.out.println(skeleton.getFullInfoUnit());
//
//        new Battlefield().battle(player, skeleton, new BattleCallback() {
//            @Override
//            public void battleWin() {
//
//            }
//
//            @Override
//            public void battleLos() {
//                System.out.println("GAME OVER");
//            }
//        });

    }

}
