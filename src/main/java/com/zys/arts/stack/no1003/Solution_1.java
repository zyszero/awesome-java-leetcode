package com.zys.arts.stack.no1003;

import java.util.Stack;

/**
 * @author zys
 * @date 2020-07-31 10:23
 */
public class Solution_1 {
    /**
     * 借助stack来存储
     * 这道题可以简单的理解为：
     * 1. abc 是有效字符串
     * 2. 在一个有效字符串的任意位置插入abc得到的字符串是有效字符串
     * @param S
     * @return
     */
    public boolean isValid(String S) {
        if (S == null || S.isEmpty() || S.length() % 3 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            switch (c) {
                case 'a':
                case 'b':
                    stack.push(c);
                    break;
                case 'c':
                    if (stack.size() < 2) {
                        return false;
                    }
                    char b = stack.pop();
                    char a = stack.pop();
                    if (b != 'b' || a != 'a') {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
