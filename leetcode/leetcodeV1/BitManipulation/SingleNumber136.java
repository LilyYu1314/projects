package BitManipulation;

import org.junit.Test;

//known that A XOR A = 0 and the XOR operator is commutative, the solution will be very straightforward.
//一个数和0异或还是自己，一个数和自己异或是0
public class SingleNumber136 {
    int singleNumber(int A[], int n) {
        int result = 0;
        for (int i = 0; i<n; i++)
        {
            result ^=A[i];
        }
        return result;
    }

    @Test
    public  void test() {
        //System.out.println("Hello World!");
        int A[] = {4,1,2,1,2};
        int result = this.singleNumber(A,A.length);
        System.out.println("result: "+result);
    }
}
