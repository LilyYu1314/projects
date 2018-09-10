package StringSummary.HashMapSummary;

import java.util.*;

public class GroupAnagrams_49 {
    //Approach 2: Categorize by Count

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];

        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");

            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }

            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }

        return new ArrayList(ans.values());
    }

    //Complexity Analysis
    //
    //Time Complexity: O(NK)O(NK), where NN is the length of strs, and KK is the maximum length of a string in strs.
    //Counting each string is linear in the size of the string, and we count every string.
    //
    //Space Complexity: O(NK)O(NK), the total information content stored in ans.
}
