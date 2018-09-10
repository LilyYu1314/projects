package BitManipulation;

public class Numberof1Bits191 {

    //Approach #1 (Loop and Flip) [Accepted]
    public int hammingWeightFirst(int n) {
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
    public int hammingWeightSecond(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
}
