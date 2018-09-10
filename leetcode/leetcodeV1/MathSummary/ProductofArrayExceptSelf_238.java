package MathSummary;

import org.junit.Test;

public class ProductofArrayExceptSelf_238 {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;

        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
            System.out.println("res[i - 1]: "+res[i - 1]);
            System.out.println("nums[i - 1]: "+nums[i - 1]);
            System.out.println("res[i]: "+i+res[i]);
            System.out.println();
        }

        int right = 1;

        for (int i = n - 1; i >= 0; i--) {
            System.out.println("i: "+i);
            res[i] *= right;
            right *= nums[i];
            System.out.println("res[i]: "+i+res[i]);
            System.out.println();
        }

        return res;
    }


    @Test
    public void test(){
        int[] nums  = {1,2,3,4};
        int []  result = productExceptSelf(nums);
        for(int i = 0; i< result.length;i++){
        System.out.println("result[i]: "+result[i]);
        }

    }
}
