package com.zys.arts.array;

import java.util.*;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author: zys
 * @date: 2019/10/27 0:18
 * @see <a href="https://leetcode.com/problems/3sum/">15. 3Sum</a>
 */
public class ThreeSum {
    /**
     * 1. 数组排序
     * <p>
     * 2. 需要满足 a+b+c = 0，那就选一个值作为c，首尾遍历剩余元素，找到对应的b和c
     * <p>
     * 注意结果组合的去重
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        // 数组排序，为了结果组合去重做准备
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            // 因为数组是排好序的，所以当最左的值为正数时，后续的值必为正数，即不符合 a+b+c = 0
            if (nums[i] > 0) {
                break;
            }
            // nums[i] != nums[i - 1] 是为了防止重复，由于数组是有序的，只需保证当前元素不等于上一个元素，即可防止结果集重复
            if (i == 0 || nums[i] != nums[i - 1]) {
                // 选出 a + b，即 -c
                int sum = -nums[i], first = i + 1, tail = nums.length - 1;
                while (first < tail) {
                    if (nums[first] + nums[tail] == sum) {
                        results.add(Arrays.asList(nums[i], nums[first], nums[tail]));
                        // 跳过重复的元素
                        while (first < tail && nums[first] == nums[first + 1]) {
                            first++;
                        }
                        while (first < tail && nums[tail] == nums[tail - 1]) {
                            tail--;
                        }
                        first++;
                        tail--;
                    } else if (nums[first] + nums[tail] > sum) {
                        // 由于是按顺序排序的，所以 c < a < b，当 a + b > -c 需要减小 b 值
                        tail--;
                    } else {
                        // 反之需要增加 a 值
                        first++;
                    }
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ThreeSum().threeSum(new int[]{0, 0, 0});
        lists.forEach(l -> System.out.println(l.toString()));
    }
}
