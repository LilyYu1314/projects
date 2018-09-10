package BitManipulation;


public class MissingNumber268 {

    //Approach #3 Bit Manipulation [Accepted]
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    //Approach #4 Gauss' Formula [Accepted]
    public int missingNumberSec(int[] nums) {
        int expectedSum = nums.length * (nums.length + 1) / 2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }
}
