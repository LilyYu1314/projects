package G;

import java.util.HashMap;
import java.util.Map;

//The problem can be solved with a hashtable that keeps track of the keys and its values in the double linked list.
// One interesting property about double linked list is that the node can remove itself without other reference.
// In addition, it takes constant time to add and remove nodes from the head or tail.
//
//One particularity about the double linked list that I implemented is that I create a pseudo head and tail to mark the boundary,
// so that we don't need to check the NULL node during the update.
// This makes the code more concise and clean, and also it is good for the performance as well.
public class LRUCache146 {
    private int capacity = 0;
    Map<Integer, Node> map = null;
    Node head = null;
    Node tail = null;
    public LRUCache146(int capacity) {
        this.capacity = capacity;
        map = new HashMap();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        moveToFront(map.get(key));
        return map.get(key).val;

    }

    public void put(int key, int value) {
        if(capacity ==0)
            return;
        if(map.containsKey(key)){
            map.get(key).val = value;
            moveToFront(map.get(key));
        } else{
            freeSpace();
            Node n = new Node(key,value);
            map.put(key,n);
            addToFront(n);
        }
    }

    private void freeSpace(){
        if(map.size() == capacity){
            Node toRemove = head.next;
            map.remove(toRemove.key);
            Node next = toRemove.next;
            head.next = next;
            next.prev = head;
        }
    }

    private void moveToFront(Node newNode){
        Node prev = newNode.prev;
        Node next = newNode.next;
        prev.next = next;
        next.prev = prev;
        addToFront(newNode);
    }

    private void addToFront(Node newNode){
        Node prev = tail.prev;
        prev.next = newNode;
        newNode.prev = prev;
        tail.prev = newNode;
        newNode.next = tail;

    }

    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }

        public Node() {
        }
    }

    //https://www.cnblogs.com/springfor/p/3869393.html
}
