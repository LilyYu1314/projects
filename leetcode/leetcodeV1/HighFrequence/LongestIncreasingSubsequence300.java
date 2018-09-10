package HighFrequence;

import java.util.Arrays;

public class LongestIncreasingSubsequence300 {
    //Approach #4 Dynamic Programming with Binary Search[Accepted]:

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);

            if (i < 0) {
                i = -(i + 1);
            }

            dp[i] = num;

            if (i == len) {
                len++;
            }

        }

        return len;
    }

    //Complexity Analysis
    //Time complexity : O(nlog(n))O(nlog(n)). Binary search takes log(n)log(n) time and it is called nn times.
    //Space complexity : O(n)O(n). dpdp array of size nn is used.
}
