package Tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

        if(root == null) return wrapList;

        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }

    //相同的思路，更好理解
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int cnt = queue.size();
            System.out.println("cnt: "+cnt);
            for (int i = 0; i < cnt; i++) {
                TreeNode node = queue.poll();
                System.out.println("node.val: "+node.val);
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

            }
            res.add(level);
            System.out.println("level.size(): "+level.size());
        }
        return res;
    }


    @Test
    public  void test() {
        //System.out.println("Hello World!");
        TreeNode right = new TreeNode(20);
        right.setLeft(new TreeNode(15));right.setRight(new TreeNode(7));
        TreeNode left =new TreeNode(9);
        left.setLeft(null);left.setRight(null);
        TreeNode root = new TreeNode(left,right,3);
        this.levelOrder2(root);
    }
}
