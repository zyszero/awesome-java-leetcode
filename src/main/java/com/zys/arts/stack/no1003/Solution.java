package com.zys.arts.stack.no1003;

/**
 * We are given that the string "abc" is valid.
 * <p>
 * From any valid string V, we may split V into two pieces X and Y such that X + Y (X concatenated with Y) is equal to V.  (X or Y may be empty.)  Then, X + "abc" + Y is also valid.
 * <p>
 * If for example S = "abc", then examples of valid strings are: "abc", "aabcbc", "abcabc", "abcabcababcc".  Examples of invalid strings are: "abccba", "ab", "cababc", "bac".
 * <p>
 * Return true if and only if the given string S is valid.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: "aabcbc"
 * Output: true
 * Explanation:
 * We start with the valid string "abc".
 * Then we can insert another "abc" between "a" and "bc", resulting in "a" + "abc" + "bc" which is "aabcbc".
 * Example 2:
 * <p>
 * Input: "abcabcababcc"
 * Output: true
 * Explanation:
 * "abcabcabc" is valid after consecutive insertings of "abc".
 * Then we can insert "abc" before the last letter, resulting in "abcabcab" + "abc" + "c" which is "abcabcababcc".
 * Example 3:
 * <p>
 * Input: "abccba"
 * Output: false
 * Example 4:
 * <p>
 * Input: "cababc"
 * Output: false
 *  
 * <p>
 * Note:
 * <p>
 * 1 <= S.length <= 20000
 * S[i] is 'a', 'b', or 'c'
 * <p>
 * 链接：https://leetcode-cn.com/problems/check-if-word-is-valid-after-substitutions
 *
 * @author zys
 * @date 2020-07-31 10:16
 */
public class Solution {
    /**
     * 这道题可以简单的理解为：
     * 1. abc 是有效字符串
     * 2. 在一个有效字符串的任意位置插入abc得到的字符串是有效字符串
     * @param S
     * @return
     */
    public boolean isValid(String S) {
        if (S == null || S.isEmpty()) {
            return false;
        }

        while (S.contains("abc")) {
            S = S.replaceAll("abc", "");
        }
        return "".equals(S);
    }
}
