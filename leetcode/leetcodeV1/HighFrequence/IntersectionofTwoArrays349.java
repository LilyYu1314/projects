package HighFrequence;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class IntersectionofTwoArrays349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                intersect.add(nums2[i]);
            }
        }

        int[] result = new int[intersect.size()];
        int i = 0;

        for (Integer num : intersect) {
            result[i++] = num;
        }

        return result;
    }


    //Two-line java 8 solution using Stream
    public int[] intersectionSec(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums1).distinct().filter(e -> set.contains(e)).toArray();
    }
}
