package com.zys.arts.tree.offer53_1;

public class Solution {
    public int search(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                sum++;
            }
        }
        return sum;
    }
}
