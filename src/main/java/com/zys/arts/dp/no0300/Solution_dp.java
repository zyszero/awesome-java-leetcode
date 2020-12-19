package com.zys.arts.dp.no0300;

/**
 * @author zys
 * @date 2020-11-30 15:00
 */
public class Solution_dp {
    /**
     * 写状态转移方程
     * fn = max(fi) + 1 其中i<n 且 i < n, 且|nums[i]| < |nums[n]|
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
}
