package MathSummary.ArraySummary;

public class RemoveDuplicatesfromSortedArray_26 {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
    //Time complextiy : . Assume that is the length of array. Each of and traverses at most steps.
    //
    //Space complexity : .
}
