package MathSummary;


public class HouseRobber_198 {

    int rob(int[] nums) {
        int n = nums.length, pre = 0, cur = 0;
        for (int i = 0; i < n; i++) {
            int temp = Math.max(pre + nums[i], cur);
            pre = cur;
            cur = temp;
        }
        return cur;
    }
}
