package HighFrequence;

public class RemoveNthNodeFromEndofList19 {

    //Approach 2: One pass algorithm
    //Time complexity : O(L)O(L).
    //The algorithm makes one traversal of the list of LL nodes. Therefore time complexity is O(L)O(L).
    //Space complexity : O(1)O(1).
    //We only used constant extra space.
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }


    //Approach 1: Two pass algorithm
    //Time complexity : O(L)O(L).
    //The algorithm makes two traversal of the list, first to calculate list length LL and second to find the (L - n)(L−n) th node.
    // There are 2L-n2L−n operations and time complexity is O(L)O(L).
    //Space complexity : O(1)O(1).
    //We only used constant extra space.
    public ListNode removeNthFromEndSec(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }
}
