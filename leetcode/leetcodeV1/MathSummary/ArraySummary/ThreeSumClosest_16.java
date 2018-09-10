package MathSummary.ArraySummary;

import java.util.Arrays;

public class ThreeSumClosest_16 {
    //You answer is great. However, we could improve performance a bit by skipping duplicate elements.
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[nums.length - 1];
        int closestSum = sum;

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    sum = nums[left] + nums[right] + nums[i];
                    if (sum < target) {
                        //move closer to target sum.
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                    } else if (sum > target) {
                        //move closer to target sum.
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else {
                        return sum;
                    }
                    //update the closest sum if needed.
                    if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                        closestSum = sum;
                    }
                }
            }

        }
        return closestSum;
    }



    public int threeSumClosestSec(int[] num, int target) {
        int result = num[0] + num[1] + num[num.length - 1];
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1, end = num.length - 1;

            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }

                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }

        }
        return result;
    }
}
