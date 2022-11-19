package lektion3;

import java.util.Random;

public class ForWhileDoWhileLoopar {
    public static void main(String[] args) {
        for (int counter = 1; counter < 11; counter++) {
            System.out.println("Varv " + counter);
        }

        System.out.println("");

        int counterDoWhile = 0;
        do {
            counterDoWhile++;
            System.out.println("Varv i dowhile: " + counterDoWhile);
        } while (counterDoWhile < 11);

        System.out.println("");

        Random slumpObj = new Random();
        int slumpatTal;
        for (int antalSlump = 1; antalSlump <= 50; antalSlump++) {
            slumpatTal = slumpObj.nextInt(100)+1;
            System.out.println("Slumpat tal " + antalSlump + ": " + slumpatTal);
        }
    }
}
