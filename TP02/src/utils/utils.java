package utils;

import java.util.Scanner;

public class utils {

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

}
