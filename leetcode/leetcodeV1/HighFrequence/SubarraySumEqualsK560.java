package HighFrequence;

import java.util.HashMap;

public class SubarraySumEqualsK560 {
    //Approach #4 Using hashmap [Accepted]

    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
    //Time complexity : O(n)O(n). The entire numsnums array is traversed only once.
    //
    //Space complexity : O(n)O(n). Hashmap mapmap can contain upto nn distinct entries in the worst case.


    //Approach #3 Without space [Accepted]
    public int subarraySumSec(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }

    //Time complexity : O(n^2)O(n2). We need to consider every subarray possible.
    //
    //Space complexity : O(1)O(1). Constant space is used.
}
