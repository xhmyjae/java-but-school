package menu;

import ex05.ex05;
import utils.utils;

public class menu {

    /**
     * Displays the possible choices to the user and takes an inputted number to display the chosen exercice.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("MENU :\n");
        for (int n = 1; n < 6; n++) {
            System.out.println("Tapez " + n + " pour l'exercice " + n + ".");
        }
        System.out.println("Tapez 0 pour quitter.\n");

        int inputInt = utils.getInt();

        switch (inputInt) {
            case 5:
                ex05.main(args);
            case 0:
                System.out.println("Au revoir !");
                System.exit(0);
            default:
                main(args);
        }
    }

}