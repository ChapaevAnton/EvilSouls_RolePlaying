import battle.BattleCallback;
import battle.Battlefield;
import units.FightUnit;
import units.GenerateUnits;
import units.Hero;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WorldGame {

    public static FightUnit player;

    public static void main(String[] args) throws IOException {


        // FIXME: 15.04.2021 доработать загрузку лого
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/logo.txt"));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println("\u001B[31m" + line);
        }

        player = new Hero("player", 5, 5);

        FightUnit skeleton = GenerateUnits.getFightUnit(player.getLevel());

        System.out.println(player.getFullInfoUnit());
        System.out.println(skeleton.getFullInfoUnit());

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
