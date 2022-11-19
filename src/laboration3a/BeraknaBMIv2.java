package laboration3a;

import java.util.Scanner;

public class BeraknaBMIv2 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        double vikt, langd, bmi;
        int repeat = 1;

        while(repeat == 1) {
            System.out.println("Fyll i vikt (kg):");
            vikt = keyboard.nextDouble();

            System.out.println("Fyll i längd (cm):");
            langd = keyboard.nextDouble();

            bmi = (vikt / Math.pow((langd/100), 2));

            if (bmi < 18.5) {
                System.out.printf("Du är underviktig (BMI: %.2f)", bmi);
            } else if (bmi >= 18.5 && bmi <= 24.9) {
                System.out.printf("Du har idealvikt (BMI: %.2f)", bmi);
            } else if (bmi >= 25 && bmi <= 29.9) {
                System.out.printf("Du är överviktig (BMI: %.2f)", bmi);
            } else if (bmi > 30) {
                System.out.printf("Ditt BMI är väl över det rekommenderade värdet (BMI: %.2f)", bmi);
            }

            System.out.println("\nVill du fortsätta? 1=Ja, 0=Nej");
            repeat = keyboard.nextInt();
        }

        // Stänga scannerobjektet
        keyboard.close();
    }
}
