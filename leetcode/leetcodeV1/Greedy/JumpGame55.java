package Greedy;

       /*Once we have our code in the bottom-up state, we can make one final, important observation. From a given position, when we try to see if we can jump to a GOOD position, we only ever use one - the first one (see the break statement). In other words, the left-most one.
        If we keep track of this left-most GOOD position as a separate variable, we can avoid searching for it in the array. Not only that, but we can stop using the array altogether.

        Iterating right-to-left, for each position we check if there is a potential jump that reaches a GOOD index (currPosition + nums[currPosition] >= leftmostGoodIndex).
        If we can reach a GOOD index, then our position is itself GOOD. Also, this new GOOD position will be the new leftmost GOOD index. Iteration continues until the beginning of the array.
        If first position is a GOOD index then we can reach the last index from the first position.

        To illustrate this scenario, we will use the diagram below, for input array nums = [9, 4, 2, 1, 0, 2, 0]. We write G for GOOD, B for BAD and U for UNKNOWN.
        Let's assume we have iterated all the way to position 0 and we need to decide if index 0 is GOOD.
        Since index 1 was determined to be GOOD, it is enough to jump there and then be sure we can eventually reach index 6.
        It does not matter that nums[0] is big enough to jump all the way to the last index. All we need is one way.*/

//solution,Approach 4: Greedy
public class JumpGame55 {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
