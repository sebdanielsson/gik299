package lektion3;

import java.util.Scanner;

public class AreaPris {
    public static void main(String[] args) {
        int area;
        int repeat = 1;
        Scanner keyboard = new Scanner(System.in);

        while(repeat == 1) {
            System.out.println("Välj område 1, 2 eller 3 för pris/m2:");
            area = keyboard.nextInt();

            switch(area) {
                case 1:
                    System.out.println("Priset för område 1 är 85 kr/m2.");
                    break;
                case 2:
                    System.out.println("Priset för område 2 är 55 kr/m2.");
                    break;
                case 3:
                    System.out.println("Priset för område 3 är 145 kr/m2.");
                    break;
                default:
                    System.out.println("Ogiltigt svar på frågan.");
            }
            System.out.println("\nVill du fortsätta? 1=Ja, 0=Nej");
            repeat = keyboard.nextInt();
        }
    }
}
