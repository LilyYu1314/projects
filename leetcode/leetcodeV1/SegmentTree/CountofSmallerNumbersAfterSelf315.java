package SegmentTree;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CountofSmallerNumbersAfterSelf315 {
    class Node {
        Node left, right;
        int val, sum, dup = 1;
        public Node(int v, int s) {
            val = v;
            sum = s;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(nums[i], root, ans, i, 0);
        }
        return Arrays.asList(ans);
    }

    private Node insert(int num, Node node, Integer[] ans, int i, int preSum) {
        if (node == null) {
            node = new Node(num, 0);
            ans[i] = preSum;
            System.out.println("ans[i]: "+ans[i]);
        } else if (node.val == num) {
            node.dup++;
            ans[i] = preSum + node.sum;
            System.out.println("node.dup: "+node.dup);
            System.out.println("preSum: "+preSum);
            System.out.println("node.sum: "+node.sum);
        } else if (node.val > num) {
            node.sum++;
            node.left = insert(num, node.left, ans, i, preSum);
        } else {
            node.right = insert(num, node.right, ans, i, preSum + node.dup + node.sum);
        }
        return node;
    }

    @Test
    public void testCountofSmallerNumbersAfterSelf315() {
        //System.out.println("Hello World!");
        int[] nums = {5,2,6,1};
        List<Integer> result= this.countSmaller(nums);
        System.out.println("result.toString(): "+ result.toString());
    }
}
