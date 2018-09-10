package Backtracking;

import org.junit.Test;

import java.util.List;

//I thought posting my notes out for anyone finding the algorithm hard to follow. Hope it helps
// greedy solution with idea of DFS
// starj stores the position of last * in p
// last_match stores the position of the previous matched char in s after a *
// e.g.
// s: a c d s c d
// p: * c d
// after the first match of the *, starj = 0 and last_match = 1
// when we come to i = 3 and j = 3, we know that the previous match of * is actually wrong,
// (the first branch of DFS we take is wrong)
// then it resets j = starj + 1
// since we already know i = last_match will give us the wrong answer
// so this time i = last_match+1 and we try to find a longer match of *
// then after another match we have starj = 0 and last_match = 4, which is the right solution
// since we don't know where the right match for * ends, we need to take a guess (one branch in DFS),
// and store the information(starj and last_match) so we can always backup to the last correct place and take another guess.

public class WildcardMatching44 {
    Boolean comparison(String str, String pattern) {
        int s = 0, p = 0, match = 0, starIdx = -1;
        while (s < str.length()) {
            // advancing both pointers
            if (p < pattern.length() && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))) {
                s++;
                p++;
            }
            // * found, only advancing pattern pointer
            else if (p < pattern.length() && pattern.charAt(p) == '*') {
                starIdx = p;
                match = s;
                p++;
            }
            // last pattern pointer was *, advancing string pointer
            else if (starIdx != -1) {
                p = starIdx + 1;
                match++;
                s = match;
            }
            //current pattern pointer is not star, last patter pointer was not *
            //characters do not match
            else return false;
        }

        //check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;

        return p == pattern.length();
    }

    @Test
    public void test() {
        //System.out.println("Hello World!");
        String str = "adceb";
        String pattern = "*a*b";

        boolean result = this.comparison(str, pattern);
        System.out.println("result: " + result);
    }
}
