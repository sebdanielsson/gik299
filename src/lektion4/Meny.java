package lektion4;

import java.util.Scanner;

public class Meny {
    public static void main(String[] args) {
        boolean run = true;
        String kommando;
        Scanner input = new Scanner(System.in);

        while(run) {
            System.out.println("\nMenu:\n1 = Mitt namn\n2 = Min superkraft\n3 = Avsluta");
            kommando = input.nextLine();

            switch (kommando) {
                case"1":
                    System.out.println("Mitt namn är Sebastian");
                    break;
                case"2":
                    System.out.println("Jag kan koda!");
                    break;
                case"3":
                    run = false;
                    System.out.println("Avslutar programmet...");
                    break;
            }
        }
        System.out.println("Hej då!");
    }
}
