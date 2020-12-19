package com.zys.arts.array.no0169;

import java.util.Arrays;

/**
 * @author zys
 * @date 2020-12-02 20:49
 */
public class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null){
            throw new IllegalArgumentException();
        }
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
