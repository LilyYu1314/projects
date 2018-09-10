package Memoization;

import org.junit.Test;

public class LongestIncreasingPathinaMatrix329 {
    // DFS + Memoization Solution
    // Accepted and Recommended
    //Approach #2 (DFS + Memoization) [Accepted]

    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m, n;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        m = matrix.length;
        n = matrix[0].length;
        int[][] cache = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j){
                ans = Math.max(ans, dfs(matrix, i, j, cache));
                System.out.println("ans: "+ans);
            }
        }
        return ans;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] cache) {
        System.out.println();
        System.out.println("welcome to dfs");
        if (cache[i][j] != 0) return cache[i][j];
        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            System.out.println("d[0]: "+ d[0]);
            System.out.println("d[1]: "+ d[1]);
            if (0 <= x && x < m && 0 <= y && y < n && matrix[x][y] > matrix[i][j]){
                cache[i][j] = Math.max(cache[i][j], dfs(matrix, x, y, cache));
                System.out.println("cache[i][j]: "+cache[i][j]);
                System.out.println("x: "+ x);
                System.out.println("y: "+ y);
                System.out.println("matrix[x][y]: "+matrix[x][y]);
                System.out.println("matrix[i][j]: "+matrix[i][j]);
            }
        }
        return ++cache[i][j];
    }

    @Test
    public void testLongestIncreasingPathinaMatrix329() {
        //System.out.println("Hello World!");
        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
        int result= this.longestIncreasingPath(matrix);
        System.out.println("result: "+ result);
    }
}
