package com.zys.arts.array;

import java.util.HashSet;

/**
 * @author: zys
 * @date: 2020/2/4 11:21
 * @see <a href="https://leetcode.com/problems/first-missing-positive/">41. First Missing Positive</a>
 */
public class FirstMissingPositive {
    /**
     * 1. 利用HashSet的特性，不重复，且具有散列表的结构，可以快速查找数据，将数组的值放入set集合中
     * 2. 从最小正整数 1 开始遍历，因为求的是缺失的最小正整数，所以只要set集合中不存在当前遍历值，那么当前值就是所求值
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * 这种解法不符合题意，题意要求时间复杂度为O(n)，空间复杂度为常数
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive1(int[] nums) {
        HashSet<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            set.add(num);
        }
        int miss = 1;
        while (miss <= set.size() + 1) {
            if (set.contains(miss)) {
                miss++;
            } else {
                break;
            }
        }
        return miss;
    }


    /**
     * 检查 1 是否存在于数组中。如果没有，则已经完成，1 即为答案。
     * 如果 nums = [1]，答案即为 2 。
     * 将负数，零，和大于 n 的数替换为 1 。
     * 遍历数组。当读到数字 a 时，替换第 a 个元素的符号。
     * 注意重复元素：只能改变一次符号。由于没有下标 n ，使用下标 0 的元素保存是否存在数字 n。
     * 再次遍历数组。返回第一个正数元素的下标。
     * 如果 nums[0] > 0，则返回 n 。
     * 如果之前的步骤中没有发现 nums 中有正数元素，则返回n + 1。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/first-missing-positive/solution/que-shi-de-di-yi-ge-zheng-shu-by-leetcode/
     *
     * @param nums
     * @return
     */
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // 1. 判断nums有无正整数1
        boolean contains = false;
        for (int num : nums) {
            if (num == 1) {
                contains = true;
                break;
            }
        }
        if (!contains) {
            return 1;
        }
        if (n == 1) {
            return 2;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }
        // 以数组索引作为哈希键，数组值的元素符号作为哈希值，来实现值是否存在的检测
        for (int i = 0; i < nums.length; i++) {
            int a = Math.abs(nums[i]);
            if (a == n) {
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[a] = -Math.abs(nums[a]);
            }
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }

        if (nums[0] > 0) {
            return n;
        }

        return n + 1;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
    }
}
