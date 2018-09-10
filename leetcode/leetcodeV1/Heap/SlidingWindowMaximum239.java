package Heap;

import org.junit.Test;

import java.util.LinkedList;

public class SlidingWindowMaximum239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return nums;
        }
        int[] result = new int[n - k + 1];
        LinkedList<Integer> dq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!dq.isEmpty() && dq.peek() < i - k + 1) {
                dq.poll();
            }
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                System.out.println("dq.peekLast(): "+dq.peekLast());
                System.out.println("nums[dq.peekLast()]: "+nums[dq.peekLast()]);
                System.out.println();
                dq.pollLast();
            }
            dq.offer(i);
            if (i - k + 1 >= 0) {
                result[i - k + 1] = nums[dq.peek()];
            }
        }
        return result;
    }


    @Test
    public  void test() {
        //System.out.println("Hello World!");
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        int[] result = this.maxSlidingWindow(nums,k);

        for(int i=0;i<result.length;i++){
            //System.out.println("[i]: " + result[i]);
        }
    }
}
