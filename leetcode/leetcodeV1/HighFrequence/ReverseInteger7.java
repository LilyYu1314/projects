package HighFrequence;

import org.junit.Test;

public class ReverseInteger7 {
    //Approach 1: Pop and Push Digits & Check before Overflow
    //Time Complexity: O(\log(x))O(log(x)). There are roughly \log_{10}(x)log
    //​10
    //​​ (x) digits in xx.
    //Space Complexity: O(1)O(1).
    public int reverse(int x) {
        int rev = 0;

        while (x != 0) {
            int pop = x % 10;
            x /= 10;

            //We are using 7 and -8 because the 32 bit INT_MAX and INT_MIN last digit is 7 & -8 respectively;
            // so if the rev is already equal to INT_MAX/10 and pop is . greater than 7 (or less than -8) then it'll be overflow.
            //INT_MIN=	–2147483647 – 1
            //INT_MAX =	2147483647
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }

        return rev;
    }

    @Test
    public void test() {
        //System.out.println("Hello World!");
        int num = 146;
        int result = reverse(num);
        System.out.println("result: " + result);
    }

}