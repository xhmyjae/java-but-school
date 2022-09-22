package ex05;

import utils.utils;
import menu.menu;

public class ex05 {

    /**
     *  Takes an input greater than 0 and make an array of this size. User will also input all the array values.
     *  It will print the sum of all values of the array.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("EXERCICE 5 : \n");
        System.out.print("Entrez la taille du tableau (0 pour revenir au menu), ");
        int arraySize = utils.getInt();

        if (arraySize == 0) {
            System.out.println("Fin du programme, retour au menu.");
            menu.main(args);
        }
        if (arraySize < 0) {
            System.out.println("Entrez une valeur positive.");
            main(args);
        }

        double[] array = new double[arraySize];
        double sumOfArray = 0;

        for (int i = 0; i < array.length; i++) {
            System.out.print("Entrez la valeur " + (i+1) + " : ");
             array[i] = utils.getDouble();
             sumOfArray += array[i];
        }

        System.out.println("La somme du tableau est " + sumOfArray);
        utils.leave(args);
    }

}
