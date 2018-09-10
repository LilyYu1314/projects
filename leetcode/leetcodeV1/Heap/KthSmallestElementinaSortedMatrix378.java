package Heap;

import org.junit.Test;

//在另一个文件里有其他解法,那个可能更好理解些
public class KthSmallestElementinaSortedMatrix378 {

    public int kthSmallest(int[][] matrix, int k) {
        int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;//[lo, hi)
        System.out.println("lo: " + lo);
        System.out.println("hi: " + hi);

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0, j = matrix[0].length - 1;
            for (int i = 0; i < matrix.length; i++) {
                while (j >= 0 && matrix[i][j] > mid) j--;
                count += (j + 1);
            }
            if (count < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    @Test
    public void test() {
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k = 8;

        int result = this.kthSmallest(matrix, k);
        System.out.println("result: " + result);
    }
}
