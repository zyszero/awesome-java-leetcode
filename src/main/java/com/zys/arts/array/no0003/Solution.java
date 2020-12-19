package com.zys.arts.array.no0003;

import java.util.Arrays;

/**
 * @author zys
 * @date 2020-12-04 15:02
 */
public class Solution {
    public int findRepeatNumber0(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return nums[i];
            }
        }
        return -1;
    }

    public int findRepeatNumber(int[] nums) {
        int[] map = new int[nums.length];
        Arrays.fill(map, -1);
        for (int num : nums) {
            if (map[num] != -1) {
                return num;
            }
            map[num]++;
        }
        return -1;
    }

}
