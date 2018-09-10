package HighFrequence;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers728 {

        public List<Integer> selfDividingNumbers(int left, int right) {
            List<Integer> ans = new ArrayList();
            for (int n = left; n <= right; ++n) {
                if (selfDividing(n)) ans.add(n);
            }
            return ans;
        }
        public boolean selfDividing(int n) {
            for (char c: String.valueOf(n).toCharArray()) {
                if (c == '0' || (n % (c - '0') > 0))
                    return false;
            }
            return true;
        }
}
