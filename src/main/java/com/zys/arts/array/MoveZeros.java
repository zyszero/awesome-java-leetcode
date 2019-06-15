package com.zys.arts.array;

import java.util.Arrays;

/**
 * @decription:
 * @author: zys
 * @date: 2019/6/2 1:28
 */
public class MoveZeros {
    /**
     * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     * <p>
     * Example:
     * <p>
     * Input: [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     * Note:
     * <p>
     * You must do this in-place without making a copy of the array.
     * Minimize the total number of operations.
     *
     * @param nums
     */
    public static void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                continue;
            }
            int curr = i;
            for (int j = i + 1; j < length; j++) {
                if (nums[curr] != nums[j]) {
                    nums[curr] = nums[j];
                    nums[j] = 0;
                    curr = j;
                }
            }
            length--;
        }
    }

    public static void moveZeroes(int[] nums) {
        // 边界条件
        if (nums == null || nums.length == 0) {
            return;
        }
        // 设置一个锚点，从 0 开始
        int anchor = 0;
        // 遍历输入数组
        for (int num : nums) {
            // 判断当前元素是否为非零元素
            if (num != 0) {
                //不为零，则用当前的值覆盖锚点对应的数组的值，并将锚点往前移动一位
                nums[anchor++] = num;
            }
            // 为零，锚点不移动，数组继续遍历，依次类推，就能实现非零元素覆盖 0 元素
        }
        // 经过上述遍历覆盖之后，锚点之前，皆为非零元素，锚点之后，应该全为零
        while (anchor < nums.length) {
            nums[anchor++] = 0;
        }
    }


    public static void main(String[] args) {
        int[] test = new int[]{0, 0, 1};
        moveZeroes(test);
        System.out.println(Arrays.toString(test));
    }
}
