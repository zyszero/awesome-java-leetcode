package com.zys.arts.stack.no0503;

import java.util.Arrays;

/**
 * @author zys
 * @date 2020-08-04 16:02
 */
public class Solution_1 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        int[] stack = new int[n];
        int p = -1;
        for (int i = 0; i < 2 * n; i++) {
            int pos = i % n;
            while (p >= 0 && nums[stack[p]] < nums[pos]) {
                res[stack[p--]] = nums[pos];
            }
            if (i < n) {
                stack[++p] = i;
            }
        }
        return res;
    }
}
