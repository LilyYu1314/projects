package HighFrequence;

import java.util.Stack;

public class ReorderList143 {

    //This question is a combination of Reverse a linked list I & II. It should be pretty straight forward to do it in 3 steps :)
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        //Find the middle of the list
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
        ListNode preMiddle = p1;
        ListNode preCurrent = p1.next;
        while (preCurrent.next != null) {
            ListNode current = preCurrent.next;
            preCurrent.next = current.next;
            current.next = preMiddle.next;
            preMiddle.next = current;
        }

        //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
        p1 = head;
        p2 = preMiddle.next;
        while (p1 != preMiddle) {
            preMiddle.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = preMiddle.next;
        }
    }


    //An easily understandable solution using a stack.
    public void reorderListSec(ListNode head) {

        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }

        ListNode headCurr = head;

        int size = stack.size();
        while (stack.size() > Math.ceil((double) size / 2)) {
            ListNode next = stack.pop();
            ListNode nextNext = headCurr.next;
            next.next = null;
            headCurr.next = next;
            next.next = nextNext;
            headCurr = nextNext;
        }


        if (headCurr != null)
            headCurr.next = null;

    }

}
