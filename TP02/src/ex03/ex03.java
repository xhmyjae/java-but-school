package ex03;

import utils.utils;

import java.io.Console;

public class ex03 {


    public static void main(String[] args) {
        System.out.println("\nEXERCICE 5 :\n");
        System.out.print("Entrez votre revenu net impossable, ");
        double revenu;
        do {
            revenu = utils.getDouble();
        } while (revenu < 0);

        double quotient = CalculQuotient(revenu);
        System.out.printf("Vous devrez : %.2f euros.\n", CalculImpots(quotient));

        utils.leave(args);
    }

    private static double CalculQuotient(double revenu) {
        System.out.println("Quelle est votre situation :\n1- Celibataire\n2- Couple marié/pacsé");
        int status;
        do {
            status = utils.getInt();
        } while (status < 1 && status > 2);

        double quotient = 0;

        System.out.print("Combien d'enfants sont à votre charge, ");
        int children;
        do {
            children = utils.getInt();
        } while (children < 0);

        switch (status) {
            case 1:
                if (children != 0) {
                    children++;
                }
                quotient = revenu / (1 + (children/2));
                break;
            case 2 :
                quotient = revenu / (2 + (children/2));
                break;
        }

        return quotient;
    }

    private static double CalculImpots(double quotient) {
        double impot = 0;
        while (quotient > 10225) {
            if (10226 <= quotient && quotient <= 26070) {
                impot += (quotient - 10225) * 0.11;
                quotient = 10225;
            } else if (26071 <= quotient && quotient <= 74545) {
                impot += (quotient - 26070) * 0.30;
                quotient = 26070;
            } else if (74546 <= quotient && quotient <= 160336) {
                impot += (quotient - 74545) * 0.41;
                quotient = 74545;
            } else {
                impot += (quotient - 160336) * 0.45;
                quotient = 160336;
            }
        }
        return impot;
    }

}
