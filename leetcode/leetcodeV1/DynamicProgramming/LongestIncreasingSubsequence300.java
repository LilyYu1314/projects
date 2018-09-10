package DynamicProgramming;

import org.junit.Test;

import java.util.Arrays;

public class LongestIncreasingSubsequence300 {
    //Approach #4 Dynamic Programming with Binary Search[Accepted]
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


    @Test
    public void test() {
        //System.out.println("Hello World!");
        int[] nums = {10,9,2,5,3,7,101,18};
        int result = this.lengthOfLIS(nums);
        System.out.println("result: " + result);
    }


    //Approach #3 Dynamic Programming [Accepted]
    public int lengthOfLISSec(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
}
