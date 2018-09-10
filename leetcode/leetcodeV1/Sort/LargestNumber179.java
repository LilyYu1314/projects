package Sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber179 {

    //Approach #1 Sorting via Custom Comparator [Accepted]
    private class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }

    public String largestNumber(int[] nums) {
        // Get input integers as strings.
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
            System.out.println(" asStrs[i] "+ asStrs[i] );
        }

        // Sort strings according to custom comparator.
        Arrays.sort(asStrs, new LargerNumberComparator());

        // If, after being sorted, the largest number is `0`, the entire number
        // is zero.
        if (asStrs[0].equals("0")) {
            return "0";
        }

        // Build largest number from sorted array.
        String largestNumberStr = new String();
        for (String numAsStr : asStrs) {
            largestNumberStr += numAsStr;
        }

        return largestNumberStr;
    }

    @Test
    public  void test() {
        int[] nums = {3,30,34,5,9};
        String result = this.largestNumber(nums);
        System.out.println("result: "+result);
    }
}
