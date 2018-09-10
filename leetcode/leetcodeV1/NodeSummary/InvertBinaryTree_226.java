package NodeSummary;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree_226 {
    //Approach #1 (Recursive) [Accepted]
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }
    //Complexity Analysis
    //
    //Since each node in the tree is visited only once, the time complexity is O(n)O(n), where nn is the number of nodes in the tree.
    // We cannot do better than that, since at the very least we have to visit each node to invert it.
    //
    //Because of recursion, O(h)O(h) function calls will be placed on the stack in the worst case, where hh is the height of the tree.
    //Because h\in O(n)h∈O(n), the space complexity is O(n)O(n).



    //Approach #2 (Iterative) [Accepted]
    public TreeNode invertTreeSec(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }
    //Complexity Analysis
    //
    //Since each node in the tree is visited / added to the queue only once, the time complexity is O(n)O(n),
    // where nn is the number of nodes in the tree.
    //
    //Space complexity is O(n)O(n), since in the worst case, the queue will contain all nodes in one level of the binary tree.
    // For a full binary tree, the leaf level has \lceil \frac{n}{2}\rceil=O(n)⌈​2n⌉=O(n) leaves.
}
