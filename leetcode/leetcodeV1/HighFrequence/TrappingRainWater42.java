package HighFrequence;

public class TrappingRainWater42 {
    // O(n) time, O(1) space
    public int trap(int[] height) {
        int total = 0, high1 = 0, high2 = 0;

        for (int left = 0, right = height.length - 1; left < right; ) {
            if (height[left] < height[right]) {
                high1 = Math.max(high1, height[left]);
                total += high1 - height[left++];
            } else {
                high2 = Math.max(high2, height[right]);
                total += high2 - height[right--];
            }
        }

        return total;
    }
}
