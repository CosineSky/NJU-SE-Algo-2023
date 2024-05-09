package Algo2023.SelfLearning;

class Node {
    int val;
    Node next;
    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

public class LinkedList {
    private final Node header;

    LinkedList() {
        this.header = new Node(0, null);
    }

    LinkedList(int[] arr) {
        this.header = new Node(0, null);
        Node tail = header;
        for ( int i : arr ) {
            tail.next = new Node(i, null);
            tail = tail.next;
        }
    }

    public void append(int val) {
        Node ptr = this.header;
        while ( ptr.next != null ) ptr = ptr.next;
        ptr.next = new Node(val, null);
    }

    public String toString() {
        StringBuilder ret = new StringBuilder();
        Node ptr = this.header;
        while ( ptr != null ) {
            ret.append(ptr.val).append(" -> ");
            ptr = ptr.next;
        }
        ret.append("null");
        return ret.toString();
    }

    public void swapNext(Node prev) {
        Node first = prev.next;
        Node second = first.next;
        first.next = second.next;
        second.next = first;
        prev.next = second;
    }

    public LinkedList reverse() {
        LinkedList rev = new LinkedList();
        Node ptr = this.header, sec = rev.header.next;
        while ( ptr.next != null ) {
            ptr = ptr.next;
            sec = new Node(ptr.val, sec);
            rev.header.next = sec;
        }
        return rev;
    }

    public static LinkedList setOps(LinkedList A, LinkedList B, boolean isUnion) {
        LinkedList ret = new LinkedList();
        Node ptr1 = A.header.next, ptr2 = B.header.next;
        while ( ptr1 != null && ptr2 != null ) {
            if ( ptr1.val > ptr2.val ) {
                if ( isUnion ) ret.append(ptr2.val);
                ptr2 = ptr2.next;
            }
            else if ( ptr1.val < ptr2.val ) {
                if ( isUnion ) ret.append(ptr1.val);
                ptr1 = ptr1.next;
            }
            else {
                ret.append(ptr1.val);
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
        }
        while ( ptr1 != null ) {
            ret.append(ptr1.val);
            ptr1 = ptr1.next;
        }
        while ( ptr2 != null ) {
            ret.append(ptr2.val);
            ptr2 = ptr2.next;
        }

        return ret;
    }


    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList(new int[]{2, 3, 5, 7, 11, 13, 17, 19});
        LinkedList ll2 = new LinkedList(new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19});
        System.out.println(setOps(ll1, ll2, false));
    }

}
