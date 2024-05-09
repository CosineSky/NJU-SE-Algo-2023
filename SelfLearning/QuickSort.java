package Algo2023.SelfLearning;

import java.util.Arrays;

public class QuickSort {
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void sort(int[] arr, int l, int r) {
        if ( l < r ) {
            int mid = partition(arr, l, r);
            sort(arr, l, mid - 1);
            sort(arr, mid + 1, r);
        }
    }

    public static int partition(int[] arr, int l, int r) {
        int pivot = arr[l];
        int i = l, j = r;
        while ( i < j ) {
            while (i < j && arr[j] >= pivot) j--;
            while (i < j && arr[i] <= pivot) i++;
            if ( i < j ) {
                swap(arr, i, j);
            }
        }
        swap(arr, i, l);
        return j;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{6, 3, 4, 5, 2, 1, 8, 9, 7};
        sort(numbers, 0, numbers.length - 1);
        System.out.println(Arrays.toString(numbers));
    }

}
