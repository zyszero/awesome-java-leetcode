package com.zys.arts.array;

/**
 * 167. Two Sum II - Input array is sorted
 * <p>
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 * <p>
 * Note:
 * <p>
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * Example:
 * <p>
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 *
 * @author zys
 * @date 2020-07-02 10:49
 */
public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        // 边界条件
        if (numbers == null || numbers.length < 1) {
            throw new IllegalArgumentException("No two sum solution");
        }

        int head = 0, tail = numbers.length - 1;
        while (head < tail) {
            if (numbers[head] + numbers[tail] > target) {
                tail--;
            } else if (numbers[head] + numbers[tail] < target) {
                head++;
            } else {
                return new int[]{head + 1, tail + 1};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
