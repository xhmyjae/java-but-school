package utils;

import menu.menu;

import java.util.Scanner;

public class utils {

    /**
     * Gets and checks if user input is a double, if not the code replays itself.
     * @return input parsed as double
     */
    public static double getDouble() {
        System.out.println("Entrez une valeur positive (0 pour terminer) :");
        System.out.print("> ");
        Scanner sc = new Scanner(System.in);

        while (!sc.hasNextDouble()) {
            System.out.println("Ce n'est pas une valeur numerique.");
            System.out.print("> ");
            sc.nextLine();
        }

        return sc.nextDouble();
    }

    /**
     * Gets and checks if user input is an int, if not the code replays itself.
     * @return input parsed as int
     */
    public static int getInt() {
        System.out.println("Rentrez une valeur numerique :");
        System.out.print("> ");
        Scanner sc = new Scanner(System.in);

        while (!sc.hasNextInt()) {
            System.out.println("Ce n'est pas une valeur numerique.");
            System.out.print("> ");
            sc.nextLine();
        }

        return sc.nextInt();
    }

    /**
     * Gets and checks if user input is a positive int, if not the code replays itself.
     * @return input parsed as int
     */
    public static int getPositiveInt() {
        System.out.println("Rentrez une valeur numerique positive :");
        System.out.print("> ");
        Scanner sc = new Scanner(System.in);

        while (!sc.hasNextInt()) {
            System.out.println("Ce n'est pas une valeur numerique.");
            System.out.print("> ");
            sc.nextLine();
        }

        int num = sc.nextInt();

        if (num < 0) {
            return getPositiveInt();
        }

        return num;
    }

    /**
     * Gets a user input and check if it's a binary number. If not, user has to input a new one.
     * @return int, the binary number.
     */
    public static int getBinary() {
        System.out.println("Rentrez une valeur binaire :");
        System.out.print("> ");
        Scanner sc = new Scanner(System.in);

        while (!sc.hasNextInt()) {
            System.out.println("Ce n'est pas une valeur numerique.");
            System.out.print("> ");
            sc.nextLine();
        }

        int num = sc.nextInt();

        if (num < 0) {
            return getBinary();
        }

        while (!isBinaryNumber(num)) {
            System.out.println("Ce n'est pas une valeur binaire.");
            return getBinary();
        }

        return num;
    }

    /**
     * Checks if a number is binary.
     * @param num
     * @return bool true if it's a binary, false if it isn't
     */
    public static boolean isBinaryNumber(int num)
    {
        int copyOfNum = num;

        while (copyOfNum != 0) {
            if (copyOfNum % 10 > 1) {
                return false;
            }
            if (copyOfNum == 0 || copyOfNum == 1) {
                break;
            }
            copyOfNum = copyOfNum / 10;
        }
        return true;
    }

    /**
     * Gets the average of the list placed in parameters.
     * @param arrayOfDoubles an array of doubles
     * @return the average in it's double form.
     */
    public static double getAverage(double arrayOfDoubles[]) {
        int arraySize = arrayOfDoubles.length;
        int lineSum = 0;

        for (int i = 0; i < arraySize; i++) {
            lineSum += arrayOfDoubles[i];
        }

        return (double)lineSum/arraySize;
    }

    /**
     * Prints the formated matrix.
     * @param matrix a 2D matrix
     */
    public static void printMatrix(double matrix[][])
    {
        double[] array;
        double[] arrayColumn;

        for (int r = 0; r < matrix.length; r++) {
            array = new double[matrix.length];
            for (int c = 0; c < matrix[r].length; c++)
            {
                array[c] = matrix[r][c];
                System.out.print( matrix[r][c]  + "        ");
            }
            System.out.printf("(%.2f)", getAverage(array));
            System.out.println();
        }

        for (int c = 0; c < matrix.length; c++) {
            arrayColumn = new double[matrix.length];
            for (int r = 0; r < matrix.length; r++) {
                arrayColumn[r] = matrix [r][c];
            }
            System.out.printf("(%.2f)   ", getAverage(arrayColumn));
        }

        System.out.println();
    }

    /**
     * Makes the user input a number to go back to the menu or end the program.
     * @param args
     */
    public static void leave(String[] args) {
        System.out.println("\nAppuyez sur 0 pour quitter ou 1 pour retourner au menu.");
        int num = getInt();

        switch (num) {
            case 1:
                menu.main(args);
            case 0:
                System.out.println("Au revoir !");
                System.exit(0);
            default:
                leave(args);
        }
    }

}
