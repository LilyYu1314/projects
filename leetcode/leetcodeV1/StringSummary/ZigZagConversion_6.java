package StringSummary;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion_6 {
    //https://leetcode.com/articles/zigzag-conversion/

    //Approach 1: Sort by Row
    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();

        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            System.out.println("c: "+c);
            System.out.println("curRow: "+curRow);
            System.out.println("numRows - 1: "+(numRows - 1));
            System.out.println();
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
    //Complexity Analysis
    //
    //Time Complexity: O(n)O(n), where n == \text{len}(s)n==len(s)
    //Space Complexity: O(n)O(n)
    @Test
    public  void test() {
        String s = "PAYPALI";  int numRows = 3;
        String result  = convert(s, numRows);
        System.out.println("result: "+result);
    }






    //Approach 2: Visit by Row
    public String convertSec(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
    //Complexity Analysis
    //
    //Time Complexity: O(n)O(n), where n == \text{len}(s)n==len(s). Each index is visited once.
    //Space Complexity: O(n)O(n). For the cpp implementation, O(1)O(1) if return string is not considered extra space.
}
