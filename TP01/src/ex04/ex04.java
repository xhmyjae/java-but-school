package ex04;

import menu.menu;
import utils.utils;

public class ex04 {

    /**
     * Make the sum of all results from the sequence. The sequence repetition is based on a user input int greater than 0.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("EXERCICE 4 : \n");
        System.out.print("Entrez le nombre de terme de la suite a calculer n avec n > 0 (0 pour revenir au menu), ");
        int n = utils.getPositiveInt();

        if (n == 0) {
            System.out.println("Fin du programme, retour au menu.");
            menu.main(args);
        }

        double result = 0;
        for (int i = 1; i <= n; i++) {
            result = result + 1.0 / i;
        }

        System.out.printf("Le resultat est %.4f", result);
        System.out.println();
        utils.leave(args);
    }
}
