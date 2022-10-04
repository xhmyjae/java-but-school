package ex01;

import utils.utils;

public class ex01 {

    /**
     * Takes two input numbers and put them as parameters for archimede methods.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("\nEXERCICE 1 :\n");

        int x, y;
        System.out.print("Entrez le premier nombre, ");
        do {
            x = utils.getInt();
        } while (x < 0);
        System.out.print("Entrez le deuxieme nombre, ");
        do {
            y = utils.getInt();
        } while (y < 0);

        Archimede cn = new Archimede();
        System.out.println("Solution a archimede Cn : " + cn.Cn(x, y));
        System.out.println("Solution a archimede In : " + cn.In(x, y));

        utils.leave(args);
    }

    public static class Archimede {

        /**
         * Calculates a formula using two int placed as parameters.
         * @param x double
         * @param y double
         * @return the formula using x and y
         */
        public double Cn(double x, double y) {
            return 2 * x * y / (x + y);
        }

        /**
         * Calculates the square root of the multiplication of two numbers placed as parameters.
         * @param x double
         * @param y double
         * @return the sqrt of x*y
         */
        public double In(double x, double y) {
            return Math.sqrt(x*y);
        }

    }

}
