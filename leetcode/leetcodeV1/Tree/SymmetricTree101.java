package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree101 {
    //Approach #1 (Recursive) [Accepted]
    //Complexity Analysis
    //Because we traverse the entire input tree once, the total run time is O(n)O(n), where nn is the total number of nodes in the tree.
    //The number of recursive calls is bound by the height of the tree. In the worst case, the tree is linear and the height is in O(n)O(n).
    //Therefore, space complexity due to recursive calls on the stack is O(n)O(n) in the worst case.
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }


    //Approach #2 (Iterative) [Accepted]
    //Complexity Analysis
    //Because we traverse the entire input tree once, the total run time is O(n)O(n), where nn is the total number of nodes in the tree.
    //There is additional space required for the search queue. In the worst case, we have to insert O(n)O(n) nodes in the queue.
    //Therefore, space complexity is O(n)O(n).
    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
}
