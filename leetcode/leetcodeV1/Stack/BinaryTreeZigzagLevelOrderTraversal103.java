package Stack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal103 {
    //O(n) solution by using LinkedList along with ArrayList. So insertion in the inner list and outer list are both O(1),
    //Using DFS and creating new lists when needed.
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> sol = new ArrayList<>();
        travel(root, sol, 0);
        return sol;
    }

    private void travel(TreeNode curr, List<List<Integer>> sol, int level) {
        if (curr == null) return;

        if (sol.size() <= level) {
            List<Integer> newLevel = new LinkedList<>();
            sol.add(newLevel);
        }

        List<Integer> collection = sol.get(level);
        if (level % 2 == 0) collection.add(curr.val);
        else collection.add(0, curr.val);

        travel(curr.left, sol, level + 1);
        travel(curr.right, sol, level + 1);
    }



    //Just a little change from the Binary Tree Level Order Traversal
    //I use a queue to implement BFS. Each time when I poll a node, I add this node value to level.
    // I use a variable zigzag to indicate whether add from left to right or right to left.
    // If zigzag == false, it is from left to right;if zigzag == true, it is from right to left.
    //And from right to left just need to use ArrayList.add(0, value) method
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean zigzag = false;
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int cnt = queue.size();
            for (int i = 0; i < cnt; i++) {
                TreeNode node = queue.poll();
                if (zigzag) {
                    level.add(0, node.val);
                } else {
                    level.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);
            zigzag = !zigzag;
        }
        return res;
    }

    @Test
    public  void test() {
        //System.out.println("Hello World!");
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = this.zigzagLevelOrder(root);
    }
}
