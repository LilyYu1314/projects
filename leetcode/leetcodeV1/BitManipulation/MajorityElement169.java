package BitManipulation;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Approach #6 Boyer-Moore Voting Algorithm [Accepted]
public class MajorityElement169 {
    public int majorityElementFirst(int[] nums) {
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

    @Test
    public  void test() {
        //System.out.println("Hello World!");
        int nums[] = {2,2,1,1,1,2,2};
        int result = this.majorityElementFirst(nums);
        System.out.println("result: "+result);
    }

    //Approach #3 Sorting [Accepted]
    public int majorityElementSecond(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    //Approach #2 HashMap [Accepted]
    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                counts.put(num, counts.get(num) + 1);
            }
        }
        return counts;
    }

    public int majorityElementThird(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);
        Map.Entry<Integer, Integer> majorityEntry = null;

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }
        return majorityEntry.getKey();
    }

}
