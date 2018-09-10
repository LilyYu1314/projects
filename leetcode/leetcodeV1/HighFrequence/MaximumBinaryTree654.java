package HighFrequence;

public class MaximumBinaryTree654 {
    //Approach #1 Recursive Solution[Accepted]
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
    }

    public TreeNode construct(int[] nums, int l, int r) {
        if (l == r)
            return null;
        int max_i = max(nums, l, r);
        TreeNode root = new TreeNode(nums[max_i]);
        root.left = construct(nums, l, max_i);
        root.right = construct(nums, max_i + 1, r);
        return root;
    }

    public int max(int[] nums, int l, int r) {
        int max_i = l;
        for (int i = l; i < r; i++) {
            if (nums[max_i] < nums[i])
                max_i = i;
        }
        return max_i;
    }

    //Time complexity : O(n^2)O(n2). The function construct is called nn times. At each level of the recursive tree,
    // we traverse over all the nn elements to find the maximum element.
    // In the average case, there will be a log(n)log(n) levels leading to a complexity of O\big(nlog(n)\big)O(nlog(n)).
    // In the worst case, the depth of the recursive tree can grow upto nn,
    // which happens in the case of a sorted numsnums array, giving a complexity of O(n^2)O(n2).
    //Space complexity : O(n)O(n). The size of the setset can grow upto nn in the worst case.
    // In the average case, the size will be log(n)log(n) for nn elements in numsnums, giving an average case complexity of O(log(n))O(log(n))
}
