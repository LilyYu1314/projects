package HighFrequence;

public class MissingNumber268 {
    //Approach #3 Bit Manipulation [Accepted]
    //Time complexity : \mathcal{O}(n)O(n)
    //Assuming that XOR is a constant-time operation, this algorithm does constant work on nn iterations, so the runtime is overall linear.
    //Space complexity : \mathcal{O}(1)O(1)
    //This algorithm allocates only constant additional space.

    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }


    //Approach #4 Gauss' Formula [Accepted]
    //Time complexity : \mathcal{O}(n)O(n)
    //Although Gauss' formula can be computed in \mathcal{O}(1)O(1) time, summing nums costs us \mathcal{O}(n)O(n) time,
    // so the algorithm is overall linear.
    // Because we have no information about which number is missing,
    // an adversary could always design an input for which any algorithm that examines fewer than nn numbers fails.
    // Therefore, this solution is asymptotically optimal.
    //Space complexity : \mathcal{O}(1)O(1)
    //
    //This approach only pushes a few integers around, so it has constant memory usage.

    public int missingNumberSec(int[] nums) {
        int expectedSum = nums.length * (nums.length + 1) / 2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }

}
