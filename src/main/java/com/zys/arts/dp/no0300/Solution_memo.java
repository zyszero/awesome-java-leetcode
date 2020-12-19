package com.zys.arts.dp.no0300;

import java.util.Arrays;

/**
 * @author zys
 * @date 2020-11-30 14:47
 */
public class Solution_memo {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return f(nums, nums.length, dp);
    }

    public int f(int[] nums, int i, int[] dp) {
        if (dp[i] != -1) {
            return dp[i];
        }
        int a = 1;
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                a = Math.max(a, f(nums, j, dp) + 1);
            }
        }
        dp[i] = a;
        return dp[i];
    }
}
