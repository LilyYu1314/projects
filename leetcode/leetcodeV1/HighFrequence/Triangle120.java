package HighFrequence;

import java.util.List;

public class Triangle120 {
    //https://leetcode.com/problems/triangle/discuss/38730/DP-Solution-for-Triangle
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0)
            return 0;

        for (int i = triangle.size() - 2; i >= 0; i--) {

            for (int j = 0; j <= i; j++) {

                List<Integer> nextRow = triangle.get(i + 1);
                int sum = Math.min(nextRow.get(j), nextRow.get(j + 1)) + triangle.get(i).get(j);
                triangle.get(i).set(j, sum);

            }
        }

        return triangle.get(0).get(0);
    }
}
