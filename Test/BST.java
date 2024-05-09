package Algo2023.Test;

import java.util.HashMap;

public class BST {
    private BSTNode root;
    private static HashMap<Character, Integer> indexMap;

    private int elementAt(BSTNode node) {
        return node == null ? -1 : node.val;
    }

    private BSTNode find(int number, BSTNode node) {
        if ( node == null ) {
            return null;
        }
        else if ( node.val > number ) {
            return find(number, node.left);
        }
        else if ( node.val < number ) {
            return find(number, node.right);
        }
        else {
            return node;
        }
    }

    private BSTNode findMin(BSTNode node) {
        if ( node == null ) {
            return null;
        }
        if ( node.left == null ) {
            return node;
        }
        return findMin(node.left);
    }

    private BSTNode findMax(BSTNode node) {
        if ( node == null ) {
            return null;
        }
        if ( node.right == null ) {
            return node;
        }
        return findMin(node.right);
    }

    private BSTNode insert(int number, BSTNode node) {
        if ( node == null ) {
            node = new BSTNode(number);
        }
        else if ( node.val > number ) {
            return insert(number, node.left);
        }
        else if ( node.val < number ) {
            return insert(number, node.right);
        }
        return node;
    }

    private BSTNode remove(int number, BSTNode node) {
        if ( node == null ) {
            return node;
        }
        else if ( node.val > number ) {
            node.left = remove(number, node.left);
        }
        else if ( node.val < number ) {
            node.right = remove(number, node.right);
        }
        else if ( node.left != null && node.right != null ) {
            node.val = findMin(node.right).val;
            node.right = remove(node.val, node.right);
        }
        else {
            node = node.left != null ? node.left : node.right;
        }
        return node;
    }

    private BSTNode removeMin(BSTNode node) {
        return null;
    }


    public void empty() {
        this.root = null;
    }
    public boolean isEmpty() {
        return this.root == null;
    }
    public int find(int number) {
        return elementAt(find(number, root));
    }
    public int findMin() {
        return elementAt(findMin(root));
    }
    public int findMax() {
        return elementAt(findMax(root));
    }
    public void insert(int number) {
        root = insert(number, root);
    }
    public void remove(int number) {
        root = remove(number, root);
    }


}

class BSTNode {
    int val;
    BSTNode left, right;

    BSTNode(int val) {
        this.val = val;
    }
    BSTNode(int val, BSTNode left, BSTNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}

