package com.zys.arts.stack.no0496;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author zys
 * @date 2020-08-04 11:10
 */
public class Solution_1 {
    /**
     * https://leetcode-cn.com/problems/next-greater-element-i/solution/xia-yi-ge-geng-da-yuan-su-i-by-leetcode/
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : nums2) {
            if (!stack.isEmpty() && stack.peek() < val) {
                while (!stack.isEmpty() && stack.peek() < val) {
                    map.put(stack.pop(), val);
                }
            }
            stack.push(val);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }
}
