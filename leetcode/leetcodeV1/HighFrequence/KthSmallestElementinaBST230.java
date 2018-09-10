package HighFrequence;

import java.util.Stack;

public class KthSmallestElementinaBST230 {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        int count = 0;

        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);    // Just like recursion
                p = p.left;

            } else {
                TreeNode node = stack.pop();
                if (++count == k) return node.val;
                p = node.right;
            }
        }

        return Integer.MIN_VALUE;
    }

}
