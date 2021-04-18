import units.FightUnit;
import units.GameUnit;
import units.Hero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WorldGame {

    static FightUnit player;

    public static void main(String[] args) {


        // TODO: 17.04.2021 разработка главного меню игры
        try {
            loadMenu();
        } catch (IOException err) {
            err.printStackTrace();
        }

    }

    //главное меню игры
    static void loadMenu() throws IOException {
        //загрузка логотипа
        final Path logo = Paths.get("src/main/resources/logo.txt");
        final Path logoPath = logo.toAbsolutePath();

        BufferedReader loadLogo = Files.newBufferedReader(logoPath, StandardCharsets.UTF_8);
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = loadLogo.readLine()) != null) {
            System.out.println("\u001B[31m" + line);
        }

        //enter для продолжения
        console.readLine();

        //пункты меню
        String selected;
        do {
            System.out.println("Добро пожаловать в ад!!!\n1. Новая игра\n2. Выход\nВведите команду");
            selected = console.readLine();
            switch (selected) {
                case "1" -> {
                    createPlayer();
                }

                case "2" -> {
                    System.out.println("Работа программы завершена...");
                }

                default -> {
                    System.out.println("Несуществующая команда, повторите ввод...");
                }
            }
        } while (!selected.equals("2"));
    }

    //создание игрока
    static void createPlayer() throws IOException {
        String selected;
        boolean isCreate = true;
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("Создание героя...");
            System.out.println("Введите имя героя:");
            selected = console.readLine();
            // OPTIMIZE: 18.04.2021 Проверка пока только на не пустой ввод имени
            if (selected.equals("")) {
                System.out.println("Введите корректное имя героя!");
            } else isCreate = false;
        } while (isCreate);

        player = new Hero(selected, GameUnit.FORCE_BASIC, GameUnit.AGILITY_BASIC);
        System.out.println("Герой успешно создан\n" + player.getFullInfoUnit());

    }

    //игровое меню игры
    static void loadGameMenu() {

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
