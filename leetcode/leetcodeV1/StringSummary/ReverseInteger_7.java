package StringSummary;

public class ReverseInteger_7 {

    //Time Complexity: O(\log(x))O(log(x)). There are roughly \log_{10}(x)log​10(x) digits in xx.
    //Space Complexity: O(1)O(1).

    public int reverse(int x) {
        int rev = 0;

        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }

        return rev;
    }

    //INT_MIN=	–2147483647 – 1
    //INT_MAX =	2147483647
}
