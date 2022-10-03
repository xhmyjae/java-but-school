package ex05;

import utils.utils;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class ex05 {

    /**
     * Matches game where user input the number of matches (must be > 15) and battle against the computer.
     * The one who remove the last one will win. Only 1, 2 or 3 matches can be removed each time.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("\nEXERCICE 5 :\n");

        System.out.println("Entrez votre nom :");
        System.out.print("> ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        System.out.println("Entrez le nombre d'allumette (> 15) :");
        int matches;
        do {
            matches = utils.getInt();
        } while (matches < 15);
        int oldMatches = matches;

        int roll = ThreadLocalRandom.current().nextInt(0, 1 + 1);
        if (roll == 1) {
            System.out.println("L'ordinateur commence");
        } else {
            System.out.println(name + " commence");
        }

        while (matches >= 1) {
            String match = "|";

            int currentMatches = matches;
            if (roll%2 == 0) {
                matches = playerTurn(matches);
                System.out.println(String.format("%" + oldMatches + "s", "|".repeat(matches)) + " " + String.format("%" + 12 + "s", name) + " enleve : " + (currentMatches-matches) + " reste " + matches);
                if (matches == 0) {
                    System.out.println(name + " a gagne ! :D\nL'ordinateur a perdu...");
                }
            } else {
                matches = computerTurn(matches);
                System.out.println(String.format("%" + oldMatches + "s", "|".repeat(matches)) + " L'ordinateur enleve : " + (currentMatches-matches) + " reste " + matches);
                if (matches == 0) {
                    System.out.println("L'ordinateur a gagne ! D:\n" + name +" a perdu...");
                }
            }
            roll += 1;
        }
        utils.leave(args);
    }

    /**
     * Makes user input a number of matches to remove (1, 2 or 3).
     * @param matches the number of current matches
     * @return the new number of matches
     */
    private static int playerTurn(int matches) {
        int removeMatches;
        do {
            removeMatches = utils.getInt();
        } while (removeMatches > matches || removeMatches > 3 || removeMatches < 0);

        return matches-removeMatches;
    }

    /**
     * Makes computer choose a random number to remove matches (1, 2 or 3). If only 3 or fewer matches left,
     * the computer will remove them all to win the game.
     * @param matches the number of current matches
     * @return the new number of matches
     */
    private static int computerTurn(int matches) {
        int removeMatches =
        switch (matches) {
            case 6 -> 3;
            case 5 -> 2;
            case 3, 2, 1 -> matches;
            default -> ThreadLocalRandom.current().nextInt(1, 3 + 1);
        };
        return matches-removeMatches;
    }



}
