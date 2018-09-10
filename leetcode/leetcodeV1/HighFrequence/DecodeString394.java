package HighFrequence;

import org.junit.Test;

public class DecodeString394 {

    int i = 0;

    public String decodeString(String s) {
        int n = 0;
        StringBuilder resultSB = new StringBuilder();

        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                while (Character.isDigit(s.charAt(i))) n = n * 10 + s.charAt(i++) - '0';

                i++;    // '['
                String nestedS = decodeString(s);

                while (n > 0) {
                    resultSB.append(nestedS);
                    n--;
                }
            } else if (Character.isLetter(s.charAt(i))) resultSB.append(s.charAt(i++));
              else if (s.charAt(i++) == ']') return resultSB.toString();
        }

        return resultSB.toString();
    }


    @Test
    public void test() {
        String s = "3[a]2[bc]" ;
        String result = decodeString(s);
        System.out.println("result: "+result);
    }
}
