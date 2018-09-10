import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
            //System.out.println("n: "+n);
            //System.out.println("frequencyMap.get(n): "+frequencyMap.get(n));
        }

        for (int key : frequencyMap.keySet()) {
            System.out.println("key: "+key);
            System.out.println("frequencyMap.get(key): "+frequencyMap.get(key));
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
            System.out.println(" bucket[frequency]: "+ bucket[frequency]);
        }

        for(int i =0 ;i<bucket.length;i++){
        System.out.println("bucket[i]: "+ bucket[i]);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                //System.out.println("bucket[pos]: "+bucket[pos]);
                res.addAll(bucket[pos]);
            }
        }

        return res;
    }

    @Test
    public  void test() {
        //System.out.println("Hello World!");
        //int[] nums = {1,1,1,2,2,3};
        int[] nums = {1,1,1,2,2,3,3,3,3};
        int k = 2;
        List<Integer> res = this.topKFrequent(nums,k);
        System.out.println("res.toString(): "+res.toString());
    }
}
