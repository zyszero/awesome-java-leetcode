package com.zys.arts.array.no0169;

/**
 * @author zys
 * @date 2020-12-02 20:51
 */
public class Solution_1 {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
            }
            count += candidate == nums[i] ? 1 : -1;
        }
        return candidate;
    }
}
