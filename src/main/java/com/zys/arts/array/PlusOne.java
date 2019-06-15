package com.zys.arts.array;

import java.util.Arrays;

/**
 * @Author: Created by zys
 * @Description:
 * @Date: 2019/5/26 0:12
 * @Modified By:
 */
public class PlusOne {


    /**
     * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
     * <p>
     * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
     * <p>
     * You may assume the integer does not contain any leading zero, except the number 0 itself.
     * <p>
     * Example 1:
     * <p>
     * Input: [1,2,3]
     * Output: [1,2,4]
     * Explanation: The array represents the integer 123.
     * Example 2:
     * <p>
     * Input: [4,3,2,1]
     * Output: [4,3,2,2]
     * Explanation: The array represents the integer 4321.
     *
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        //倒序遍历
        for (int i = digits.length - 1; i >= 0; i--) {
            // 不为9，则直接+1，返回结果数组
            if (digits[i] != 9) {
                digits[i] += 1;
                return digits;
            } else {
                // 为9，9+1=10，需进位，当前值设为 0
                digits[i] = 0;
            }
        }
        // 输入数组的值全为 9，+1 后位数也要 +1，结果一定是首位为 1，余位为 0 的数组
        int[] result = new int[digits.length + 1];
        // 利用整形数组初始化后，值为0的特性，只需对数组首位赋值
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        int[] params = new int[]{0};
        System.out.println(Arrays.toString(plusOne(params)));
    }
}
