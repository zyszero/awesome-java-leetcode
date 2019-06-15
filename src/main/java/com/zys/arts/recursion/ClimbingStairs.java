package com.zys.arts.recursion;

/**
 * @Author: Created by zys
 * @Description:
 * @Date: 2019/3/27 23:34
 * @Modified By:
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(4));

    }

    static class Solution {
        public int climbStairs(int n) {
            int[] result = new int[n + 1];
            result[0] = 1;
            result[1] = 1;
            for (int i = 2; i <= n; i++) {
                result[i] = result[i -1] + result[i - 2];
            }
            return result[n];
        }
    }
}
