package HighFrequence;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {
    //Approach 3: One-pass Hash Table
    //Time complexity : O(n)O(n).
    // We traverse the list containing nn elements only once. Each look up in the table costs only O(1) time.
    //Space complexity : O(n).
    // The extra space required depends on the number of items stored in the hash table, which stores at most nn elements.
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    @Test
    public  void test() {
        //System.out.println("Hello World!");
        int[] nums = {2, 7, 11, 15}; int target = 9;
        int[] result  = twoSum(nums,target);
        System.out.println("result: "+result.toString());
    }


    //Approach 2: Two-pass Hash Table
    //Time complexity : O(n).
    // We traverse the list containing nn elements exactly twice. Since the hash table reduces the look up time to O(1)O(1), the time complexity is O(n)O(n).
    //
    //Space complexity : O(n).
    //The extra space required depends on the number of items stored in the hash table, which stores exactly nn elements.
    public int[] twoSumSec(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
