import battle.BattleCallback;
import battle.Battlefield;
import units.FightUnit;
import units.GameUnit;
import units.GenerateUnits;
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
            loadStartScreen();
            loadMenu();
        } catch (IOException err) {
            err.printStackTrace();
        }

    }

    //главное меню игры
    static void loadStartScreen() throws IOException {
        //загрузка логотипа
        final Path logo = Paths.get("src/main/resources/logo.txt");
        final Path logoPath = logo.toAbsolutePath();

        BufferedReader loadLogo = Files.newBufferedReader(logoPath, StandardCharsets.UTF_8);
        String line;
        while ((line = loadLogo.readLine()) != null) {
            System.out.println("\u001B[31m" + line);
        }
    }

    static void loadMenu() throws IOException {
        //enter для продолжения
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        console.readLine();

        //пункты меню
        String selected;
        do {
            System.out.println("""
                    Добро пожаловать в ад!!!
                    1. Новая игра
                    2. Выход
                    Введите команду""");
            selected = console.readLine();
            switch (selected) {
                case "1" -> createPlayer();
                case "2" -> System.out.println("Работа программы завершена...");
                default -> System.out.println("Несуществующая команда, повторите ввод...");
            }
        } while (!selected.equals("2"));
    }

    //создание игрока
    static void createPlayer() throws IOException {
        String selected;
        boolean isCreateHero = true;
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("""
                    Создание героя...
                    Введите имя героя:""");
            selected = console.readLine();
            // OPTIMIZE: 18.04.2021 Проверка пока только на не пустой ввод имени
            if (selected.equals(""))
                System.out.println("Введите корректное имя героя!");
            else isCreateHero = false;
        } while (isCreateHero);

        player = new Hero(selected, GameUnit.FORCE_BASIC, GameUnit.AGILITY_BASIC);
        System.out.println("Герой успешно создан\n" + player.getFullInfoUnit());
        loadGameMenu();
    }

    //игровое меню игры
    static void loadGameMenu() throws IOException {
        String selected;
        boolean isLiveHero = true;
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        while (isLiveHero) {

            System.out.println("""
                    Вы у костра. Куда направитесь теперь?
                    1. В подземелье - крушить монстров
                    2. Торговец артефактами
                    3. Ваша статистика
                    4. В главное меню
                    Введите команду""");
            selected = console.readLine();
            switch (selected) {
                case "1" -> currentBattle();
                case "2" -> System.out.println("Торговца пока нет...");
                case "3" -> System.out.println(player.getFullInfoUnit());
                case "4" -> {
                    return;
                }
                case "" -> System.out.println("С возвращением путник, присаживайся возле костра и согрейся...");
                default -> System.out.println("Несуществующая команда, повторите ввод...");
            }
            isLiveHero = player.getHealth() > 0;
        }
    }

    //текущая битва
    static void currentBattle() {
        Battlefield battlefield = new Battlefield();

        // TODO: 18.04.2021 текущая битва
        FightUnit fightUnit = GenerateUnits.getFightUnit(player.getLevel());
        battlefield.battle(player, fightUnit, new BattleCallback() {
            @Override
            public void battleWin() {
                System.out.println("\u2795" + player
                        + "Враг повержен. Вы получили "
                        + fightUnit.getExperience()
                        + " единиц опыта и " + fightUnit.getGold()
                        + " монет золота.");
            }

            @Override
            public void battleLos() {
                System.out.println("\u2620" + player + "повержен. Вы пали в бою как герой!!!");
            }
        });

    }


}
