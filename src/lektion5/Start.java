package lektion5;

import javax.swing.*;

public class Start {
    public static void main(String[] args) {
        /*
        // Skapa tre person-objekt manuellt med klassen Person, p3 = default-person
        Person p1 = new Person("Sebastian", 27);
        Person p2 = new Person("Amanda", 26);
        Person p3 = new Person();

        // Skriv ut person 1 och person 2
        System.out.println("Skriv ut person 1 och 2:");
        System.out.println(p1.getPerson());
        System.out.println(p2.getPerson());

        // Ändra person 1 och skriv ut
        p1.setNamn("Pål");
        p1.setAlder(3);
        System.out.println("Skriver ut ändrad person 1:");
        System.out.println(p1.getPerson());

        // Skapa objekt-array som heter personer med 5 objekt
        Person[] personer = new Person[5];

        // Sätt skapa 4 person-objekt i array
        personer[0] = p1;
        personer[1] = p2;
        personer[2] = p3;
        personer[3] = new Person("Abdullah", 3);

        // Loopa igenom objekt-array med samtliga personer
        System.out.println("Loopa igenom objekt-array:");
        for (int i = 0; i < personer.length; i++) {
            if (personer[i] != null) {
                System.out.println(personer[i].getPerson());
            }
        }*/
        JFrame frame = new JFrame("Person");
        frame.setContentPane(new PersonGUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
