package DynamicProgramming;

import org.junit.Test;

import java.util.List;

//没看懂，悲哀
public class LongestPalindromicSubstring5 {
    //Approach 4: Expand Around Center
    public String longestPalindrome(String s) {
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        System.out.println("start: "+start);
        System.out.println("end: "+end);

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;

        System.out.println("L: "+L);
        System.out.println("R: "+R);

        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            System.out.println("welcome to while");
            System.out.println();
            L--;
            R++;
        }
        return R - L - 1;
    }

    @Test
    public void test() {
        //System.out.println("Hello World!");
        String s = "aba";

        String result = this.longestPalindrome(s);
        System.out.println("result: " + result);
    }
}
