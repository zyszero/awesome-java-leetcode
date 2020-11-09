package com.zys.arts.tree.no0704;

/**
 * @author zys
 * @date 2020-07-27 10:47
 */
public class BinarySearch_1 {
    /**
     * DP
     * 去除递归
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int e = nums.length - 1, s = 0;

        while (e >= s) {
            int mid = (e + s) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return -1;
    }
}
