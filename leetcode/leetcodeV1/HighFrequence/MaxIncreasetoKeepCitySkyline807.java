package HighFrequence;

public class MaxIncreasetoKeepCitySkyline807 {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int N = grid.length;
        int[] rowMaxes = new int[N];
        int[] colMaxes = new int[N];

        for (int r = 0; r < N; ++r)
            for (int c = 0; c < N; ++c) {
                rowMaxes[r] = Math.max(rowMaxes[r], grid[r][c]);
                colMaxes[c] = Math.max(colMaxes[c], grid[r][c]);
            }

        int ans = 0;

        for (int r = 0; r < N; ++r)
            for (int c = 0; c < N; ++c)
                ans += Math.min(rowMaxes[r], colMaxes[c]) - grid[r][c];

        return ans;
    }

    //Time Complexity: O(N^2)O(N2), where NN is the number of rows (and columns) of the grid. We iterate through every cell of the grid.
    //Space Complexity: O(N)O(N), the space used by row_maxes and col_maxes.
}
