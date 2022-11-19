package laboration2;

import java.util.Scanner;

// Det här programmet låter dig mata in vikt och längd och beräknar sedan ut ett BMI
public class BeraknaBMI {
    public static void main(String[] args) {
        // Skapa ett objekt som heter keyboard som sparar input
        Scanner keyboard = new Scanner(System.in);

        // Skapa variabler med datatypen double för vikt, längd, längd i kvadrat samt BMI
        double vikt, langd, langd2, bmi;

        // Fråga om vikt
        System.out.println("Fyll i vikt i (kg):");
        vikt = keyboard.nextDouble();

        // Fråga om längd använder objektet "scanner" med namnet keyboard och metod .nextDouble.
        System.out.println("Fyll i längd (cm):");
        langd = keyboard.nextDouble();

        // Räkna ut längd i kvadrat med power of metod i klassen Math
        langd2 = Math.pow((langd/100), 2);

        // Räkna ut BMI
        bmi = vikt/langd2;

        // Skriv ut BMI med metoden printf för att minska antalet decimaler
        System.out.printf("BMI: %.2f", bmi);

        // Stänga scannerobjektet
        keyboard.close();
    }
}
