package Algo2023.SelfLearning;

import java.util.Arrays;

public class Sorting {
    public static int[] shell_sort(int[] numbers) {
        for ( int gap = numbers.length / 2; gap >= 1; gap /= 2 ) {
            for ( int i = gap; i < numbers.length; i++ ) {
                int tmp = numbers[i];
                int j = i;
                for ( ; j >= gap && tmp < numbers[j - gap]; j -= gap ) {
                    numbers[j] = numbers[j - gap];
                }
                numbers[j] = tmp;
            }
        }
        return numbers;
    }

    public static void main(String[] args) {
//        int[] numbers = new int[]{4, 7, 3, 1, 6, 2, 8, 5};
//        System.out.println(Arrays.toString(shell_sort(numbers)));
        boolean a = true;
        String s = "123";
        String t = s;
        t = "456";
        if ( a )
            if ( a ) {
                a = true;
            }

        System.out.println(s);
    }
}
