package lektion2;

import java.util.Scanner;

public class Addition {
    public static void main(String[] args) {
        double tal1, tal2;

        Scanner scanObj = new Scanner(System.in);

        System.out.println("Ange tal 1");
        tal1 = scanObj.nextDouble();

        System.out.println("Ange tal 2");
        tal2 = scanObj.nextDouble();

        System.out.println("Summan är: " + (tal1 + tal2));
    }
}
