package ex04;

import utils.utils;

import java.math.BigInteger;

public class ex04 {

    /**
     * Calculates the chances to win at the game Euromillion. Takes two int inputed by the user.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("\nEXERCICE 4 :\n");

        int n, p;
        System.out.print("Entrez le premier nombre, ");
        do {
            n = utils.getInt();
        } while (n <= 0);
        System.out.print("Entrez le deuxieme nombre, ");
        do {
            p = utils.getInt();
        } while (p < 1 || n <= p);

        BigInteger result = utils.factorial(n).divide( utils.factorial(n-p).multiply(utils.factorial(p)) );

        System.out.println("Votre chance a l'euromillion est de " + result);

        utils.leave(args);
    }

}
