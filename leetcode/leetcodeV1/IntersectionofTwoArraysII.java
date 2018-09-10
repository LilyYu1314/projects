import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class IntersectionofTwoArraysII {
    /*What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

    If only nums2 cannot fit in memory, put all elements of nums1 into a HashMap, read chunks of array that fit into the memory, and record the intersections.

    If both nums1 and nums2 are so huge that neither fit into the memory, sort them individually (external sort), then read 2 elements from each array at a time in memory, record intersections.*/

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < nums1.length; i++)
        {
            if(map.containsKey(nums1[i])) map.put(nums1[i], map.get(nums1[i])+1);
            else map.put(nums1[i], 1);
            System.out.println("nums1[i]: "+nums1[i]);
            System.out.println("map.get(nums1[i]): "+map.get(nums1[i]));
        }
        System.out.println();

        for(int i = 0; i < nums2.length; i++)
        {
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0)
            {
                result.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i])-1);
            }
            System.out.println("nums2[i]: "+nums2[i]);
            System.out.println("map.get(nums2[i]): "+map.get(nums2[i]));
        }

        System.out.println();

        int[] r = new int[result.size()];
        for(int i = 0; i < result.size(); i++)
        {
            r[i] = result.get(i);
            System.out.println(" r[i]: "+ r[i]);
        }

        return r;
    }

    @Test
    public  void test() {
        //System.out.println("Hello World!");
        int[] nums1  = {1, 2, 2, 1};
        int[] nums2   = {2, 2};
        this.intersect(nums1,nums2);
    }
}
