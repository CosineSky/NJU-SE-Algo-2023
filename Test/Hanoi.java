package Algo2023.Test;

import java.util.HashSet;
import java.util.LinkedList;

public class Hanoi {
    public void Hanoi_(int n) {
        move('A', 'C', 'B', n);
    }
    public void move(char src, char tmp, char dest, int cnt) {
        if ( cnt == 1 ) {
            System.out.println("Move disk 1 from " + src + " to " + dest);
        }
        else {
            move(src, dest, tmp, cnt - 1);
            System.out.println("Move disk " + cnt + " from " + src + " to " + dest);
            move(tmp, src, dest, cnt - 1);
        }
    }

    public static void main(String[] args) {
        Hanoi test = new Hanoi();
        test.Hanoi_(3);
    }
}
