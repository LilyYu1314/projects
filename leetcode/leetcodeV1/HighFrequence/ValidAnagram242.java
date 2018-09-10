package HighFrequence;

import org.junit.Test;

public class ValidAnagram242 {
    //Approach #2 (Hash Table) [Accepted]
    //Time complexity : O(n)O(n). Time complexity is O(n)O(n) because accessing the counter table is a constant time operation.
    //
    //Space complexity : O(1)O(1). Although we do use extra space,
    // the space complexity is O(1)O(1) because the table's size stays constant no matter how large nn is.

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public  void test() {
        //System.out.println("Hello World!");
        String s= "anagram", t = "nagaram";
        boolean isAnagram  = this.isAnagram(s, t);
    }



    //Or we could first increment the counter for ss, then decrement the counter for tt.
    // If at any point the counter drops below zero, we know that tt contains an extra letter not in ss and return false immediately.

    public boolean isAnagramSec(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
