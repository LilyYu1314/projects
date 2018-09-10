package HighFrequence;

import java.util.HashSet;
import java.util.Set;

//Time Complexity: O(J\text{.length} + S\text{.length}))O(J.length+S.length)).
//The O(J\text{.length})O(J.length) part comes from creating J. The O(S\text{.length})O(S.length) part comes from searching S.
//
//Space Complexity: O(J\text{.length})O(J.length).
public class JewelsandStones771 {
    public int numJewelsInStones(String J, String S) {
        Set<Character> Jset = new HashSet();
        for (char j : J.toCharArray())
            Jset.add(j);

        int ans = 0;
        for (char s : S.toCharArray())
            if (Jset.contains(s))
                ans++;
        return ans;
    }
}

