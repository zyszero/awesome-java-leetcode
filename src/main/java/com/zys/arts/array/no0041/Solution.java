package com.zys.arts.array.no0041;

/**
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 * <p>
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *  
 * <p>
 * 提示：
 * <p>
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zys
 * @date 2020-12-02 21:01
 */
public class Solution {
    /**
     * 利用已有数组做哈希表，思路非常妙
     * 不在[1, N]区域内的数，我们都可以认为是无效数据，那么小于1的数，我们可以将其填充为 N+1
     * 遍历数组，凡是属于[1, N]的数，这里假定为x,都对nums[x - 1]进行取反
     * 重新遍历数组，第一个非负数的下标 + 1 即为我们所求，若都为负数，则n+1为我们所求
     * ps: N为数组长度
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 1) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            // 这里取绝对值后再取反的原因是：防止相同元素重复标记，导致标记失效
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }


    public static void main(String[] args) {
        new Solution().firstMissingPositive(new int[]{1, 2, 0});
    }
}
