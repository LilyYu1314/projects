package Tree;

import org.junit.Test;

public class BinaryTreeMaximumPathSum124 {
    int maxValue;

    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }

    private int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));

       //The second maxValue contains the bigger between the left sub-tree and right sub-tree.
       //if (left + right + node.val < maxValue ) then the result will not include the parent node
       //which means the maximum path is in the left branch or right branch.
        maxValue = Math.max(maxValue, left + right + node.val);

        return Math.max(left, right) + node.val;
    }

    @Test
    public  void test() {
        TreeNode firstRight = new TreeNode(20);
        firstRight.setLeft(new TreeNode(15));firstRight.setRight(new TreeNode(7));
        TreeNode firstLeft =new TreeNode(9);
        firstLeft.setLeft(null);firstLeft.setRight(null);
        TreeNode root = new TreeNode(firstLeft,firstRight,-10);
        int result = this.maxPathSum(root);
        System.out.println("result: "+result);
    }
}
