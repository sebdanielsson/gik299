package laboration4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Temperaturer {
    public static void main(String[] args) {
        boolean run = true;
        String kommando;
        Scanner input = new Scanner(System.in);
        Random temp = new Random();

        int min=8, max=24;
        int[] temperaturer= new int [31];
        for(int i=0; i<temperaturer.length; i++ ){
            temperaturer[i]=temp.nextInt(min, max);
        }

        int[] lowToHigh=new int [31];
        System.arraycopy(temperaturer, 0, lowToHigh,0, 31);
        Arrays.sort(lowToHigh);

        while(run) {
            System.out.println("\nMenu:\n1 = Alla temperaturer\n2 = Lägsta-Högsta\n3 = Högsta temperatur\n4 = Lägsta temperatur\n5 = Mediantemperatur\n6 = Medeltemperatur\n7 = Slumpa nya temperaturer\n8 = Avsluta");
            kommando = input.nextLine();

            switch (kommando) {
                case "1" -> {
                    System.out.println("Temperaturer i maj:");
                    for (int i = 0; i < temperaturer.length; i++) {
                        System.out.println("Dag " + (i + 1) + ": " + temperaturer[i] + "℃");
                    }
                }
                case "2" -> {
                    System.out.println("Temperaturer lägsta-högsta:");
                    for (int i = 0; i < temperaturer.length; i++) {
                        System.out.println(lowToHigh[i] + "℃");
                    }
                }
                case "3" -> {
                    System.out.println("Högsta temperatur:");
                    System.out.println(lowToHigh[30] + "℃");
                }
                case "4" -> {
                    System.out.println("Lägsta temperatur:");
                    System.out.println(lowToHigh[0] + "℃");
                }
                case "5" -> {
                    System.out.println("Mediantemperatur:");
                    System.out.println(lowToHigh[15] + "℃");
                }
                case "6" -> {
                    System.out.println("Medeltemperatur:");
                    int average = IntStream.of(lowToHigh).sum() / 31;
                    System.out.println(average + "℃");
                }
                case "7" -> {
                    for (int i = 0; i < temperaturer.length; i++) {
                        temperaturer[i] = temp.nextInt(min, max);
                    }
                    System.arraycopy(temperaturer, 0, lowToHigh, 0, 31);
                    Arrays.sort(lowToHigh);
                    System.out.println("Nya temperaturer genererade.");
                }
                case "8" -> {
                    run = false;
                    System.out.println("Avslutar programmet...");
                }
            }
        }
        input.close();
    }
}
