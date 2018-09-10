package BitManipulation;

public class SumofTwoIntegers371 {
    //Use ^ and & to add two integers
    int getSum(int a, int b) {
        return b==0? a:getSum(a^b, (a&b)<<1); //be careful about the terminating condition;
    }
}
