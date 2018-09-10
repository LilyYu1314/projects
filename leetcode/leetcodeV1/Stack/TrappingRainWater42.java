package Stack;

public class TrappingRainWater42 {

    public int trap(int[] heights) {

        if (heights.length <= 2) {
            return 0;
        }

        int left = 0, right = heights.length - 1, totalArea = 0;
        int leftMaxHeight = heights[left], rightMaxHeight = heights[right];

        while (left < right) {
            if (heights[left] < heights[right]) {
                leftMaxHeight = Math.max(leftMaxHeight, heights[++left]);
                totalArea += leftMaxHeight - heights[left];
            } else {
                rightMaxHeight = Math.max(rightMaxHeight, heights[--right]);
                totalArea += rightMaxHeight - heights[right];
            }
        }

        return totalArea;
    }
}
