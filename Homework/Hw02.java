package Algo2023.Homework;

public class Hw02 {
    public static int MaxSequence(int[] arr) {
        int cur = 0, ans = 0;
        for ( int i = 0; i < arr.length; i++ ) {
            cur += arr[i];
            cur = Math.max(cur, 0);
            ans = Math.max(cur, ans);
            System.out.println(i + " " + ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 4, -3, 5, -1, -2, 3, -1, 2};
//        System.out.println(MaxSequence(numbers));
        int x = 91, y = 100, cnt = 0;
        while ( y > 0 ) {
            if ( x > 100 ) {
                x -= 10;
                y -= 1;
            } else {
                x ++;
            }
            cnt ++;
        }
        System.out.println(cnt);

    }
}
