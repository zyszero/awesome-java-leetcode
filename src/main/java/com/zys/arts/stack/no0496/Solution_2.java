package com.zys.arts.stack.no0496;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author zys
 * @date 2020-08-04 15:27
 */
public class Solution_2 {
    /**
     * https://leetcode-cn.com/problems/next-greater-element-i/solution/dan-diao-zhan-jie-jue-next-greater-number-yi-lei-w/
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int val = nums2[i];
            while (!stack.isEmpty() && stack.peek() < val) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                map.put(val, -1);
            } else {
                map.put(val, stack.peek());
            }
            stack.push(val);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }
}
