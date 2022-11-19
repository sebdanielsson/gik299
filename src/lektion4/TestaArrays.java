package lektion4;

import java.util.Arrays;
import java.util.Scanner;

public class TestaArrays {
    public static void main(String[] args) {
        // Skapa ett Scanner-objekt
        Scanner keyboard = new Scanner(System.in);

        // Skapa en array med 5 rader
        String[] students = new String[5];

        // Tilldela arrayen en lista med namn
        students[0] = "Mathias";
        students[1] = "Ulrika";
        students[2] = "Hans";
        students[3] = "Anders";
        students[4] = "William";

        // Skriv ut alla studenter
        System.out.println("Studenter:");
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
        System.out.println();

        // Samma som ovan men "shorthand"
        System.out.println("Studenter:");
        for (String temp:students) {
            System.out.println(temp);
        }
        System.out.println();

        // Skriv ut student på index
        System.out.println("Student: " + students[0]);
        System.out.println();

        // Sök student
        String searchStudent;

        System.out.println("Sök student:");
        searchStudent = keyboard.nextLine();

        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(searchStudent)) {
                System.out.println("Studenten " + searchStudent + " finns på position " + i + " i listan.");
            }
        }
        System.out.println();

        // Byt ut student
        String swapStudent, newStudent;
        boolean found = false;
        int indexStudent = 0;

        System.out.println("Skriv in namnet på studenten som ska bytas ut:");
        swapStudent = keyboard.nextLine();

        System.out.println("\nSkriv in den nya studenten:");
        newStudent = keyboard.nextLine();

        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(swapStudent)) {
                indexStudent = i;
                found = true;
                break;
            }
        }
        if (found) {
            students[indexStudent] = newStudent;
            System.out.println("\nLyckades byta ut " + swapStudent + " mot " + newStudent + ".\n");
            System.out.println("Uppdaterad lista:");
            for (int i = 0; i < students.length; i++) {
                System.out.println(students[i]);
            }
            System.out.println();
        } else {
            System.out.println("Den student du försökte byta ut hittades ej.");
        }

        // Sortera array (Fungerar enbart om array inte innehåller null)
        boolean noNull = true;

        for (String student : students) {
            if (student == null) {
                noNull = false;
                break;
            }
        }

        if (noNull) {
            System.out.println("Sorterar arrayen...");
            Arrays.sort(students);
            System.out.println(Arrays.toString(students));
        } else {
            System.out.println("Arrayen innehöll null värden och kan därför inte sorteras.");
        }

        // Ta bort student (Delete i Crud)
        int lastIndex = students.length - 1;
        String deleteStudent;

        System.out.println("Skriv in namnet på den som ska tas bort:");
        deleteStudent = keyboard.nextLine();

        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                lastIndex = i-1;
                break;
            }
        }

        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                if (students[i].equalsIgnoreCase(deleteStudent)) {
                    students[i] = students[lastIndex];
                    students[lastIndex] = null;
                    break;
                }
            }
        }
        System.out.println("\nLyckades att ta bort " + deleteStudent + ", ny lista: " + Arrays.toString(students));
    }
}
