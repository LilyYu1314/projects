package DPSummary;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class WordBreak_139 {

    public boolean wordBreak(String s, Set<String> dict) {

        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;

        //Second DP
        for (int i = 1; i <= s.length(); i++) {

            for (int j = 0; j < i; j++) {
                if (f[j] && dict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }

        }

        return f[s.length()];
    }

    @Test
    public void test() {
        String s = "leetcode";
        Set<String> dict = new HashSet<String>() {{
            add("leet");
            add("code");
        }};

        boolean result = wordBreak(s, dict);
        System.out.println("result: " + result);

    }
}
