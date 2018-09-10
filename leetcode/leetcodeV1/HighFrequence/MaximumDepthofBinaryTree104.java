package HighFrequence;

public class MaximumDepthofBinaryTree104 {
    //时间复杂度，空间复杂度？
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
