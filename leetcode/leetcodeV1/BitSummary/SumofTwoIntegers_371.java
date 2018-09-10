package BitSummary;

public class SumofTwoIntegers_371 {

    //https://leetcode.com/problems/sum-of-two-integers/discuss/84278/A-summary:-how-to-use-bit-manipulation-to-solve-problems-easily-and-efficiently

    int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1); //be careful about the terminating condition;
    }
}