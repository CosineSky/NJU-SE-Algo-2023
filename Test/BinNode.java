package Algo2023.Test;


import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class BinNode<T> {

    private T element;
    private BinNode<T> left, right;
    private HashMap<T, Integer> indexMap;
    private final StringBuilder traverseNodes = new StringBuilder();

    BinNode(){}
    BinNode(T element) {
        this.element = element;
    }
    BinNode(T element, BinNode<T> left, BinNode<T> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

    public BinNode<T> CreateBT(T[] pres, T[] ins) {
        int nodes = pres.length;
        indexMap = new HashMap<>();
        for ( int i = 0; i < nodes; i++ ) {
            indexMap.put(ins[i], i);
        }
        return build(pres, ins, 0, nodes - 1, 0, nodes - 1);
    }
    public BinNode<T> build(T[] pres, T[] ins, int pres_from, int pres_to, int ins_from, int ins_to) {
        if ( pres_from > pres_to ) {
            return null;
        }
        int ins_root = indexMap.get(pres[pres_from]);
        int left_tree_size = ins_root - ins_from;

        BinNode<T> root = new BinNode<>(pres[pres_from]);
        root.left = build(pres, ins, pres_from + 1, pres_from + left_tree_size, ins_from, ins_root - 1);
        root.right = build(pres, ins, pres_from + left_tree_size + 1, pres_to, ins_root + 1, ins_to);
        return root;
    }

    public StringBuilder PreOrderTraversal() {
        traverseNodes.setLength(0);
        preorder_(this);
        return traverseNodes;
    }
    private void preorder_(BinNode<T> root) {
        if ( root != null ) {
            traverseNodes.append(root.element);
            preorder_(root.left);
            preorder_(root.right);
        }
    }

    public StringBuilder InOrderTraversal() {
        traverseNodes.setLength(0);
        inorder_(this);
        return traverseNodes;
    }
    private void inorder_(BinNode<T> root) {
        if ( root != null ) {
            inorder_(root.left);
            traverseNodes.append(root.element);
            inorder_(root.right);
        }
    }

    public StringBuilder PostOrderTraversal() {
        traverseNodes.setLength(0);
        postorder_(this);
        return traverseNodes;
    }
    private void postorder_(BinNode<T> root) {
        if ( root != null ) {
            postorder_(root.left);
            postorder_(root.right);
            traverseNodes.append(root.element);
        }
    }

    public StringBuilder LevelOrderTraversal() {
        traverseNodes.setLength(0);
        Queue<BinNode<T>> q = new ArrayDeque<>();
        q.add(this);
        while ( !q.isEmpty() ) {
            BinNode<T> cur = q.peek();
            traverseNodes.append(cur.element);
            if ( cur.left != null ) {
                q.add(cur.left);
            }
            if ( cur.right != null ) {
                q.add(cur.right);
            }
            q.poll();
        }
        return traverseNodes;
    }

    public static void main(String[] args) {
        BinNode<Integer> bt = new BinNode<>();
        bt = bt.CreateBT(new Integer[]{1, 2, 3}, new Integer[]{2, 1, 3});
        System.out.println(bt.PostOrderTraversal());
    }

}