package ex03;

import utils.utils;

public class ex03 {

    /**
     * Converts an inputed number to its binary or decimal form. It cannot convert negative number.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("EXERCICE 3 : \n");
        System.out.println("Convertir en :");
        System.out.println("Tapez 1 pour du decimal vers binaire.");
        System.out.println("Tapez 2 pour du binaire vers decimal.\n");
        System.out.print("Choisir le mode de conversion, ");
        int inputInt = utils.getInt();

        switch (inputInt) {
            case 1:
                System.out.println();
                int inputInt2 = utils.getPositiveInt();
                System.out.println("Le binaire de " + inputInt2 + " est " + decimalToBinary(inputInt2));
                utils.leave(args);
            case 2:
                System.out.println();
                int inputBinary = utils.getBinary();
                System.out.println("Le decimal de " + inputBinary + " est " + binaryToDecimal(inputBinary));
                utils.leave(args);
            default:
                System.out.println("Ce n'est pas une valeur numerique.");
                main(args);
        }
    }

    /**
     * Convert an int to its binary format.
     * @param inputInt the int that will be converted
     * @return
     */
    public static int decimalToBinary(int inputInt) {
        return Integer.parseInt(Integer.toBinaryString(inputInt));
    }

    /**
     * Converts a binary int to its decimal format.
     * @param inputBinary the int that will be converted
     * @return
     */
    public static double binaryToDecimal(int inputBinary) {
        return Integer.parseInt(String.valueOf(inputBinary),2);
    }

}
