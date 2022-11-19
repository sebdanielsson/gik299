package lektion4;

import java.util.Arrays;

public class IntArray {
    public static void main(String[] args) {
        int[] number = new int[10];

        for (int i = 0; i < number.length; i++)
            number[i] = (int) (Math.random() *10+1);

        System.out.println(Arrays.toString(number));
        Arrays.sort(number);
        System.out.println(Arrays.toString(number));
    }
}