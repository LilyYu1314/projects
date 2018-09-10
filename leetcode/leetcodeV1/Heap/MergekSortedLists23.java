package Heap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergekSortedLists23 {

    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val)
                    return -1;
                else if (o1.val == o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (ListNode node : lists)
            if (node != null){
                queue.add(node);
                System.out.println("node.val: "+node.val);
            }

        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            System.out.println(" tail.next.val: "+ tail.next.val);
            tail = tail.next;

            if (tail.next != null)
                queue.add(tail.next);
        }
        return dummy.next;
    }

    @Test
    public  void test() {
        //System.out.println("Hello World!");
        ListNode first = new ListNode(1);
        first.next = new ListNode(4);
        first.next.next = new ListNode(5);

        ListNode second = new ListNode(1);
        second.next = new ListNode(3);
        second.next.next = new ListNode(4);

        ListNode third = new ListNode(2);
        third.next = new ListNode(6);

        List<ListNode> lists = new ArrayList<>();
        lists.add(first);  lists.add(second);  lists.add(third);

        ListNode result = this.mergeKLists(lists);
        System.out.println("result: "+result.val);
    }
}
