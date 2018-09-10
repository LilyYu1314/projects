package MathSummary.ArraySummary;

public class RemoveElement_27 {

    //Approach 1: Two Pointers
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
    //Complexity analysis
    //Time complexity : . Assume the array has a total of elements, both and traverse at most steps.
    //Space complexity : .



    //Approach 2: Two Pointers - when elements to remove are rare
    public int removeElementSec(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
    //Complexity analysis
    //Time complexity : . Both and traverse at most steps. In this approach, the number of assignment operation is equal to the number of elements to remove. So it is more efficient if elements to remove are rare.
    //
    //Space complexity :
}
