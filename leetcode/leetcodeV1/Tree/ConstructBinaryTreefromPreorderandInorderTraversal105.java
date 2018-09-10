package Tree;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//Say we have 2 arrays, PRE and IN.
//Preorder traversing implies that PRE[0] is the root node.
//Then we can find this PRE[0] in IN, say it's IN[5].
//Now we know that IN[5] is root, so we know that IN[0] - IN[4] is on the left side, IN[6] to the end is on the right side.
//Recursively doing this on subarrays, we can build a tree out of it
public class ConstructBinaryTreefromPreorderandInorderTraversal105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        System.out.println("inRoot: "+inRoot);
        System.out.println("numsLeft: "+numsLeft);
        System.out.println("preStart: "+preStart);
        System.out.println("inStart: "+inStart);
        System.out.println();

        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

        return root;
    }

    @Test
    public  void test() {
        //System.out.println("Hello World!");
        int [] preorder = {3,9,20,15,7};
        int [] inorder = {9,3,15,20,7};
        TreeNode result = this.buildTree(preorder,inorder);
        System.out.println(result.val);
        System.out.println(result.left.val);
        System.out.println(result.right.val);
    }
}
