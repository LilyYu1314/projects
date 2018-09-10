package HighFrequence;

public class TreeNode {
    TreeNode left, right;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(TreeNode left, TreeNode right, int val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }

    public TreeNode(TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
    }
}