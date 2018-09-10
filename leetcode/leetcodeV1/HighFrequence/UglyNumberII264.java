package HighFrequence;

public class UglyNumberII264 {
    public int nthUglyNumber(int n) {
        int[] nums = new int[n + 1];
        nums[1] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        int u2 = nums[1], u3 = nums[1], u5 = nums[1];

        for (int i = 1; i <= n; i++) {
            nums[i] = Math.min(u2, Math.min(u3, u5));

            if (nums[i] == u2) u2 = nums[++i2] * 2;
            if (nums[i] == u3) u3 = nums[++i3] * 3;
            if (nums[i] == u5) u5 = nums[++i5] * 5;
        }

        return nums[n];
    }
}
