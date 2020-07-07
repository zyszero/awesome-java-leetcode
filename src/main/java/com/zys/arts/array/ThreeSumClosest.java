package com.zys.arts.array;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zys
 * @date 2020-07-03 14:29
 */
public class ThreeSumClosest {
    /**
     * 排序+双指针
     * 判断依据：
     * Math.abs(target - sums) 值越小，越接近目标值
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException();
        }
        Arrays.sort(nums);
        int temp = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            // 细节优化
            if (i == 0 || nums[i] != nums[i - 1]) {
                while (start < end) {
                    int sum = nums[i] + nums[start] + nums[end];
                    if (Math.abs(target - temp) > Math.abs(target - sum)) {
                        temp = sum;
                    }
                    if (sum > target) {
                        // 去重， 细节优化
                        while (end > start && nums[end] == nums[end - 1]) {
                            end--;
                        }
                        end--;
                    } else if (sum < target) {
                        // 去重， 细节优化
                        while (start < end && nums[start] == nums[start + 1]) {
                            start++;
                        }
                        start++;
                    } else {
                        return sum;
                    }
                }
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}
