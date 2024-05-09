package Algo2023.SelfLearning;

public class KthElement {
    public static int select(int[] arr, int p, int r, int i) {
        if ( p == r ) return arr[p];
        int q = QuickSort.partition(arr, p, r);
        int k = q - p + 1;
        return ( i == k ) ? arr[q] :
                (( i < k ) ? select(arr, p, q - 1, i)
                        : select(arr, q + 1, r, i - k));

    }

    public static void main(String[] args) {
        System.out.println(select(new int[]{3, 5, 6, 9, 4, 1, 8, 2, 7}, 0, 8, 5));
    }
}
