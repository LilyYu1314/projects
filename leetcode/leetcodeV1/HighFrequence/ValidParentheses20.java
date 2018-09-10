package HighFrequence;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

//所以时间复杂度空间复杂度
public class ValidParentheses20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }


    //Similar, fast solution
    boolean isValidSec(String s) {
        if ((s.length() & 1) == 1) return false;
        else {
            Deque<Character> p = new ArrayDeque<>(s.length());
            for (int i = 0; i < s.length(); i++)
                switch (s.charAt(i)) {
                    case '(':
                        p.push(')');
                        break;
                    case '{':
                        p.push('}');
                        break;
                    case '[':
                        p.push(']');
                        break;
                    case ')':
                    case '}':
                    case ']':
                        if (p.isEmpty() || p.pop() != s.charAt(i)) return false;
                }
            return p.isEmpty();
        }
    }
}
