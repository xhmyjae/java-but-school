package utils;

import menu.menu;

import java.util.Scanner;

public class utils {

    /**
     * Gets and checks if user input is a double, if not the code replays itself.
     * @return input parsed as double
     */
    public static double getDouble() {
        Scanner sc = new Scanner(System.in);

        while (!sc.hasNextDouble()) {
            System.out.println("Ce n'est pas une valeur numerique.");
            sc.nextLine();
        }

        return sc.nextDouble();
    }

    /**
     * Gets and checks if user input is an int, if not the code replays itself.
     * @return input parsed as int
     */
    public static int getInt() {
        Scanner sc = new Scanner(System.in);

        while (!sc.hasNextInt()) {
            System.out.println("Ce n'est pas une valeur numerique.");
            sc.nextLine();
        }

        int num = sc.nextInt();
        return num;
    }

    public static int getBinary() {
        Scanner sc = new Scanner(System.in);

        while (!sc.hasNextInt()) {
            System.out.println("Ce n'est pas une valeur numerique.");
            sc.nextLine();
        }

        int num = sc.nextInt();

        while (!isBinaryNumber(num)) {
            System.out.println(num);
            System.out.println("Ce n'est pas une valeur binaire.");
            sc.nextLine();
        }

        return num;
    }

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
     * Makes the user input a number to go back to the menu or end the program.
     * @param args
     */
    public static void leave(String[] args) {
        System.out.println("Appuyez sur 0 pour quitter ou 1 pour retourner au menu.");
        Scanner sc = new Scanner(System.in);

        while (!sc.hasNextInt()) {
            System.out.println("Appuyez sur 0 pour quitter ou 1 pour retourner au menu.");
            sc.nextLine();
        }

        switch (sc.nextInt()) {
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
