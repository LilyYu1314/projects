package G;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePairs336 {

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length < 2) {
            return res;
        }
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                addPair(map, res, str1, str2, i, false);
                if (str2.length() != 0) {
                    addPair(map, res, str2, str1, i, true);
                }
            }
        }

        return res;
    }

    private void addPair(Map<String, Integer> map, List<List<Integer>> res, String str1, String str2, int index, boolean reverse) {
        if (isPalindrome(str1)) {
            String str2rev = new StringBuilder(str2).reverse().toString();

            if (map.containsKey(str2rev) && map.get(str2rev) != index) {
                List<Integer> list = new ArrayList<>();

                if (!reverse) {
                    list.add(map.get(str2rev));
                    list.add(index);
                } else {
                    list.add(index);
                    list.add(map.get(str2rev));
                }

                res.add(list);
            }

        }
    }

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left++) != str.charAt(right--)) return false;
        }
        return true;
    }

}
