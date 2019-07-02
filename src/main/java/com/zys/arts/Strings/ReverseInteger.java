package com.zys.arts.Strings;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output: 321
 * Example 2:
 * <p>
 * Input: -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1].
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 *
 * @author: zys
 * @date: 2019/7/2 22:32
 */
public class ReverseInteger {
    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            //求整数的尾部数字
            int tail = x % 10;
            // 求当前数 比如 123，首先的尾数是 3
            int newResult = result * 10 + tail;
            // 如果 result * 10 + tail 发生溢出，溢出值 newResult/10 是不等于 result 的，这里不减去尾部值 tail，是因为值为整形，除于10后，小数点会被移除。
            if (newResult / 10 != result) {
                return 0;
            }
            // 没有溢出则继续遍历
            x /= 10;
            result = newResult;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }

}
