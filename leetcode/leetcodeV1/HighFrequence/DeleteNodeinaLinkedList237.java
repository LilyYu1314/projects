package HighFrequence;

public class DeleteNodeinaLinkedList237 {
    //Approach: Swap with Next Node [Accepted]
    //Time and space complexity are both O(1)O(1).
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
