package MathSummary;

import java.util.Arrays;

public class MajorityElement_169 {
    //Approach 3: Sorting

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
    //Time complexity : O(nlgn)O(nlgn)
    //Sorting the array costs O(nlgn)O(nlgn) time in Python and Java, so it dominates the overall runtime.
    //
    //Space complexity : O(1)O(1) or (O(n)O(n))
    //We sorted nums in place here - if that is not allowed,
    //then we must spend linear additional space on a copy of nums and sort the copy instead.


    //Approach 6: Boyer-Moore Voting Algorithm
    public int majorityElementSec(int[] nums) {
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
    //Time complexity : O(n)O(n)
    //Boyer-Moore performs constant work exactly nn times, so the algorithm runs in linear time.
    //
    //Space complexity : O(1)O(1)
    //Boyer-Moore allocates only constant additional memory.
}
