package MathSummary;

import java.util.Arrays;

public class ArrayPartition_I_561 {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i += 2) {
            result += nums[i];
        }
        return result;
    }

    //So this problem becomes finding pairs in an array that makes sum of di (distance between ai and bi) as small as possible.
    //Apparently, sum of these distances of adjacent elements is the smallest
}
