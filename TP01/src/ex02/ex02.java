package ex02;

import utils.utils;

public class ex02 {

    /**
     * Draws a tree with = and *. The tree height is given by the user, if negative, it has to be chosen again.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("EXERCICE 2 : \n");
        System.out.print("Saisir la taille de l'arbre, ");
        int inputInt = utils.getPositiveInt();

        for (int i=0; i<inputInt; i++) {
            System.out.println("=".repeat(inputInt+2 - i) + utils.ANSI_GREEN + "*".repeat(i) + "*" + "*".repeat(i) + utils.ANSI_RESET + "=".repeat(inputInt+2 - i));
        }

        System.out.println("=".repeat(inputInt+2) + utils.ANSI_YELLOW + "*" + utils.ANSI_RESET + "=".repeat(inputInt+2));
        System.out.println("=".repeat(inputInt+1) + utils.ANSI_YELLOW + "***" + utils.ANSI_RESET + "=".repeat(inputInt+1));

        utils.leave(args);
    }

}
