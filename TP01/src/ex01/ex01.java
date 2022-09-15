package ex01;

import utils.utils;
import java.lang.Math;

public class ex01 {

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
                utils.leave(args);
            default:
                System.out.println("La racine carree de " + inputDouble + " est " + Math.sqrt(inputDouble));
                utils.leave(args);
        }
    }

}
