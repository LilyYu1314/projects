package DynamicProgramming;

import org.junit.Test;

import java.util.*;

public class WordBreak139 {
    //Approach 4: Using Dynamic Programming
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                System.out.println("s.substring(j, i): "+s.substring(j, i));
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    @Test
    public void test() {
        //System.out.println("Hello World!");
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<String>();
        wordDict.add("apple");
        wordDict.add("pen");

        boolean result = this.wordBreak(s,wordDict);
        System.out.println("result: " + result);
    }


    //Approach 3: Using Breadth-First-Search
    public boolean wordBreakSec(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start] == 0) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDictSet.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
    }
}
