package DynamicProgramming;

import org.junit.Test;

public class DecodeWays91 {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[] memo = new int[n + 1];
        memo[n] = 1;
        memo[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;

        for (int i = n - 2; i >= 0; i--)
            if (s.charAt(i) == '0') continue;
            else memo[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? memo[i + 1] + memo[i + 2] : memo[i + 1];

        return memo[0];
    }

    @Test
    public void test() {
        //System.out.println("Hello World!");
        String s = "226";
        int result = this.numDecodings(s);
        System.out.println("result: " + result);
    }
}
