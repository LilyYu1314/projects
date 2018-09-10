package DynamicProgramming;

public class HouseRobber198 {
//Time complexity : O(n)O(n). Assume that nn is the number of houses, the time complexity is O(n)O(n).
//Space complexity : O(1)O(1).
    public int rob(int[] num) {
        int prevMax = 0;
        int currMax = 0;
        for (int x : num) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }

}