package com.zys.arts.array;

import java.util.Arrays;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Example 1:
 * <p>
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [4,1,2,1,2]
 * Output: 4
 *
 * @Author: Created by zys
 * @Description:
 * @Date: 2019/5/7 23:37
 * @Modified By:
 */
public class SingleNumber {
    public int singleNumber1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        if (nums[0] != nums[1]) {
            return nums[0];
        }


        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1] && nums[i] != nums[i - 1]) {
                return nums[i];
            }
        }

        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            return nums[nums.length - 1];
        }

        return 0;
    }

    public int singleNumber2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        if (nums[0] != nums[1]) {
            return nums[0];
        }


        for (int i = 2; i < nums.length - 1; i += 2) {
            System.out.println(i);
            if (i != nums.length - 1 && nums[i] != nums[i + 1] && nums[i] != nums[i - 1]) {
                return nums[i];
            }
        }

        return nums[nums.length - 1];
    }

    /**
     * 哇，这个解法完全没想到，打开新世界的大门
     * 使用 XOR 逻辑异或 去做
     * 0 ^ N = N
     * N ^ N = 0
     * 所以只需遍历进行异或，就能得到那个唯一的不同值
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;

    }

    public static void main(String[] args) {
        int[] test = new int[]{17, 12, 5, -6, 12, 4, 17, -5, 2, -3, 2, 4, 5, 16, -3, -4, 15, 15, -4, -5, -6};
//        System.out.println(singleNumber(test));
    }
}
