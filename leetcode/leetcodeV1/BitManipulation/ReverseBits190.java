package BitManipulation;

public class ReverseBits190 {
    public static int reverse(int i) {
        // HD, Figure 7-1
        i = (i & 0x55555555) << 1 | (i >>> 1) & 0x55555555;
        i = (i & 0x33333333) << 2 | (i >>> 2) & 0x33333333;
        i = (i & 0x0f0f0f0f) << 4 | (i >>> 4) & 0x0f0f0f0f;
        i = (i << 24) | ((i & 0xff00) << 8) |
                ((i >>> 8) & 0xff00) | (i >>> 24);
        return i;
    }


    public int reverseBits(int n) {
        int result = 0;
        for(int i=0; i<32; i++){
            result <<= 1;
            result += n&1;
            n >>= 1;
        }
        return result;
    }

}
