package TwoPointersSummary;

public class ContainerWithMostWater_11 {
//https://leetcode.com/articles/container-with-most-water/

    //Approach 2: Two Pointer Approach
    public int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;

        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }

        return maxarea;
    }

    //Complexity Analysis
    //
    //Time complexity : O(n)O(n). Single pass.
    //
    //Space complexity : O(1)O(1). Constant space is used.
}
