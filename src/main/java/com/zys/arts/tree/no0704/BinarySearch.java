package com.zys.arts.tree.no0704;

/**
 * Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. If target exists, then return its index, otherwise return -1.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 *  
 * <p>
 * Note:
 * <p>
 * You may assume that all elements in nums are unique.
 * n will be in the range [1, 10000].
 * The value of each element in nums will be in the range [-9999, 9999].
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 *
 * @author zys
 * @date 2020-07-27 10:27
 */
public class BinarySearch {
    /**
     * 递归的做法
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
        return binarySearch(nums, target, s, e);
    }


    public int binarySearch(int[] nums, int target, int s, int e) {
        if (e < s) {
            return -1;
        }
        // 求中间数的时候，需要注意，中间数的下标需要加上起始下标
        int mid = (e + s) / 2;
        if (nums[mid] > target) {
            return binarySearch(nums, target, s, mid - 1);
        } else if (nums[mid] < target) {
            return binarySearch(nums, target, mid + 1, e);
        } else {
            return mid;
        }
    }

}
