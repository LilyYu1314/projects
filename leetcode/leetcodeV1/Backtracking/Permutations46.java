package Backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//46, 78相似，一定搞清楚
public class Permutations46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    @Test
    public void test() {
        //System.out.println("Hello World!");
        int[] nums = {1,2,3};

        List<List<Integer>> result = this.permute(nums);
        System.out.println("result: " + result);
    }
}
