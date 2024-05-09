package Algo2023.Test;

import java.util.*;
import java.lang.Integer;

public class Traceback {
    Stack<Integer> cur = new Stack<>();
    HashSet<HashSet<Integer>> ans = new HashSet<>();

    public HashSet<HashSet<Integer>> traceBack(int n, int k) {
        backtracking(n, k, 1);
        return ans;
    }

    public void backtracking(int n, int k, int startIndex) {
        if ( cur.size() == k ) {
            ans.add(new HashSet<>(cur));
            return;
        }
        for ( int i = startIndex; i <= n; i++ ) {
            cur.push(i);
            backtracking(n, k, i + 1);
            cur.pop();
        }
    }

    public static void main(String[] args) {
        Traceback test = new Traceback();
        System.out.println(test.traceBack(5, 0));
    }
}
