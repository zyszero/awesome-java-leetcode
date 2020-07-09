package com.zys.arts.array;

/**
 * Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.
 * <p>
 * Example 1:
 * <p>
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 *  
 * <p>
 * Example 2:
 * <p>
 * Input: 3
 * Output: False
 * <p>
 * 链接：https://leetcode-cn.com/problems/sum-of-square-numbers
 *
 * @author zys
 * @date 2020-07-08 10:29
 */
public class SumOfSquareNumbers {

    /**
     * 利用Math.sqrt() 函数来实现
     *
     * @param c
     * @return
     */
    public boolean judgeSquareSum1(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b) {
                return true;
            }
        }
        return false;
    }

    /**
     * 二分查找
     *
     * @param c
     * @return
     */
    public boolean judgeSquareSum2(int c) {
        for (long a = 0; a * a <= c; a++) {
            int b = c - (int) (a * a);
            if (binary_search(0, b, b)) {
                return true;
            }
        }
        return false;
    }

    public boolean binary_search(long s, long e, int n) {
        if (s > e) {
            return false;
        }
        long mid = s + (e - s) / 2;
        if (mid * mid == n) {
            return true;
        }
        if (mid * mid > n) {
            return binary_search(s, mid - 1, n);
        }
        return binary_search(mid + 1, e, n);
    }


    /**
     * 费马平方和定理：一个非负整数 cc 能够表示为两个整数的平方和，当且仅当 cc 的所有形如 4k+34k+3 的质因子的幂次均为偶数。
     * 证明：https://wstein.org/edu/124/lectures/lecture21/lecture21/node2.html
     *
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c) {
        for (int i = 2; i * i <= c; i++) {
            int count = 0;
            if (c % i == 0) {
                while (c % i == 0) {
                    count++;
                    c /= i;
                }
                if (i % 4 == 3 && count % 2 != 0)
                    return false;
            }
        }
        return c % 4 != 3;
    }
}
