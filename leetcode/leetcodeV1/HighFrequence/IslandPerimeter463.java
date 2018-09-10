package HighFrequence;

public class IslandPerimeter463 {
    public int islandPerimeter(int[][] grid) {
        int islands = 0, neighbours = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                }
            }
        }

        return islands * 4 - neighbours * 2;
    }


    //Easy solution without dfs, just iterate each cell and count how many edges we need to add : )
    public int islandPerimeterSec(int[][] grid) {
        int sum = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) return sum;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                    continue;
                if (i == 0 || grid[i - 1][j] == 0) sum++;
                if (i == grid.length - 1 || grid[i + 1][j] == 0) sum++;
                if (j == 0 || grid[i][j - 1] == 0) sum++;
                if (j == grid[0].length - 1 || grid[i][j + 1] == 0) sum++;
            }
        }

        return sum;
    }
}
