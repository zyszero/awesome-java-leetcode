package com.zys.arts.Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 * <p>
 * Input: s = "paper", t = "title"
 * Output: true
 * Note:
 * You may assume both s and t have the same length.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 *
 * @author zys
 * @date 2020-07-20 10:12
 */
public class IsomorphicStrings_205 {
    /**
     * 利用双map去做
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic1(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        Map<Character, Character> sMap = new HashMap<>(s.length());
        Map<Character, Character> tMap = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (!sMap.containsKey(s.charAt(i)) && !tMap.containsKey(t.charAt(i))) {
                sMap.put(s.charAt(i), t.charAt(i));
                tMap.put(t.charAt(i), s.charAt(i));
            } else if (sMap.containsKey(s.charAt(i)) && tMap.containsKey(t.charAt(i))) {
                if (sMap.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isIsomorphic2(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i)) && !map.containsValue(t.charAt(i))) {
                map.put(s.charAt(i), t.charAt(i));
            } else if (map.containsKey(s.charAt(i)) && !map.containsValue(t.charAt(i))) {
                return false;
            } else if (!map.containsKey(s.charAt(i)) && map.containsValue(t.charAt(i))) {
                return false;
            } else if (map.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 这个是最优解
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isIsomorphic(String s, String t) {
        return helper(s, t) && helper(t, s);
    }

    private static boolean helper(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        int[] map = new int[256];
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        for (int i = 0; i < a.length; i++) {
            char x = a[i];
            char y = b[i];
            if (map[x] == 0) {
                map[x] = y;
            } else if (map[x] != y) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
    }
}
