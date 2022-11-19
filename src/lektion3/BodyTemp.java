package lektion3;

import java.util.Scanner;

public class BodyTemp {
    public static void main(String[] args) {
        // Define variables
        double bodytemp;

        // Create scanner object for bodytemp input
        Scanner keyboard = new Scanner(System.in);

        // Ask for and insert bodytemp to variable
        System.out.println("Mata in din temperatur:");
        bodytemp = keyboard.nextDouble();

        // Print whether person have feber or not depending on if bodytemp exceeds 37.5 celcius
        if (bodytemp > 37.5) {
            System.out.println("Du har feber\uD83E\uDD12");
        }
        if (bodytemp <= 37.5) {
            System.out.println("Du har inte feber\uD83C\uDF89");
        }
    }
}
