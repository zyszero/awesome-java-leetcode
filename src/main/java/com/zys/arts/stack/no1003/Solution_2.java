package com.zys.arts.stack.no1003;

/**
 * @author zys
 * @date 2020-07-31 12:59
 */
public class Solution_2 {
    /**
     * 这道题可以简单的理解为：
     * 1. abc 是有效字符串
     * 2. 在一个有效字符串的任意位置插入abc得到的字符串是有效字符串
     *
     * @param S
     * @return
     */
    public boolean isValid(String S) {
        if (S == null || S.isEmpty() || S.length() % 3 != 0) {
            return false;
        }
        char[] chars = S.toCharArray();
        char[] stack = new char[chars.length];
        int index = 0;
        for (char curr : chars) {
            if (curr == 'c') {
                if (index < 2 || stack[--index] != 'b' || stack[--index] != 'a') {
                    return false;
                }
                continue;
            }
            stack[index++] = curr;
        }
        return index == 0;
    }
}
