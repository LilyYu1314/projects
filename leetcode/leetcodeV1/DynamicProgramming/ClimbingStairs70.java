package DynamicProgramming;

public class ClimbingStairs70 {
    //Approach 4: Fibonacci Number
    //Time complexity : O(n)O(n). Single loop upto nn is required to calculate n
    //Space complexity : O(1)O(1). Constant space is used.
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }


    //Approach 3: Dynamic Programming
    //Time complexity : O(n)O(n). Single loop upto nn.
    //Space complexity : O(n)O(n). dpdp array of size nn is used.
    public int climbStairsSec(int n) {
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
}
