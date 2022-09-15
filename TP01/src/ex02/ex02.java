package ex02;

import utils.utils;

public class ex02 {

    /**
     * Draws a tree with = and *. The tree height is given by the user, if negative, it has to be chosen again.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Saisir la taille de l'arbre :");
        int inputInt = utils.getInt();

        if (inputInt < 0) {
            System.out.println("Le nombre doit etre superieur a 0.");
            main(args);
        }

        for (int i=0; i<inputInt; i++) {
            System.out.println("=".repeat(inputInt+2 - i) + "*".repeat(i) + "*" + "*".repeat(i) + "=".repeat(inputInt+2 - i));
        }

        System.out.println("=".repeat(inputInt+2) + "*" + "=".repeat(inputInt+2));
        System.out.println("=".repeat(inputInt+1) + "***" + "=".repeat(inputInt+1));

        utils.leave(args);
    }

}
