package HighFrequence;

public class Searcha2DMatrixII240 {
    //We can rule out one row or one column each time, so the time complexity is O(m+n).
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        int col = matrix[0].length - 1;
        int row = 0;

        while (col >= 0 && row <= matrix.length - 1) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target < matrix[row][col]) {
                col--;
            } else if (target > matrix[row][col]) {
                row++;
            }
        }

        return false;
    }


    //For those who may wonder, it's also OK to search from the bottom-left point. Just check the code below.
    public static boolean searchMatrixSec(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1)
            return false;

        int col = 0;
        int row = matrix.length - 1;
        while (col <= matrix[0].length - 1 && row >= 0) {
            if (target == matrix[row][col])
                return true;
            else if (target < matrix[row][col])
                row--;
            else if (target > matrix[row][col])
                col++;
        }
        return false;
    }
}
