package com.zys.arts.stack.no0503;

import java.util.Stack;

/**
 * @author zys
 * @date 2020-08-04 12:44
 */
public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length * 2 - 1; i >= 0; i--) {
            int val = nums[i % nums.length];
            while (!stack.isEmpty() && stack.peek() <= val) {
                stack.pop();
            }
            res[i % nums.length] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(val);
        }
        return res;
    }
}
