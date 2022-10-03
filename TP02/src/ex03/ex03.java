package ex03;

public class ex03 {

    public static void main(String[] args) {

    }

    private static double calculQuotient(double revenu) {

    }

    private static double calculImpots(double quotient) {
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
