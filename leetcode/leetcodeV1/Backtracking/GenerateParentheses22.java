package Backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22 {

    //Approach 2: Backtracking
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max) {
        System.out .println("cur: "+ cur);
        for(int i =0; ans != null && i<ans.size();i++){
            System.out .println("ans.get(i): "+ ans.get(i));
        }
        System.out .println();

        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur + "(", open + 1, close, max);
        if (close < open)
            backtrack(ans, cur + ")", open, close + 1, max);
    }


    //******************************************************************************
    //Approach 3: Closure Number
    public List<String> generateParenthesisSec(int n) {
        List<String> ans = new ArrayList();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left : generateParenthesisSec(c))
                    for (String right : generateParenthesisSec(n - 1 - c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
    }

    @Test
    public  void test() {
        //System.out.println("Hello World!");
        int num = 3;

        List<String>  result = this.generateParenthesis(num);
        System.out.println("result: "+result);
    }
}
