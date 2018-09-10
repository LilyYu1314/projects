package HighFrequence;

import static java.lang.Math.pow;

//所以时间空间复杂度？
public class PoorPigs458 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pigs = 0;
        while (Math.pow(minutesToTest / minutesToDie + 1, pigs) < buckets) {
            pigs += 1;
        }
        return pigs;
    }
}