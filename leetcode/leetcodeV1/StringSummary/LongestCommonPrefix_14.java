package StringSummary;

public class LongestCommonPrefix_14 {
    //Approach 1: Horizontal scanning

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }
    //Complexity Analysis
    //Time complexity : O(S)O(S) , where S is the sum of all characters in all strings.
    //In the worst case all nn strings are the same. The algorithm compares the string S1S1 with the other strings [S_2 \ldots S_n][S2…S​n]
    //There are SS character comparisons, where SS is the sum of all characters in the input array.
    //Space complexity : O(1)O(1). We only used constant extra space.


    //Approach 2: Vertical scanning
    public String longestCommonPrefixSec(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
    //Complexity Analysis
    //
    //Time complexity : O(S)O(S) , where S is the sum of all characters in all strings.
    // In the worst case there will be nn equal strings with length mm and the algorithm performs S = m*nS=m∗n character comparisons.
    // Even though the worst case is still the same as Approach 1,
    // in the best case there are at most n*minLenn∗minLen comparisons where minLenminLen is the length of the shortest string in the array.
    //Space complexity : O(1)O(1). We only used constant extra space.
}
