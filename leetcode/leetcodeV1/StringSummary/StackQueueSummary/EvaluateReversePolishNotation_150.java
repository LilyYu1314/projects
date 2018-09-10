package StringSummary.StackQueueSummary;

import java.util.Stack;

public class EvaluateReversePolishNotation_150 {
    // After all operations are done through, the remaining element in the stack will be the result.

    public int evalRPN(String[] tokens) {
        int a, b;
        Stack<Integer> S = new Stack<Integer>();

        for (String s : tokens) {
            if (s.equals("+")) {
                S.add(S.pop() + S.pop());
            } else if (s.equals("/")) {
                b = S.pop();
                a = S.pop();
                S.add(a / b);
            } else if (s.equals("*")) {
                S.add(S.pop() * S.pop());
            } else if (s.equals("-")) {
                b = S.pop();
                a = S.pop();
                S.add(a - b);
            } else {
                S.add(Integer.parseInt(s));
            }
        }

        return S.pop();
    }
}
