package com.zys.arts.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate quadruplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * <p>
 * A solution set is:
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 *
 * @author zys
 * @date 2020-07-06 12:48
 */
public class FourSum {
    /**
     * 思路与ThreeSum一致，排序+双指针
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > Math.abs(target)) {
                break;
            }
            if (i == 0 || nums[i] != nums[i - 1]) {
                int tempTarget = target - nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] > Math.abs(tempTarget)) {
                        break;
                    }
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        int start = j + 1, end = nums.length - 1;
                        while (start < end) {
                            int sum = nums[j] + nums[start] + nums[end];
                            if (sum == tempTarget) {
                                result.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                                while (start < end && nums[start] == nums[start + 1]) {
                                    start++;
                                }
                                while (start < end && nums[end] == nums[end - 1]) {
                                    end--;
                                }
                                start++;
                                end--;
                            } else if (sum > tempTarget) {
                                end--;
                            } else {
                                start++;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
