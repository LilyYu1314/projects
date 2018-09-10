package HighFrequence;

public class FindtheDuplicateNumber287 {
    //Approach #3 Floyd's Tortoise and Hare (Cycle Detection) [Accepted]
    public int findDuplicate(int[] nums) {
        // Find the intersection point of the two runners.
        //Time complexity : O(n)O(n)
        //For detailed analysis, refer to Linked List Cycle II.
        //Space complexity : O(1)O(1)
        //For detailed analysis, refer to Linked List Cycle II.

        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1;
    }

}
