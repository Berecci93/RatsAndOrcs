package com.berecci;

import java.util.List;
import java.util.Scanner;

public class Input {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();

        while (true) {
            System.out.println(game.getInfo());

            List<String> actions = game.getMoves();
            for (int i = 0; i < actions.size(); i++) {
                System.out.println("\t" + i + ": " + actions.get(i));
            }
            String inputAsString = scanner.nextLine();
            int input = Integer.parseInt(inputAsString);
            game.action(input);
        }
    }

    //przeniesc to do Game, warunkowo zmieniac info, gdy do input wpadnie 0 to podniemic info z forest na Field
//    static void action(int chosen) {
//        System.out.println("Chosen action: " + action.get(chosen));
//    }
//}

}