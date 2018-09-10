package StringSummary.StackQueueSummary;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

//both solutions have a O(n) time complexity
public class LongestAbsoluteFilePath_388 {
    //An even shorter and faster solution using array instead of stack:
    public int lengthLongestPath(String input) {
        String[] paths = input.split("\n");
        int[] stack = new int[paths.length + 1];
        int maxLen = 0;

        for (String s : paths) {
            int lev = s.lastIndexOf("\t") + 1,
                    curLen = stack[lev + 1] = stack[lev] + s.length() - lev + 1;
            if (s.contains(".")) maxLen = Math.max(maxLen, curLen - 1);

            System.out.println("s: " + s);
            System.out.println("stack[lev]: " + stack[lev]);
            System.out.println("lev: " + lev);
            System.out.println("curLen: " + curLen);
            System.out.println();
        }

        return maxLen;
    }

    @Test
    public void test() {
        String TAB = "\t";
        System.out.println(TAB.length()); // returns 1

        String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        int result = lengthLongestPath(input);

    }



    public int lengthLongestPathSec(String input) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0); // "dummy" length
        int maxLen = 0;
        for (String s : input.split("\n")) {
            int lev = s.lastIndexOf("\t") + 1; // number of "\t"
            while (lev + 1 < stack.size()) stack.pop(); // find parent
            int len = stack.peek() + s.length() - lev + 1; // remove "/t", add"/"
            stack.push(len);
            // check if it is file
            if (s.contains(".")) maxLen = Math.max(maxLen, len - 1);
        }
        return maxLen;
    }



    //Slightly longer version. But I think is way easier to understand.
    public static int lengthLongestPathThird(String input) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);  // Layer 0, dummy head
        int maxLen = 0;
        for (String s : input.split("\n")) {
            int layer = s.lastIndexOf("\t") + 1;    // e.g. Layer 2 s: "\t\tsubsubdir1"
            while (layer < stack.size() - 1)
                stack.pop();
            int length = stack.peek() + s.length() - layer + 1; // remove "\t\t..." add "\"
            if (layer == 0)  // dir has no "\t" in the front
                length--;
            if (s.contains("."))
                maxLen = Math.max(maxLen, length);
            else
                stack.push(length);
        }
        return maxLen;
    }
}
