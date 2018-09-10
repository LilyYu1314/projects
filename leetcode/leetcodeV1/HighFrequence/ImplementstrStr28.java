package HighFrequence;

import org.junit.Test;

public class ImplementstrStr28 {
    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }


    @Test
    public  void test() {
        //System.out.println("Hello World!");
        String haystack= "loveleetcode", needle = "lee";
        int result  = this.strStr(haystack, needle);
    }
}
