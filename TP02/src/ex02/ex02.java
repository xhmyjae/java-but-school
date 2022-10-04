package ex02;

import utils.utils;
import ex01.ex01;
import java.util.Arrays;

public class ex02 {

    /**
     * Takes a number and load method An with it as a parameter
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("\nEXERCICE 2 :\n");

        int n;
        System.out.print("Entrez le premier nombre, ");
        do {
            n = utils.getInt();
        } while (n < 0);

        System.out.println("Solution a An : " + Arrays.toString(An(n)));

        utils.leave(args);
    }

    /**
     * Calculates and returns the result of a formula in a loop till iteration reaches n.
     * @param n double (the maximum of iteration for the loop)
     * @return an array of the two doubles changed by the loop iterations
     */
    public static double[] An(int n) {
        double x = 4;
        double y = 2*Math.sqrt(2);

        ex01.Archimede cn = new ex01.Archimede();

        int i = 1;
        while (i <= n) {
            x = cn.Cn(x, y);
            y = cn.In(x, y);
            i++;
        }

        return new double[] {x, y};
    }

}
