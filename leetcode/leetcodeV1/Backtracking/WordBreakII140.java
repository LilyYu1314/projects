package Backtracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreakII140 {

    //Approach 2: Recursion with memoization
    public List<String> wordBreak(String s, Set<String> wordDict) {
        return word_Break(s, wordDict, 0);
    }

    HashMap<Integer, List<String>> map = new HashMap<>();

    public List<String> word_Break(String s, Set<String> wordDict, int start) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        LinkedList<String> res = new LinkedList<>();
        if (start == s.length()) {
            res.add("");
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                List<String> list = word_Break(s, wordDict, end);
                for (String l : list) {
                    res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
                }
            }
        }
        map.put(start, res);
        return res;
    }

    //**********************************************************************
    //Approach 3: Using Dynamic Programming
        public List<String> wordBreakSec(String s, Set<String> wordDict) {
            LinkedList<String>[] dp = new LinkedList[s.length() + 1];
            LinkedList<String> initial = new LinkedList<>();
            initial.add("");
            dp[0] = initial;
            for (int i = 1; i <= s.length(); i++) {
                LinkedList<String> list = new LinkedList<>();
                for (int j = 0; j < i; j++) {
                    if (dp[j].size() > 0 && wordDict.contains(s.substring(j, i))) {
                        for (String l : dp[j]) {
                            list.add(l + (l.equals("") ? "" : " ") + s.substring(j, i));
                        }
                    }
                }
                dp[i] = list;
            }
            return dp[s.length()];
        }
}
