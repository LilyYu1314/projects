package HighFrequence;

import org.junit.Test;

public class SingleNumberIII260 {

    public int[] singleNumber(int[] nums) {
        // Pass 1 :
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        // Get its last set bit
        System.out.println(diff);
        diff &= -diff;
        System.out.println(diff);

        // Pass 2 :
        int[] rets = {0, 0}; // this array stores the two numbers we will return
        for (int num : nums) {
            if ((num & diff) == 0)
            // the bit is not set, diff &= -diff or diff &= ~(diff-1) ,
            // set bit" means bit "1", "last set bit" means the right most bit "1".
            {
                rets[0] ^= num;
            } else // the bit is set
            {
                rets[1] ^= num;
            }
        }
        return rets;
    }

    // I think using the rightmost 1-bit is just for ease of coding (diff &= -diff will leave the rightmost 1-bit).
    // In fact, you can use any 1-bit. This 1-bit implies that the two single numbers are different at this bit.
    // Then we use this bit to split all the remaining numbers into two groups.
    // Suppose the two single numbers are a and b and they differ in the third bit (a is 1 at this bit while b is 0).
    // After splitting, numbers with 1 in the third bit will fall in the group of a while the remaining ones fall in the group of b.
    // Till now, we will be able to get a and b via a simple within-group xor.

    //〜	按位取反运算符翻转操作数的每一位，即0变成1，1变成0
    //使一个数的最低位为零，可以表示为：a&~1。
    //~1的值为1111111111111110，再按“与”运算，最低位一定为0。
    // 因为“~”运算符的优先级比算术运算符、关系运算符、逻辑运算符和其他运算符都高。
    //
    //“或运算”特殊作用：
    //（1）常用来对一个数据的某些位置1。
    //方法：找到一个数，对应X要置1的位，该数的对应位为1，其余位为零。此数与X相或可使X中的某些位置1。
    //例：将X=10100000的低4位置1 ，用 X | 0000 1111 = 1010 1111即可得到。
    //
    //“与运算”的特殊用途：
    //（1）清零。如果想将一个单元清零，即使其全部二进制位为0，只要与一个各位都为零的数值相与，结果为零。
    //（2）取一个数中指定位
    //方法：找一个数，对应X要取的位，该数的对应位为1，其余位为零，此数与X进行“与运算”可以得到X中的指定位。
    //例：设X=10101110，
    // 取X的低4位，用 X & 0000 1111 = 0000 1110 即可得到；
    // 还可用来取X的2、4、6位。

    @Test
    public void singleNumber() {
        int[] nums = {1, 2, 1, 3, 2, 5};
        int[] result = singleNumber(nums);

        System.out.println(3 ^ 5);
    }
}
