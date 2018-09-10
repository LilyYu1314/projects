package Heap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements347 {

    public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
            System.out.println("bucket[frequency]: "+ bucket[frequency]);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            System.out.print("pos: "+pos);
            if (bucket[pos] != null) {
                System.out.println("pos: "+pos);
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }

    @Test
    public void testTopKFrequentElements347() {
        //System.out.println("Hello World!");
        int[] nums = {1,1,1,2,2,3}; int k = 2;
        List<Integer> result= this.topKFrequent(nums,k);
        System.out.println("result: "+ result);
    }
}
