package HighFrequence;

import java.util.Arrays;

public class MajorityElement169 {
    //Approach 6: Boyer-Moore Voting Algorithm
    //Time complexity : O(n)O(n)
    //Boyer-Moore performs constant work exactly nn times, so the algorithm runs in linear time.
    //
    //Space complexity : O(1)O(1)
    //Boyer-Moore allocates only constant additional memory.
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }


    //Approach 3: Sorting
    //Time complexity : O(nlgn)O(nlgn)
    //Sorting the array costs O(nlgn)O(nlgn) time in Python and Java, so it dominates the overall runtime.
    //
    //Space complexity : O(1)O(1) or (O(n)O(n))
    //We sorted nums in place here - if that is not allowed, then we must spend linear additional space on a copy of nums and sort the copy instead.
    public int majorityElementSec(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

}
