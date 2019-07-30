package com.zys.arts.Strings;

import java.util.Arrays;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * <p>
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 *
 * @author: zys
 * @date: 2019/7/17 22:46
 */
public class ValidAnagram {
    /**
     * 题意：给两个字符串，判断这两个字符串是否由相同数量且相等的字符组成，有就返回 true，无则返回 false
     * 注意：你可以假设给予的两个字符串只包含小写字母
     * 思路很简单：
     * 1. 两字符串长度不一致，则返回 false
     * 2. 分别将字符串分解为字符数组
     * 3. 对字符数组进行排序后，进行一一比对即可
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s, String t) {
        // 边界条件 1. 两字符串长度不一致，则返回 false
        if (s.length() != t.length()) {
            return false;
        }
        // 2. 分别将字符串分解为字符数组
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        // 3. 对字符数组进行排序后，进行一一比对即可
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] != tChars[i]) {
                return false;
            }
        }
        return true;
    }


    /**
     * 利用散列表的思想做：
     * 1. 根据题意我们可以得出，给予的字符串的字符范围是 a - z，即26个字母
     * 2. 那么我们可以用一个整形数组来进行存储，通过下标标识‘字母’，值表示字母出现的次数
     * 3. 数组下标如何标识字母呢？可以通过 ASCII 码表得出, 即 （当前字母 - a）的值为下标
     * 4. 通过下标和值，我们就可以推断出这两个字符串是否由相同数量且相等的字符组成
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        // 边界条件 1. 两字符串长度不一致，则返回 false
        if (s.length() != t.length()) {
            return false;
        }
        // 定义一个整数数组，模拟散列表
        int[] table = new int[26];
        // 遍历字符串字符
        for (int i = 0; i < s.length(); i++) {
            // 一个字符串的字符对应的值进行 + 1 操作
            // 另一个字符串的字符对应的值进行 - 1 操作
            table[s.charAt(i) - 'a']++;
            table[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < table.length; i++) {
            // 如果两个字符串是由相同数量且相等的字符组成，那么字符对应数组内的值，应该为0，因为两个字符串遍历字符时，分别做的是+1和-1的操作
            if (table[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Runtime: 3 ms, faster than 94.21% of Java online submissions for Valid Anagram.
     * Memory Usage: 36.3 MB, less than 99.39% of Java online submissions for Valid Anagram.
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        // 边界条件 1. 两字符串长度不一致，则返回 false
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        // ASCII 码表加上拓展集共256个字符，所以我们定义一个长度为256的整数数组来模拟散列表
        int[] table = new int[256];
        for (char c : s.toCharArray()) {
            // 一个字符串的字符对应的值进行 + 1 操作
            table[c]++;
        }
        for (char c : t.toCharArray()) {
            // 另一个字符串的字符对应的值进行 - 1 操作
            table[c]--;
        }
        for (int val : table) {
            // 如果两个字符串是由相同数量且相等的字符组成，那么字符对应数组内的值，应该为0，因为两个字符串遍历字符时，分别做的是+1和-1的操作
            if (val != 0) {
                return false;
            }
        }
        return true;
    }
}
