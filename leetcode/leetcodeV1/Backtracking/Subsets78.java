package Backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//46, 78相似，一定搞清楚
public class Subsets78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        //System.out.println("tempList: " + tempList);
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            System.out.println("nums[i]: " + nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }


    @Test
    public void test() {
        //System.out.println("Hello World!");
        int[] nums = {1,2,3};

        List<List<Integer>> result = this.subsets(nums);
        System.out.println("result: " + result);
    }
}
