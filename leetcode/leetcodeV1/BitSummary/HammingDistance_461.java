package BitSummary;

public class HammingDistance_461 {

    //时间复杂度空间复杂度？
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    //Integer.toBinaryString(i)
}
