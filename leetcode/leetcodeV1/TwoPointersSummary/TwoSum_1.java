package TwoPointersSummary;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
    //Approach 3: One-pass Hash Table
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
    //Complexity Analysis:
    //
    //Time complexity : O(n)O(n).
    // We traverse the list containing nn elements only once. Each look up in the table costs only O(1)O(1) time.
    //
    //Space complexity : O(n)O(n).
    // The extra space required depends on the number of items stored in the hash table, which stores at most nn elements.
}
