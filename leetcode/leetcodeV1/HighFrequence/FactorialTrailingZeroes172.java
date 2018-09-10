package HighFrequence;

public class FactorialTrailingZeroes172 {

    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

    //Because all trailing 0 is from factors 5 * 2.
    //
    //But sometimes one number may have several 5 factors, for example, 25 have two 5 factors, 125 have three 5 factors.
    // In the n! operation, factors 2 is always ample. So we just count how many 5 factors in all number from 1 to n.

    //25, 24, 23, 22, 21 ----- 25/5 = 5
    //20, 19, 18, 17, 16 ----- 20/5 = 4
    //15, 14, 13, 12, 11------ 15/5 = 3
    //10, 9, 8, 7, 6 ----------- 10/5 = 2
    //5, 4, 3, 2, 1 -------------- 5/5 = 1
    //which gives anther loop: 5, 4, 3, 2, 1 ('2' is always enough for '5' to multiply)
    //So: 25/5 + 5/5 = 6
    //
    //For n = 125, the second loop would be 25, 24,...,1, and the third loop 5, 4, 3, 2, 1.
    //So: 125/5 + trailingZeros(25) = 25 + 6 = 31
}
