package NodeSummary;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle_141 {
    //Approach 1: Hash Table

    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }
    //Complexity analysis
    //Time complexity : O(n)O(n). We visit each of the nn elements in the list at most once.
    // Adding a node to the hash table costs only O(1)O(1) time.
    //
    //Space complexity: O(n)O(n). The space depends on the number of elements added to the hash table, which contains at most nn elements.


    //Approach 2: Two Pointers
    public boolean hasCycleSec(ListNode head) {
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
    //Complexity analysis
    //Time complexity : O(n)O(n). Let us denote nn as the total number of nodes in the linked list.
    //
    // To analyze its time complexity, we consider the following two cases separately.
    //Therefore, the worst case time complexity is O(N+K)O(N+K), which is O(n)O(n).
    //Space complexity : O(1)O(1). We only use two nodes (slow and fast) so the space complexity is O(1)O(1).
}
