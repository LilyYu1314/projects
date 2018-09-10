package HighFrequence;

public class MoveZeroes283 {
    public void moveZeroes(int[] nums) {
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[pos] = nums[i];
                pos++;
            }
        }
        for (; pos < nums.length; pos++) {
            nums[pos] = 0;
        }
    }

    //Space Complexity : O(1)O(1). Only constant space is used.
    //
    //Time Complexity: O(n)O(n). However, the total number of operations are still sub-optimal.
    // The total operations (array writes) that code does is nn (Total number of elements).
}
