package HighFrequence;

public class ClimbingStairs70 {
    //Approach 3: Dynamic Programming
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    //Time complexity : O(n)O(n). Single loop upto nn.
    //Space complexity : O(n)O(n). dpdp array of size nn is used.


    //Approach 2: Recursion with memorization
        public int climbStairsSec(int n) {
            int memo[] = new int[n + 1];
            return climb_Stairs(0, n, memo);
        }

        public int climb_Stairs(int i, int n, int memo[]) {
            if (i > n) {
                return 0;
            }
            if (i == n) {
                return 1;
            }
            if (memo[i] > 0) {
                return memo[i];
            }
            memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
            return memo[i];
        }

    //Time complexity : O(n)O(n). Size of recursion tree can go upto nn.
    //
    //Space complexity : O(n)O(n). The depth of recursion tree can go upto nn.
}
