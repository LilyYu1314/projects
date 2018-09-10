package NodeSummary;

public class OddEvenLinkedList_328 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }
    //Complexity Analysis
    //Time complexity : O(n)O(n). There are total nn nodes and we visit each node once.
    //
    //Space complexity : O(1)O(1). All we need is the four pointers.
}
