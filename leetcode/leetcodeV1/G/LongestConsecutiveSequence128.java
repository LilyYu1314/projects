package G;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class LongestConsecutiveSequence128 {
    //Approach 3: HashSet and Intelligent Sequence Building
    //Time complexity : O(n)O(n).
    //Space complexity : O(n)O(n).
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
            System.out.println("num_set: " + num_set.toString());
        }

        int longestStreak = 0;

        for (int num : num_set) {
            System.out.println("num: " + num);
          if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }


    @Test
    public void test() {
        int[] nums  = {100, 4, 200, 1, 3, 2};
        int result = longestConsecutive(nums);
        System.out.println("result: " + result);
    }

    //Approach 2: Sorting
    //Time complexity : O(nlgn)O(nlgn).
    //Space complexity : O(1)O(1) (or O(n)O(n)).
    public int longestConsecutiveSec(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int longestStreak = 1;
        int currentStreak = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] == nums[i - 1] + 1) {
                    currentStreak += 1;
                } else {
                    longestStreak = Math.max(longestStreak, currentStreak);
                    currentStreak = 1;
                }
            }
        }

        return Math.max(longestStreak, currentStreak);
    }
}
