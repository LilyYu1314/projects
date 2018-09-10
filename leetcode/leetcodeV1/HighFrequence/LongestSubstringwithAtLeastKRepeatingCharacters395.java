package HighFrequence;

public class LongestSubstringwithAtLeastKRepeatingCharacters395 {

    //Only 7ms for Java solution without looking for the least occurred character, i.e., split the string by any character that doesn't appear for k times.
    public int longestSubstring(String s, int k) {
        int n = s.length();
        if (n==0 || n<k) return 0;
        if (k==1) return n;
        int[] counts = new int[26];
        for (char c: s.toCharArray()) counts[c-'a']++;
        boolean valid = true;
        char badchar = 0;

        for (int i=0; i<26; i++) {
            if (counts[i]>0 && counts[i]<k) {
                badchar = (char)(i+'a');
                break;
            }
        }

        if (badchar==0) return n;
        String[] subs = s.split(badchar+"");
        int res = 0;
        for (String sub:subs) res = Math.max(res, longestSubstring(sub,k));
        return res;
    }



    //太难理解
    public int longestSubstringSec(String s, int k) {
        int d = 0;

        for (int numUniqueTarget = 1; numUniqueTarget <= 26; numUniqueTarget++)
            d = Math.max(d, longestSubstringWithNUniqueChars(s, k, numUniqueTarget));

        return d;
    }

    private int longestSubstringWithNUniqueChars(String s, int k, int numUniqueTarget) {
        int[] map = new int[128];
        int numUnique = 0; // counter 1
        int numNoLessThanK = 0; // counter 2
        int begin = 0, end = 0;
        int d = 0;

        while (end < s.length()) {
            if (map[s.charAt(end)]++ == 0) numUnique++; // increment map[c] after this statement
            if (map[s.charAt(end++)] == k) numNoLessThanK++; // inc end after this statement

            while (numUnique > numUniqueTarget) {
                if (map[s.charAt(begin)]-- == k) numNoLessThanK--; // decrement map[c] after this statement
                if (map[s.charAt(begin++)] == 0) numUnique--; // inc begin after this statement
            }

            // if we found a string where the number of unique chars equals our target
            // and all those chars are repeated at least K times then update max
            if (numUnique == numUniqueTarget && numUnique == numNoLessThanK)
                d = Math.max(end - begin, d);
        }

        return d;
    }
}
