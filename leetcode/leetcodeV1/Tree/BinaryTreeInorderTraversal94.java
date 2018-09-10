package Tree;

import BinarySearchTree.CountofSmallerNumbersAfterSelf315;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal94 {

    //Approach #2 Iterating method using Stack [Accepted]
    //Complexity Analysis
    //Time complexity : O(n)O(n).
    //Space complexity : O(n)O(n).
    public class Solution {
        public List< Integer > inorderTraversal(TreeNode root) {
            List < Integer > res = new ArrayList< >();
            Stack< TreeNode > stack = new Stack < > ();
            TreeNode curr = root;
            while (curr != null || !stack.isEmpty()) {
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
                curr = stack.pop();
                res.add(curr.val);
                curr = curr.right;
            }
            return res;
        }
    }



    //Approach #1 Recursive Approach [Accepted]
    //Complexity Analysis
    //Time complexity : O(n)O(n). The time complexity is O(n)O(n) because the recursive function is T(n) = 2*T(n/2)+1T(n)=2∗T(n/2)+1.
    //Space complexity : The worst case space required is O(n)O(n), and in the average case it's O(log(n))O(log(n)) where nn is number of nodes.
    class Solution2 {
        public List < Integer > inorderTraversal(TreeNode root) {
            List < Integer > res = new ArrayList < > ();
            helper(root, res);
            return res;
        }

        public void helper(TreeNode root, List < Integer > res) {
            if (root != null) {
                if (root.left != null) {
                    helper(root.left, res);
                }
                res.add(root.val);
                if (root.right != null) {
                    helper(root.right, res);
                }
            }
        }
    }

}
