package ex01;

import utils.utils;
import java.lang.Math;

public class ex01 {

    /**
     * Calulate square root of inputed number (through getDouble function). If the number is equal to 0 it ends the
     * program, if the number is negative or too small user will have to input a new one.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Entrez une valeur positive (0 pour terminer) :");
        double inputDouble = utils.getDouble();

        if (inputDouble < 0) {
            System.out.println("La valeur ne peut etre negative.");
            main(args);
        }
        if (0 < inputDouble && inputDouble < 1) {
            System.out.println("La valeur est trop petite.");
            main(args);
        }

        switch ((int)inputDouble) {
            case 0:
                System.out.println("Fin du programme.");
                utils.leave(args);
            default:
                System.out.println("La racine carree de " + inputDouble + " est " + Math.sqrt(inputDouble));
                utils.leave(args);
        }
    }

}
