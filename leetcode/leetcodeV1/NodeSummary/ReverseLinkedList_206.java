package NodeSummary;

public class ReverseLinkedList_206 {
    //Approach #1 (Iterative) [Accepted]

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }
    //Complexity analysis
    //
    //Time complexity : O(n)O(n). Assume that nn is the list's length, the time complexity is O(n)O(n).
    //
    //Space complexity : O(1)O(1).
}
