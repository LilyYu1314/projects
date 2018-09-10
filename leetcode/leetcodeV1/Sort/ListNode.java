package Sort;

public class ListNode {
    ListNode left, right,next;
    int val;

    public ListNode getLeft() {
        return left;
    }

    public void setLeft(ListNode left) {
        this.left = left;
    }

    public ListNode getRight() {
        return right;
    }

    public void setRight(ListNode right) {
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(ListNode left, ListNode right, int val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }

    public ListNode(ListNode left, ListNode right) {
        this.left = left;
        this.right = right;
    }
}
