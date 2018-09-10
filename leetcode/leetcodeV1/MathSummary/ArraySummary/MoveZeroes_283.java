package MathSummary.ArraySummary;

import org.junit.Test;

public class MoveZeroes_283 {

    //I doubt if this solution satisfies the question, cause it demand "Minimize the total number of operations.",
    // which means no unnecessary moves.
    //
    //My code using two pointers:

    public void moveZeroesSec(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int p1 = 0, p2 = 0;
        while (p1 < nums.length) {

            while (p2 < nums.length && nums[p2] != 0) p2++;
            while (p1 < nums.length && (nums[p1] == 0 || p1 < p2)) p1++;

            if (p1 == nums.length) return;
            nums[p2] = nums[p1];
            nums[p1] = 0;
        }
    }


    //here's one that doesn't require a second loop:

    public void moveZeroes(int[] nums) {
        int nextInsert = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nextInsert] = nums[i];
                if (nextInsert++ != i) {
                    nums[i] = 0;
                }
            }
        }

       /* for (int i = 0; i < nums.length; i++) {
            System.out.println("nums[i]: "+nums[i]);
        }*/
    }

    @Test
    public void test (){
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
    }

}
