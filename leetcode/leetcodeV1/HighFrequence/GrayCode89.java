package HighFrequence;

import java.util.LinkedList;
import java.util.List;

public class GrayCode89 {

    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1 << n; i++) result.add(i ^ i >> 1);
        return result;
    }

    //I don't know how to come up with the solution i^(i>>1), but I will try to explain why it works.
    //Adding one to a number results in flipping all the bits from the rightmost zero bit to the end, e.g. 110011 + 1 = 110100
    //In the general form, i = ...?01...1, i+1 = ...?10...0, ? represents the left bit of the rightmost zero bit,
    // the length of tailing one bits of i is the same as the length of tailing 0 bits of i+1, and the bits from the beginning to the ? are the same.
    //Then i^(i>>1) = xxx(?^0)10...0, (i+1)^((i+1)>>1) = xxx(?^1)10...0.
    // Since the bits from the beginning to the ? are the same, xxx part of both results must be same,
    // it's obvious the tailing parts of 10...0 must be same, and its length is the same as the length of tailing one bits of i,
    // so there is only one bit difference comes from (?^0) and (?^1).


    //Solution with one bit operator (easier to read):
    public List<Integer> grayCodeSec(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < Math.pow(2, n); i++)
            result.add(i ^ i / 2);
        return result;
    }
}
