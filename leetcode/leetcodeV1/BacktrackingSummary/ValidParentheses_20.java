package BacktrackingSummary;

import java.util.Stack;

public class ValidParentheses_20 {

    public boolean isValid(String s) {
        if (s.length() % 2 == 1)
            return false;

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
}
