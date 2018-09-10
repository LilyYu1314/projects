package StringSummary;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber_17 {

    //https://leetcode.com/problems/letter-combinations-of-a-phone-number/discuss/8064/My-java-solution-with-FIFO-queue
    //时间复杂度，空间复杂度？

    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if (digits.isEmpty()) return ans;
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};//0,1,2----9
        ans.add("");

        while (ans.peek().length() != digits.length()) {
            String remove = ans.remove();  //return removeFirst(); ans = "abc"; remove = "a"; ans = "bc"
            String map = mapping[digits.charAt(remove.length()) - '0']; //digits.charAt(remove.length()) - '0' = 2
            for (char c : map.toCharArray()) {
                ans.addLast(remove + c);
            }
        }

        return ans;
    }

    //I think the time complexity should be O(Max(3, 4) ^ n)
    //For BFS, the space complexity is O(3^n) because it breads out.

    @Test
    public void test() {
        //System.out.println("Hello World!");
        String digits = "23";
        List<String> result = this.letterCombinations(digits);
        System.out.println("result: " + result);
    }



//For Space Complexity, because I'm using DFS,
//the size of that search tree is O(3n) because we go n level deep and the width of each iteration is 3/4.
    HashMap<Character, String> map = new HashMap<>();
    public List<String> letterCombinationsSec(String digits) {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        letterCombinations(res, new StringBuilder(), digits, 0);
        return res;
    }

    public void letterCombinations(List<String> res, StringBuilder sb, String digits, int pos ) {
        if (pos < 0 || pos >= digits.length()) return;

        String s = map.get(digits.charAt(pos));
        for (int i = 0; i < s.length(); i++) {
            //counter++;
            sb.append(s.charAt(i));
            if (sb.length() == digits.length()) {
                res.add(sb.toString());
            }
            letterCombinations(res, sb, digits, pos + 1);
            sb.setLength(sb.length() - 1);
        }
    }
}


// Ascii characters are actually numbers. And 0 .. 9 digits are numbers starting from decimal 48 (0x30 hexadecimal).
//  '0' is 48
//  '1' is 49
//   ...
//   '9' is 57
//   So to get the value of any character digit, you can just remove the '0', ie 48.

//   '1' - '0' => 1
//   49 -  48 => 1