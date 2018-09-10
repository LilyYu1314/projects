package HighFrequence;

public class RemoveElement27 {
    //Approach 1: Two Pointers
    //Time complexity : O(n)O(n). Assume the array has a total of nn elements, both ii and jj traverse at most 2n2n steps.
    //
    //Space complexity : O(1)O(1).
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }


    //Approach 2: Two Pointers - when elements to remove are rare
    //Time complexity : O(n)O(n). Both ii and nn traverse at most nn steps.
    // In this approach, the number of assignment operation is equal to the number of elements to remove.
    // So it is more efficient if elements to remove are rare.
    //
    //Space complexity : O(1)O(1).
    public int removeElementSec(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
}
