package Algo2023.SelfLearning;

import java.util.List;
import java.util.PriorityQueue;

public class HuffmanNode implements Comparable<HuffmanNode> {
    int val;
    HuffmanNode left;
    HuffmanNode right;
    boolean isData = true;

    HuffmanNode(int val, HuffmanNode left, HuffmanNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    HuffmanNode(int val, HuffmanNode left, HuffmanNode right, boolean isData) {
        this(val, left, right);
        this.isData = isData;
    }

    public static HuffmanNode build(HuffmanNode[] nodes) {
        PriorityQueue<HuffmanNode> q = new PriorityQueue<>(List.of(nodes));
        while ( q.size() > 1 ) {
            HuffmanNode h1 = q.poll();
            HuffmanNode h2 = q.poll();
            q.add(new HuffmanNode(h1.val + h2.val, h1, h2, false));
        }
        return q.peek();
    }

    @Override
    public int compareTo(HuffmanNode h) {
        return this.val - h.val;
    }
    @Override
    public String toString() {
        return this.isData ? "" + this.val : "(" + this.val + ")";
    }

    public static void main(String[] args) {
        HuffmanNode hfm = build(new HuffmanNode[]{
                new HuffmanNode(35, null, null),
                new HuffmanNode(25, null, null),
                new HuffmanNode(15, null, null),
                new HuffmanNode(15, null, null),
                new HuffmanNode(10, null, null),
        });
        System.out.println(hfm);
        System.out.println(hfm.left.left);
        System.out.println(hfm.left.right.left);
        System.out.println(hfm.left.right.right);
        System.out.println(hfm.right.left);
        System.out.println(hfm.right.right);
    }


}
