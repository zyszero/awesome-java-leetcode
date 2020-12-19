package com.zys.arts.dp.no0300;

/**
 * 300. 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * <p>
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 * @author zys
 * @date 2020-11-30 11:48
 */
public class Solution_recursion {
    /**
     * 写状态转移方程
     * fn = max(fi) + 1 其中i<n 且 i < n, 且|nums[i]| < |nums[n]|
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        return f(nums, nums.length - 1);
    }

    public int f(int[] nums, int i) {
        int a = 1;
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                a = Math.max(a, f(nums, j) + 1);
            }
        }
        return a;
    }


}
