package HighFrequence;

public class Numberof1Bits191 {
    //Approach #1 (Loop and Flip) [Accepted]
    //The run time depends on the number of bits in nn.
    // Because nn in this piece of code is a 32-bit integer, the time complexity is O(1)O(1).
    //
    //The space complexity is O(1)O(1), since no additional space is allocated.

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


    //Approach #2 (Bit Manipulation Trick) [Accepted]
    //The run time depends on the number of 11-bits in nn. In the worst case, all bits in nn are 11-bits.
    // In case of a 32-bit integer, the run time is O(1)O(1).
    //
    //The space complexity is O(1)O(1), since no additional space is allocated.

    public int hammingWeightSec(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
}
