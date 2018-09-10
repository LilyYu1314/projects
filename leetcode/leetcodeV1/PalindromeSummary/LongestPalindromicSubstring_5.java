package PalindromeSummary;

import org.junit.Test;

public class LongestPalindromicSubstring_5 {
    //https://leetcode.com/problems/longest-palindromic-substring/solution/

    //Approach 4: Expand Around Center
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);

            int len = Math.max(len1, len2);

            System.out.println("start: "+start);
            System.out.println("end: "+end);
            System.out.println("len: "+len);
            System.out.println();

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    //Complexity Analysis
    //Time complexity : O(n^2)O(n
    //​2
    //​​ ). Since expanding a palindrome around its center could take O(n)O(n) time, the overall complexity is O(n^2)O(n
    //​2
    //​​ ).
    //Space complexity : O(1)O(1).


    @Test
    public  void test() {
        //String s  = "babad";
        String result = longestPalindrome("cbbd");
        System.out.println("result: "+result);
    }
}
