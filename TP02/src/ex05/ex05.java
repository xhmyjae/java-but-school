package ex05;

import menu.menu;
import utils.utils;

import java.util.Random;
import java.util.Scanner;

public class ex05 {

    public static void main(String[] args) {
        System.out.println("\nEXERCICE 5 :\n");

        System.out.println("Entrez votre nom :");
        System.out.print("> ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        System.out.println("Entrez le nombre d'allumette (> 15) :");
        int matches;
        do {
            matches = utils.getInt();
        } while (matches < 15);
        int oldMatches = matches;

        long roll = Math.round(Math.random());
        System.out.println(roll);
        if (roll == 1) {
            System.out.println("L'ordinateur commence");
        } else {
            System.out.println(name + " commence");
        }

        while (matches >= 1) {
            String match = "|";
            String allMatches = match.repeat(matches);


        }

    }



}
