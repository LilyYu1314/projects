package HighFrequence;

import java.util.LinkedList;
import java.util.Stack;

public class SimplifyPath71 {

    //Derived from shpolsky's code, using LinkedList and StringBuilder
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder("/");
        LinkedList<String> stack = new LinkedList<String>();

        for (String s : path.split("/")) {
            if (s.equals("..")) {
                if (!stack.isEmpty())
                    stack.removeLast();
            } else if (!s.equals("") && !s.equals("."))
                stack.add(s);
        }

        for (String s : stack) {
            sb.append(s + "/");
        }

        if (!stack.isEmpty()) sb.setLength(sb.length() - 1);
        return sb.toString();
    }


    //Now we can join string in stack
    public String simplifyPathSec(String path) {
        Stack<String> stack = new Stack();

        for (String cur : path.split("/")) {
            if (cur.equals("..")) {
                if (!stack.empty()) stack.pop();
            } else if (cur.length() > 0 && !cur.equals(".")) stack.push(cur);
        }

        return "/" + String.join("/", stack);
    }

}
