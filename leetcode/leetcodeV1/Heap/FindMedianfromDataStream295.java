package Heap;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;


//I keep two heaps (or priority queues):
//Max-heap small has the smaller half of the numbers.
//Min-heap large has the larger half of the numbers.
//This gives me direct access to the one or two middle values (they're the tops of the heaps),
// so getting the median takes O(1) time. And adding a number takes O(log n) time.
public class FindMedianfromDataStream295 {

    private Queue<Long> small = new PriorityQueue(), large = new PriorityQueue();

    public void addNum(int num) {
        large.add((long) num);
        small.add(-large.poll());
        if (large.size() < small.size())
            large.add(-small.poll());
    }

    public double findMedian() {
        return large.size() > small.size() ? large.peek() : (large.peek() - small.peek()) / 2.0;
    }


    @Test
    public void test() {
        addNum(1);
        addNum(2);
        double result = findMedian();
        System.out.println("result: " + result);
        addNum(3);
        result = findMedian();
        System.out.println("result: " + result);
    }
}
