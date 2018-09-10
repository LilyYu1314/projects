package HighFrequence;

import java.util.Arrays;

public class CoinChange322 {

    //Approach #3 (Dynamic programming - Bottom up) [Accepted]
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
    //Time complexity : O(S*n)O(S∗n). On each step the algorithm finds the next F(i)F(i) in nn iterations,
    //where 1\leq i \leq S1≤i≤S. Therefore in total the iterations are S*nS∗n.
    //Space complexity : O(S)O(S). We use extra space for the memoization table.


    //Approach #2 (Dynamic programming - Top down) [Accepted]
    public int coinChangeSec(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (count[rem - 1] != 0) return count[rem - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }
    //Complexity Analysis
    //Time complexity : O(S*n)O(S∗n). where S is the amount, n is denomination count.
    //In the worst case the recursive tree of the algorithm has height of SS and the algorithm solves only SS subproblems because it caches precalculated solutions in a table.
    //Each subproblem is computed with nn iterations, one by coin denomination.
    //Therefore there is O(S*n)O(S∗n) time complexity.
    //Space complexity : O(S)O(S), where SS is the amount to change We use extra space for the memoization table.
}
