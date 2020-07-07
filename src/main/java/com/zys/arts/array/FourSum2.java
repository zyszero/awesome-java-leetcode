package com.zys.arts.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
 * <p>
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
 * <p>
 * Example:
 * <p>
 * Input:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * The two tuples are:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 * <p>
 * 链接：https://leetcode-cn.com/problems/4sum-ii
 *
 * @author zys
 * @date 2020-07-07 10:38
 */
public class FourSum2 {
    /**
     * 思路：两数相加的拓展版
     * 使用一个哈希表来加快速度
     * 时间复杂度：O(n^2) + O(n^2) = 2O(n^2) => O(n^2)
     * 空间复杂度：O(n^2)
     *
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> hashMap = new HashMap<>(A.length * A.length);
        int result = 0;
        for (int element : A) {
            for (int value : B) {
                int sum = element + value;
                hashMap.merge(sum, 1, Integer::sum);
            }
        }
        for (int item : C) {
            for (int value : D) {
                int sum = -(item + value);
                result += hashMap.getOrDefault(sum, 0);
            }
        }
        return result;
    }
}
