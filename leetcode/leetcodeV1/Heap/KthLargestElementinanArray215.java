package Heap;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementinanArray215 {
    //O(N lg N) running time + O(1) memory
    //The simplest approach is to sort the entire input array and then access the element by it's index (which is O(1)) operation:
    public int findKthLargest(int[] nums, int k) {
        final int N = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < N; i++) {
            System.out.println("nums[i]: " + nums[i]);
        }
        return nums[N - k];
    }

    @Test
    public void test() {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int result = this.findKthLargest(nums, 4);
        System.out.println("result: " + result);
    }

    //O(N lg K) running time + O(K) memory
    //Other possibility is to use a min oriented priority queue that will store the K-th largest values.
    // The algorithm iterates over the whole input and maintains the size of priority queue.
    public int findKthLargestSec(int[] nums, int k) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : nums) {
            pq.offer(val);

            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
