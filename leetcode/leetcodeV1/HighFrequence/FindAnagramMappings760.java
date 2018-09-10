package HighFrequence;

import java.util.HashMap;
import java.util.Map;

public class FindAnagramMappings760 {
    //Approach #1: Hash Table [Accepted]

    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, Integer> D = new HashMap();
        for (int i = 0; i < B.length; ++i)
            D.put(B[i], i);

        int[] ans = new int[A.length];
        int t = 0;
        for (int x : A)
            ans[t++] = D.get(x);
        return ans;
    }

    //Complexity Analysis
    //Time Complexity: O(N)O(N), where NN is the length of AA.
    //Space Complexity: O(N)O(N).
}
