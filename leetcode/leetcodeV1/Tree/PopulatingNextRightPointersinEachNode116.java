package Tree;

public class PopulatingNextRightPointersinEachNode116 {
    public class Solution {
        public void connect(TreeNode root) {
            if(root == null || root.left == null) return;
            connectNodes(root.left, root.right);
        }

        public void connectNodes(TreeNode node1, TreeNode node2) {
            node1.next = node2;
            if(node1.left != null) {
                connectNodes(node1.right, node2.left);
                connectNodes(node1.left, node1.right);
                connectNodes(node2.left, node2.right);
            }
        }
    }
}
