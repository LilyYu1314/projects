package Tree;

import org.junit.Test;

public class MaximumDepthofBinaryTree104 {
    static int i;
    public int maxDepth(TreeNode root) {
        if(root != null){ System.out.print(root.val + " ");}else{System.out.print("     ");}
        System.out.print(++i);
        System.out.println();
        if(root==null){
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    @Test
    public  void test() {
      /* 3
        / \
       9  20
         /  \
        15   7*/
        TreeNode right = new TreeNode(20);
        right.setLeft(new TreeNode(15));right.setRight(new TreeNode(7));
        TreeNode left =new TreeNode(9);
        TreeNode root = new TreeNode(left,right,3);
        int result = this.maxDepth(root);
        System.out.println("result: "+result);
    }
}
