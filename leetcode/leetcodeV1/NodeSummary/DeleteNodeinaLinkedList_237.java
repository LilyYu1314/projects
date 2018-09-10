package NodeSummary;

public class DeleteNodeinaLinkedList_237 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    //Complexity Analysis
    //Time and space complexity are both O(1)O(1).
}
