package HighFrequence;

public class RotateArray189 {
    //Approach #4 Using Reverse [Accepted]
    //Complexity Analysis
    //Time complexity : O(n)O(n). nn elements are reversed a total of three times.
    //Space complexity : O(1)O(1). No extra space is used.

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    //Approach #3 Using Cyclic Replacements [Accepted]
    //Complexity Analysis
    //Time complexity : O(n)O(n). Only one pass is used.
    //Space complexity : O(1)O(1). Constant extra space is used.

    public void rotateSec(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

}
