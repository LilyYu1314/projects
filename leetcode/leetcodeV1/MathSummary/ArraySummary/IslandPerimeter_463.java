package MathSummary.ArraySummary;

public class IslandPerimeter_463 {

    //loop over the matrix and count the number of islands;
    //if the current dot is an island, count if it has any right neighbour or down neighbour;
    //the result is islands * 4 - neighbours * 2
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



    //The idea is each time, we encounter a boundary, count++;
    //Iterative:
    public int islandPerimeterSec(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {

                    for (int[] d : dir) {
                        int x = i + d[0], y = j + d[1];
                        if (x < 0 || y < 0 || x == m || y == n || grid[x][y] == 0) {
                            count++;
                        }
                    }

                }
            }
        }

        return count;
    }
}
