package HighFrequence;

import org.junit.Test;

public class PowerofThree326 {
    public boolean isPowerOfThree(int n) {

        return n > 0 && 1162261467 % n == 0;
    }

    //Complexity Analysis
    //
    //Time complexity : O(1)O(1). We are only doing one operation.
    //
    //Space complexity : O(1)O(1). We are not using any additional memory.

    @Test
    public void test() {
        int max = 1;
        while (max * 3 > max) max *= 3;
        System.out.println(max);
    }
}
