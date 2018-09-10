package MathSummary;

public class ClimbingStairs_70 {
    //Approach 4: Fibonacci Number
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
//Complexity Analysis
//Time complexity : O(n)O(n). Single loop upto nn is required to calculate n^{th}n​th
//​​fibonacci number.
//Space complexity : O(1)O(1). Constant space is used.


    //Approach 3: Dynamic Programming
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
    //Complexity Analysis
    //Time complexity : O(n)O(n). Single loop upto nn.
    //
    //Space complexity : O(n)O(n). dpdp array of size nn is used.


    //Approach 6: Fibonacci Formula
    public int climbStairsThird(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int) (fibn / sqrt5);
    }
    //Complexity Analysis
    //Time complexity : O(log(n))O(log(n)). powpow method takes log(n)log(n) time.
    //
    //Space complexity : O(1)O(1). Constant space is use
}
