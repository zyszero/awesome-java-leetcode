package com.zys.arts.tree.no0153;

/**
 * @author zys
 * @date 2020-07-27 14:26
 */
public class FindMin_1 {
    /**
     * 二分查找，目的找到旋转点
     * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/solution/xun-zhao-xuan-zhuan-pai-lie-shu-zu-zhong-de-zui-xi/
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int s = 0, e = nums.length - 1;
        if (nums[e] > nums[0]) {
            return nums[0];
        }
        while (s <= e) {
            int mid = (s + e) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            if (nums[mid] > nums[0]) {
                s = mid + 1;
            }

            if (nums[mid] < nums[e]) {
                e = mid - 1;
            }
        }
        throw new IllegalArgumentException();
    }
}
