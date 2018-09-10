package MathSummary;

public class FactorialTrailingZeroes_172 {

    //https://leetcode.com/problems/factorial-trailing-zeroes/discuss/52371/My-one-line-solutions-in-3-languages

    public int trailingZeroes(int n) {

        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
