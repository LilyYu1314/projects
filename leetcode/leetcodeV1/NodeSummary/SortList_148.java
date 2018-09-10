package NodeSummary;

public class SortList_148 {
    //https://leetcode.com/problems/sort-list/discuss/46712/Bottom-to-up(not-recurring)-with-o(1)-space-complextity-and-o(nlgn)-time-complextity

    //Bottom-to-up(not recurring)  with o(1) space complextity and o(nlgn) time complextity
    ListNode dummyRes = new ListNode(0);

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        int length = length(head);

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        MergeResult mr = new MergeResult(null, null);
        for (int step = 1; step < length; step <<= 1) {
            ListNode left = dummy.next;
            ListNode prev = dummy;
            while (left != null) {
                ListNode right = split(left, step);
                if (right == null) {
                    prev.next = left;
                    break;
                }
                ListNode next = split(right, step);
                merge(left, right, mr);
                prev.next = mr.head;
                prev = mr.tail;
                left = next;
            }
        }

        return dummy.next;
    }


    public ListNode split(ListNode head, int step) {
        while (head != null && step != 1) {
            head = head.next;
            step--;
        }
        if (head == null) return null;
        ListNode res = head.next;
        head.next = null;
        return res;
    }

    public int length(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }

        return len;
    }

    public void merge(ListNode head1, ListNode head2, MergeResult mr) {
        if (head2 == null) {
            mr.head = head1;
            mr.tail = null;
        }
        ListNode res = dummyRes;
        ListNode tail = res;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }

        while (head1 != null) {
            tail.next = head1;
            head1 = head1.next;
            tail = tail.next;
        }

        while (head2 != null) {
            tail.next = head2;
            head2 = head2.next;
            tail = tail.next;
        }

        mr.head = res.next;
        mr.tail = tail;
    }
}
