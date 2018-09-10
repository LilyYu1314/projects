package DivideandConquer;

import java.util.Arrays;
import java.util.List;

public class CountofSmallerNumbersAfterSelf315 {

    //Same idea, iterative version, run in 7ms. Listed here only for reference.
    public List<Integer> countSmaller(int[] nums) {
        Integer[] count = new Integer[nums.length];
        if (nums.length == 0) {
            return Arrays.asList(count);
        }
        Node root = new Node(nums[nums.length - 1]);
        for (int i = nums.length - 1; i >= 0; i--) {
            count[i] = insert(root, nums[i]);
        }
        return Arrays.asList(count);
    }

    private int insert(Node node, int num) {
        int sum = 0;
        while (node.val != num) {
            if (node.val > num) {
                if (node.left == null) node.left = new Node(num);
                node.leftSum++;
                node = node.left;
            } else {
                sum += node.leftSum + node.count;
                if (node.right == null) node.right = new Node(num);
                node = node.right;
            }
        }
        node.count++;
        return sum + node.leftSum;
    }

}
