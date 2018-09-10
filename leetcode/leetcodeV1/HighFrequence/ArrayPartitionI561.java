package HighFrequence;

import java.util.Arrays;

public class ArrayPartitionI561 {
    //Approach #2 Using Sorting [Accepted]
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
    //Time complexity : O\big(nlog(n)\big)O(nlog(n)). Sorting takes O\big(nlog(n)\big)O(nlog(n)) time.
    // We iterate over the array only once.
    //Space complexity : O(1)O(1). Constant extra space is used.



    //Approach #3 Using Extra Array [Accepted]
    public int arrayPairSumSec(int[] nums) {
        int[] arr = new int[20001];
        int lim = 10000;
        for (int num : nums)
            arr[num + lim]++;
        int d = 0, sum = 0;
        for (int i = -10000; i <= 10000; i++) {
            sum += (arr[i + lim] + 1 - d) / 2 * i;
            d = (2 + arr[i + lim] - d) % 2;
        }
        return sum;
    }
    //Time complexity : O(n)O(n). The whole hashmap arrarr of size nn is traversed only once.
    //Space complexity : O(n)O(n). A hashmap arrarr of size nn is used.
}
