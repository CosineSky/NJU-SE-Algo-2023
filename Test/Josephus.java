package Algo2023.Test;

public class Josephus {
    public static int lastRemaining(int n, int m) {
        int ret = 0;
        for ( int i = 2; i <= n; i++ ) {
            ret = (ret + m) % i;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(lastRemaining(5, 2));
    }
}