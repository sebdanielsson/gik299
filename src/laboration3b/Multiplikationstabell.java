package laboration3b;

import java.util.Random;

public class Multiplikationstabell {
    public static void main(String[] args) {
        int rows;
        Random randomObj = new Random();
        rows = randomObj.nextInt(12)+1;
        System.out.println("\t1\t2\t3\t4\t5\t6\t7\t8\t9\t10\t11\t12\t");
        System.out.println("----------------------------------------------------");

        for (int row = 1; row <= rows; row++) {
            System.out.print("\n" + row + "|\t");
            for (int col = 1; col <=12; col++) {
                System.out.print(row*col + "\t");
            }
        }
    }
}
