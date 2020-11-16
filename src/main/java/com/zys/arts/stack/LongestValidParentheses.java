package com.zys.arts.stack;

import java.util.Stack;

/**
 * @author: zys
 * @date: 2020/2/23 23:57
 * @see: <a href="https://leetcode.com/problems/longest-valid-parentheses/">32. Longest Valid Parentheses</a>
 */
public class LongestValidParentheses {
    /**
     * 1. 暴力破解
     *
     * @param s
     * @return
     */
    public int longestValidParentheses1(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j += 2) {
                if (isValid(s.substring(i, j))) {
                    max = Math.max(max, j - i);
                }
            }
        }
        return max;
    }


    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses1("(()"));
    }

    /**
     * 2. 动态规划（DP）
     *
     * @param s
     * @return
     */
    public int longestValidParentheses2(String s) {

        return 0;
    }


    /**
     * 3. 栈
     *
     * @param s
     * @return
     */
    public int longestValidParentheses3(String s) {
        return 0;
    }


    /**
     * 不需要额外的空间
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        return 0;
    }

}
