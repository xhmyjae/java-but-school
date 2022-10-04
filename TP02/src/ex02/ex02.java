package ex02;

import utils.utils;
import ex01.ex01;
import java.util.Arrays;

public class ex02 {

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
