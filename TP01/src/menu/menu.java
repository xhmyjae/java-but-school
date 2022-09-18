package menu;

import ex01.ex01;
import ex02.ex02;
import ex03.ex03;
import ex05.ex05;
import ex06.ex06;
import utils.utils;

public class menu {

    /**
     * Displays the possible choices to the user and takes an inputted number to display the chosen exercice.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("MENU :");
        System.out.println("Tapez 1 pour l'exercice 1.");
        System.out.println("Tapez 2 pour l'exercice 2.");
        System.out.println("Tapez 3 pour l'exercice 3.");
        System.out.println("Tapez 5 pour l'exercice 5.");
        System.out.println("Tapez 6 pour l'exercice 6.");
        System.out.println("Tapez 0 pour quitter.");

        int inputInt = utils.getInt();

        switch (inputInt) {
            case 1:
                ex01.main(args);
            case 2:
                ex02.main(args);
            case 3:
                ex03.main(args);
            case 5:
                ex05.main(args);
            case 6:
                ex06.main(args);
            case 0:
                System.out.println("Au revoir !");
                System.exit(0);
            default:
                main(args);
        }
    }

}
