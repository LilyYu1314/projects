package Sort;

import java.util.Arrays;

public class WiggleSortII324 {

    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int len = nums.length;
        int median = findMedian(0, len - 1, len / 2, nums);
        int left = 0, right = len - 1, i = 0;
        // map current index firstly
        while (i <= right) {
            int mappedCurIndex = newIndex(i, len);
            if (nums[mappedCurIndex] > median) {
                int mappedLeftIndex = newIndex(left, len);
                swap(mappedLeftIndex, mappedCurIndex, nums);
                left++;
                i++;
            } else if (nums[mappedCurIndex] < median) {
                int mappedRightIndex = newIndex(right, len);
                swap(mappedCurIndex, mappedRightIndex, nums);
                right--;
            } else {
                i++;
            }
        }
    }

    // {0,1,2,3,4,5} -> {1,3,5,0,2,4}
    // find mapped new inde
    public int newIndex(int index, int len) {
        return (1 + 2 * index) % (len | 1);
    }

    // use quicksort, average O(n) time
    public int findMedian(int start, int end, int k, int[] nums) {
        if (start > end) return Integer.MAX_VALUE;
        int pivot = nums[end];
        int indexOfWall = start;
        for (int i = start; i < end; i++) {
            if (nums[i] <= pivot) {
                swap(i, indexOfWall, nums);
                indexOfWall++;
            }
        }
        swap(indexOfWall, end, nums);
        if (indexOfWall == k) {
            return nums[indexOfWall];
        } else if (indexOfWall < k) {
            return findMedian(indexOfWall + 1, end, k, nums);
        } else {
            return findMedian(start, indexOfWall - 1, k, nums);
        }
    }

    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //Your solution is excellent! I use more space (O(n) extra space,O(n) time) and it's easier to understand.
    public void wiggleSortSec(int[] nums) {
        int median = findKthLargest(nums, (nums.length + 1) / 2);
        int odd = 1;
        int even = nums.length % 2 == 0 ? nums.length - 2 : nums.length - 1;
        int[] tmpArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > median) {
                tmpArr[odd] = nums[i];
                odd += 2;
                continue;
            }
            if (nums[i] < median) {
                tmpArr[even] = nums[i];
                even -= 2;
                continue;
            }
        }
        while (odd < nums.length) {
            tmpArr[odd] = median;
            odd += 2;
        }
        while (even >= 0) {
            tmpArr[even] = median;
            even -= 2;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = tmpArr[i];
        }
    }

    public int findKthLargest(int[] nums, int k) {
        final int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
    }
}
