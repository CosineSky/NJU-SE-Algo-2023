package Algo2023.SelfLearning;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    public static TreeNode build(int[] arr, int l, int r) {
        if ( l > r ) return null;
        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = build(arr, l, mid - 1);
        root.right = build(arr, mid + 1, r);
        return root;
    }
}

public class BST {
    TreeNode root;

    BST(int[] arr, int l, int r) {
        this.root = TreeNode.build(arr, l, r);
    }

    public void inOrderWalk(int idx) {

    }

    public int search(int idx, int val) {
        return -1;
    }

    public boolean isBST() {

        return false;
    }

    public static void main(String[] args) {
        BST bst = new BST(new int[]{1, 2, 3, 4, 5, 6, 7}, 0, 6);
        System.out.println(bst.root.val);
    }
}
