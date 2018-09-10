package BitSummary;

public class Numberof_1_Bits_191 {
    //Approach #1 (Loop and Flip) [Accepted]
    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }
    //Complexity Analysis
    //The run time depends on the number of bits in nn.
    //Because nn in this piece of code is a 32-bit integer, the time complexity is O(1)O(1).
    //
    //The space complexity is O(1)O(1), since no additional space is allocated.


    //Approach #2 (Bit Manipulation Trick) [Accepted]
    //In the binary representation, the least significant 11-bit in nn always corresponds to a 00-bit in n - 1n−1. Therefore,
    //anding the two numbers nn and n - 1n−1 always flips the least significant 11-bit in nn to 00, and keeps all other bits the same.
    public int hammingWeightSec(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
    //Complexity Analysis
    //The run time depends on the number of 11-bits in nn.
    // In the worst case, all bits in nn are 11-bits. In case of a 32-bit integer, the run time is O(1)O(1).
    //
    //The space complexity is O(1)O(1), since no additional space is allocated.
}
