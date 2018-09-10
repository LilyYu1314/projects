import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class LongestSubstringwithAtMostKDistinctCharacters {
    //feel it is not a new question, just use num to track the number of distinct characters within the slide window
        public int lengthOfLongestSubstringKDistinct1(String s, int k) {
            int[] count = new int[256];
            int num = 0, i = 0, res = 0;
            for (int j = 0; j < s.length(); j++) {
                if (count[s.charAt(j)]++ == 0) num++;
                System.out.println("num: "+num);
                System.out.println("count[s.charAt(j++)]:   "+ count[s.charAt(j)]);
                if (num > k) {
                    System.out.println("num > k:    "+ (num > k));
                    while (--count[s.charAt(i++)] > 0);
                    System.out.println("count[s.charAt(i++)]:   "+ count[s.charAt(i)]);
                    num--;
                }
                System.out.println("res:    "+res);
                System.out.println("j - i + 1:  "+ (j - i + 1));
                res = Math.max(res, j - i + 1);
            }
            return res;
        }


    //A more generic solution as follows, can be solution for Unicode string:
    public int lengthOfLongestSubstringKDistinct2(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int best = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.size() > k) {
                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) - 1);
                    if (map.get(leftChar) == 0) {
                        map.remove(leftChar);
                    }
                }
                left++;
            }
            best = Math.max(best, i - left + 1);
        }
        return best;
    }


    //Simplified the code a bit. Made the sliding window a bit more readable :)
    public int lengthOfLongestSubstringKDistinct3(String s, int k) {
        int[] count = new int[256];     // there are 256 ASCII characters in the world

        int i = 0;  // i will be behind j
        int num = 0;
        int res = 0;

        for (int j = 0; j < s.length(); j++) {
            if (count[s.charAt(j)]++ == 0) {    // if count[s.charAt(j)] == 0, we know that it is a distinct character
                num++;
            }
            while (num > k && i < s.length()) {     // sliding window
                count[s.charAt(i)]--;
                if (count[s.charAt(i)] == 0){
                    num--;
                }
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }

    @Test
    public  void test() {
        //System.out.println("Hello World!");
        String S= "eceba"; int k = 2;
        this.lengthOfLongestSubstringKDistinct1(S,k);
    }
}
