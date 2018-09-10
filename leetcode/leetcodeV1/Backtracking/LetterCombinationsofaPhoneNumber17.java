package Backtracking;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber17 {

    public List<String> letterCombinations(String digits) {

        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");

        while(ans.peek().length()!=digits.length()){
            System.out.println("ans.peek().length(): "+ans.peek().length());
            System.out.println("digits.length(): "+digits.length());
            String remove = ans.remove();
            System.out.println("remove: "+remove);
            System.out.println();
            String map = mapping[digits.charAt(remove.length())-'0'];
            for(char c: map.toCharArray()){
                ans.addLast(remove+c);
                System.out.println("remove+c: "+remove+c);
            }
        }

        return ans;
    }

    @Test
    public  void test() {
        //System.out.println("Hello World!");
        String digits = "23";
        List<String>  result = this.letterCombinations(digits);
        System.out.println("result: "+result);
    }
}
