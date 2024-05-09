package Algo2023.Homework;//// CURRENCY

class Hw01 {
    public static int ones(int num) {
        return (num == 0) ? 0 : ((num % 2 == 1) ? 1 + ones(num / 2) : ones(num / 2));
    }

    public static int getMax(int[] arr, int start) {
        return start == arr.length - 1 ? arr[start] : Math.max(arr[start], getMax(arr, start + 1));
    }

    public static double getAvg(int[] arr, int idx) {
        return (idx == 0) ? arr[idx] : (arr[idx] + idx * getAvg(arr, idx - 1)) / (idx + 1);
    }

    public static boolean isPalindrome(String s) {
        return s.length() <= 1 || ((s.charAt(0) == s.charAt(s.length() - 1)) && isPalindrome(s.substring(1, s.length() - 1)));
    }

    public static boolean isPalindromeSentence(String s) {
        return isPalindrome(s.replace(" ","").replaceAll("\\p{Punct}", ""));
    }

    public static void swap(char[] s, int i, int j) {
        char c = s[i]; s[i] = s[j]; s[j] = c;
    }

    public static void startPermutation(String s) {
        permute(s.toCharArray(), 0, s.length() - 1);
    }

    public static void permute(char[] s, int l, int r) {
        if ( l == r ) {
            for ( int i = 0; i <= r; i++ ) {
                System.out.print(s[i]);
            }
            System.out.println();
        }
        else {
            for ( int i = l; i <= r; i++ ) {
                swap(s, i, l);
                permute(s, l + 1, r);
                swap(s, i, l);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 9, 11, 13};
        char[] s = {'a', 'b', 'c'};
        System.out.println(isPalindrome("b"));
        System.out.println(getAvg(nums, nums.length - 1));
    }

}