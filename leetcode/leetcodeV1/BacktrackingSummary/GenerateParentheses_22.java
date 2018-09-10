package BacktrackingSummary;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {
    //Approach 3: Closure Number
    //For each closure number c, we know the starting and ending brackets must be at index 0 and 2*c + 1.
    //Then, the 2*c elements between must be a valid sequence, plus the rest of the elements must be a valid sequence.
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left : generateParenthesis(c))
                    for (String right : generateParenthesis(n - 1 - c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
    }
    //Complexity Analysis
    //Time and Space Complexity : O(\dfrac{4^n}{\sqrt{n}})O(
    //​√
    //​n
    //​4
    //​n
    //​​ ). The analysis is similar to Approach 2.


    //Approach 2: Backtracking
    //Instead of adding '(' or ')' every time as in Approach 1, let's only add them when we know it will remain a valid sequence.
    // We can do this by keeping track of the number of opening and closing brackets we have placed so far.
    //
    //We can start an opening bracket if we still have one (of n) left to place.
    //And we can start a closing bracket if it would not exceed the number of opening brackets.
    public List<String> generateParenthesisSec(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur + "(", open + 1, close, max);
        if (close < open)
            backtrack(ans, cur + ")", open, close + 1, max);
    }
    //Time Complexity : O(\dfrac{4^n}{\sqrt{n}})O(
    //​√
    //​n
    //​4
    //​n
    //​​ ). Each valid sequence has at most n steps during the backtracking procedure.
    //
    //Space Complexity : O(\dfrac{4^n}{\sqrt{n}})O(
    //​√
    //​n
    //​4
    //​n
    //​​ ), as described above, and using O(n)O(n) space to store the sequence.
}
