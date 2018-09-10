package Sort;

import org.junit.Test;

import java.util.Arrays;

public class ValidAnagram242 {
    //Approach #2 (Hash Table) [Accepted]
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            //System.out.println(" counter[s.charAt(i) - 'a']: "+ counter[s.charAt(i) - 'a']);
            //System.out.println(" counter[t.charAt(i) - 'a']: "+ counter[t.charAt(i) - 'a']);

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
        String s = "anagram"; String t = "nagaram";
        //s = "rat"; t = "car";

        boolean result = this.isAnagram(s,t);
        System.out.println("result: "+result);
    }

    //Approach #1 (Sorting) [Accepted]
    public boolean isAnagramSec(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}
