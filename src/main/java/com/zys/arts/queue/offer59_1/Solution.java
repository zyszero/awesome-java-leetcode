package com.zys.arts.queue.offer59_1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zys
 * @date 2020-12-18 11:28
 */
public class Solution {
    /**
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 边界条件要再考虑全面一点
        if (nums == null || nums.length == 0){
            return nums;
        }
        List<Integer> list = new ArrayList<>();
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - k; i++) {
            for (int j = i; j < i + k; j++) {
                ans = Math.max(ans, nums[j]);
            }
            list.add(ans);
            // 需要进行重置
            ans = Integer.MIN_VALUE;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
