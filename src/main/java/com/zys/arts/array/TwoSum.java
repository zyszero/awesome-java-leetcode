package com.zys.arts.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * @decription:
 * @author: zys
 * @date: 2019/6/7 10:29
 */
public class TwoSum {
    /**
     * 暴力破解，双重遍历
     *
     * @param nums   输入数组
     * @param target 目标值
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        if (nums.length < 1) {
            throw new IllegalArgumentException("No two sum solution");
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 借助散列表进行优化
     *
     * @param nums   输入数组
     * @param target 目标值
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        // 边界条件
        if (nums.length < 1) {
            throw new IllegalArgumentException("No two sum solution");
        }
        // 创建一个 HashMap
        Map<Integer, Integer> hash = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            hash.put(nums[i], i);
        }
        for (int j = 0; j < nums.length; j++) {
            int t = target - nums[j];
            if (hash.containsKey(t) && hash.get(t) != j) {
                return new int[]{j, hash.get(t)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 借助哈希表进行优化
     *
     * @param nums   输入数组
     * @param target 目标值
     * @return
     */
    public static int[] twoSum3(int[] nums, int target) {
        // 边界条件
        if (nums.length < 1) {
            throw new IllegalArgumentException("No two sum solution");
        }
        // 创建一个 HashMap，key 为数组的值，value 为值对应的数组下标
        // 用于记录遍历过的数组的值与下标，便于快速查找到所需的值
        Map<Integer, Integer> hash = new HashMap<>(16);
        // 循环遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 我们的目的是找到符合 nums[i] + nums[j] = target 的 i 和 j，t 就是 nums[j]
            int t = target - nums[i];
            // 查看 t 是否在已访问过的数组值内 即哈希表的 keys 包不包含 t，
            // 加上由于题目要求同一个元素不能使用两次，所以还需满足当前下标 i 不能与 hash.get(t) 的值一致
            // 即 hash.containsKey(t) && hash.get(t) != i
            if (hash.containsKey(t) && hash.get(t) != i) {
                return new int[]{hash.get(t), i};
            }
            // 记录已访问过的，数组的值与下标
            hash.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public static int[] twoSum(int[] nums, int target) {
        // 边界条件
        if (nums == null || nums.length < 1) {
            throw new IllegalArgumentException("No two sum solution");
        }
        int volume = 2048;
        int bitMode = volume - 1;
        int[] result = new int[volume];
        for (int i = 0; i < nums.length; i++) {
            int c = (target - nums[i]) & bitMode;
            if (result[c] != 0) {
                return new int[]{result[c] - 1, i};
            }
            result[nums[i] & bitMode] = i + 1;
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
