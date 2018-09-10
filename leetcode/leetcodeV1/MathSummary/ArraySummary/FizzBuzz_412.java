package MathSummary.ArraySummary;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz_412 {
    //一般来说，对于CPU取余数的运算相对来说效率很低，上面解法避免了使用大量的求余数操作，提升了程序的性能
    public List<String> fizzBuzz(int n) {
        List<String> ret = new ArrayList<String>(n);

        for (int i = 1, fizz = 0, buzz = 0; i <= n; i++) {
            fizz++;
            buzz++;

            if (fizz == 3 && buzz == 5) {
                ret.add("FizzBuzz");
                fizz = 0;
                buzz = 0;
            } else if (fizz == 3) {
                ret.add("Fizz");
                fizz = 0;
            } else if (buzz == 5) {
                ret.add("Buzz");
                buzz = 0;
            } else {
                ret.add(String.valueOf(i));
            }
        }

        return ret;
    }
}
