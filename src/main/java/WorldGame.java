import battle.BattleCallback;
import battle.Battlefield;
import units.fight.FightUnit;
import units.GameUnit;
import units.GenerateUnits;
import units.fight.Hero;
import units.neutral.Dealer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class WorldGame {

    static FightUnit player;
    static Dealer dealer;

    public static void main(String[] args) {

        try {
            loadScreen("src/main/resources/logo.txt");
            loadMenu();
        } catch (IOException err) {
            err.printStackTrace();
        }

    }

    //главное меню игры
    static void loadScreen(String pathFileName) throws IOException {
        //загрузка логотипа
        final Path logo = Paths.get(pathFileName);
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

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("""
                    Создание героя...
                    Введите имя героя:""");
            selected = console.readLine();
            // OPTIMIZE: 18.04.2021 Проверка пока только на не пустой ввод имени
            if (selected.isEmpty()) System.out.println("Введите корректное имя героя!");

        } while (selected.isEmpty());

        player = new Hero(selected, GameUnit.FORCE_BASIC, GameUnit.AGILITY_BASIC);
        dealer = new Dealer("Волшебник Рэндольф");
        System.out.println("Герой успешно создан\n" + player.getFullInfoUnit());
        loadGameMenu();

    }

    //игровое меню игры
    static void loadGameMenu() throws IOException {
        String selected;

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        while (player.getHealth() > 0) {

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
                case "2" -> loadShopMenu();
                case "3" -> System.out.println(player.getFullInfoUnit());
                case "4" -> {
                    System.out.println("Удачи, похоже этот мир слишком суров для вас...");
                    return;
                }
                case "" -> System.out.println("С возвращением путник, присаживайся возле костра и согрейся...");
                default -> System.out.println("Несуществующая команда, повторите ввод...");
            }

        }
        //конец игры
        loadScreen("src/main/resources/gameover.txt");
    }

    //игровое меню торговца
    static void loadShopMenu() throws IOException {
        String selected;
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        do {

            System.out.println("""
                    Здравствуй путник. Рад приветствовать тебя. 
                    Я торговец артефактами\s """ + dealer + """
                    , и вот мой товар:
                    1. Лечебное зелье +10 -  за 25 золота
                    2. Лечебное зелье +20 - за 50 золота
                    3. Заточить меч +5 к атаке - за 25 золота
                    4. Укрепить щит +5 к защите - за 25 золота
                    0. Вернуться к костру""");

            selected = console.readLine();
            switch (selected) {
                case "1" -> dealer.trade(player, Dealer.Goods.POTION10);
                case "2" -> dealer.trade(player, Dealer.Goods.POTION20);
                case "3" -> dealer.trade(player, Dealer.Goods.SHARPEN_SWORD);
                case "4" -> dealer.trade(player, Dealer.Goods.STRENGTHEN_SHIELD);
                default -> System.out.println("Несуществующая команда, повторите ввод...");
            }
            System.out.println("У вас осталось золота: " + player.getGold());
        } while (!selected.equals("0"));
    }

    //текущая битва
    static void currentBattle() {
        Battlefield battlefield = new Battlefield();

        FightUnit fightUnit = GenerateUnits.getFightUnit(player.getLevel());
        battlefield.battle(player, fightUnit, new BattleCallback() {
            @Override
            public void battleWin() {
                System.out.println("\u2795" + player
                        + "Враг повержен. Вы получили "
                        + fightUnit.getExperience()
                        + " единиц опыта и " + fightUnit.getGold()
                        + " монет золота.\n");
            }

            @Override
            public void battleLos() {
                System.out.println("\u2620" + player + "повержен. Вы пали в бою как герой!!!\n");
            }
        });

    }

}
