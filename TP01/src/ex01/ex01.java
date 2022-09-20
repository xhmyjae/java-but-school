package ex01;

import utils.utils;
import java.lang.Math;

public class ex01 {

    /**
     * Calculate square root of inputted number (through getDouble function). If the number is equal to 0 it ends the
     * program, if the number is negative or too small user will have to input a new one.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("EXERCICE 1 : \n");
        double inputDouble = utils.getDouble();

        if (inputDouble < 0) {
            System.out.println("La valeur ne peut etre negative.");
            main(args);
        } else if (inputDouble == 0) {
            System.out.println("Fin du programme.");
            utils.leave(args);
        } else if (0 < inputDouble && inputDouble < 1) {
            System.out.println("La valeur est trop petite.");
            main(args);
        } else {
            System.out.printf("La racine carree de %.2f est %.2f \n", inputDouble, Math.sqrt(inputDouble));
            utils.leave(args);
        }
    }

}
