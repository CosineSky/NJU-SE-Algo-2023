package Algo2023.Test;

import java.util.ArrayList;
import java.util.Arrays;

class Node {
    public int coef;
    public int exp;
    public Node next = null;

    public Node() {
        coef = 0;
        exp = 0;
    }
    public Node(int coef, int exp) {
        this.coef = coef;
        this.exp = exp;
    }
}

public class Polys {
//    public static Node rev(Node link) {
//        Node ret = null, ptr = link;
//        while ( ptr != null ) {
//            Node next = ptr.next;
//            ptr.next = ret;
//            ret = ptr;
//            ptr = next;
//        }
//        return ret;
//    }

    public static Node add(Node link1, Node link2) {
        Node ret = new Node();
        Node ptr = ret, ptr1 = link1.next, ptr2 = link2.next;

        while ( ptr1 != null && ptr2 != null ) {
            if ( ptr1.exp > ptr2.exp ) {
                ptr.next = new Node(ptr1.coef, ptr1.exp);
                ptr1 = ptr1.next;
                ptr = ptr.next;
            }
            else if ( ptr1.exp < ptr2.exp ) {
                ptr.next = new Node(ptr2.coef, ptr2.exp);
                ptr2 = ptr2.next;
                ptr = ptr.next;
            }
            else {
                if ( ptr1.coef + ptr2.coef != 0 ) {
                    ptr.next = new Node(ptr1.coef + ptr2.coef, ptr2.exp);
                    ptr = ptr.next;
                }
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
        }

        if ( ptr1 != null ) {
            ptr.next = ptr1;
        }
        if ( ptr2 != null ) {
            ptr.next = ptr2;
        }
        return ret.next;
    }

    public static void main(String[] args) {
        Node l10 = new Node();
        Node l11 = new Node(3, 5);
        Node l12 = new Node(2, 4);
        Node l20 = new Node();
        Node l21 = new Node(4, 4);
        Node l22 = new Node(5, 3);
        l10.next = l11;
        l11.next = l12;
        l20.next = l21;
        l21.next = l22;
        Node l3 = add(l10, l20);

        while ( l3 != null ) {
            System.out.println(l3.coef + " " + l3.exp);
            l3 = l3.next;
        }

    }

}
