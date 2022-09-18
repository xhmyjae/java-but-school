package ex06;

import menu.menu;
import utils.utils;

public class ex06 {

    /**
     * Takes a user input to make a 2D matrix. It takes user inputs for each value.
     * @param args
     */
    public static void main(String[] args) {
        System.out.print("Entrez la taille du tableau (0 pour revenir au menu) : ");
        int arraySize = utils.getInt();

        if (arraySize == 0) {
            System.out.println("Fin du programme, retour au menu.");
            menu.main(args);
        }
        if (arraySize < 0) {
            System.out.println("Entrez une valeur positive.");
            main(args);
        }

        double[][] array = new double[arraySize][arraySize];

        for (int r = 0; r < array.length; r++) {
            for (int c = 0; c < array[r].length; c++) {
                System.out.print("Entrez la valeur [" + (r+1) + "," + (c+1) + "] : ");
                array[r][c] = utils.getDouble();
            }
        }

        utils.printMatrix(array);
        utils.leave(args);
    }

}
