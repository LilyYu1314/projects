package DynamicProgramming;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PerfectSquares279 {

    static List<Integer> result = new ArrayList<>();

    public int numSquares(int n) {
        if (result.size() == 0) {
            result.add(0);
        }

        while (result.size() <= n) {
            int m = result.size();
            int tempMin = Integer.MAX_VALUE;
            for (int j = 1; j * j <= m; j++) {
                tempMin = Math.min(tempMin, result.get(m - j * j) + 1);
                System.out.println();
            }
            result.add(tempMin);
        }

        return result.get(n);
    }


    @Test
    public void test() {
        //System.out.println("Hello World!");
        int n = 13;
        int result = this.numSquares(n);
        System.out.println("result: " + result);
    }
}
