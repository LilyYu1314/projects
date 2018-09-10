package HighFrequence;

public class LinkedListCycle141 {
    //Approach 2: Two Pointers
    //Time complexity : O(n)O(n). Let us denote nn as the total number of nodes in the linked list.
    // To analyze its time complexity, we consider the following two cases separately.
    //Space complexity : O(1)O(1). We only use two nodes (slow and fast) so the space complexity is O(1)O(1).

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
