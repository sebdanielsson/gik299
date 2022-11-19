package lektion2;

import java.util.Scanner;

public class InputOutput {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        String name;

        System.out.println("Vad heter du?");
        name = keyboard.nextLine();

        System.out.println("Du heter " + name + ".");
    }
}
