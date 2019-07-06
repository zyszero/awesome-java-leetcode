package com.zys.arts.Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * First Unique Character in a String
 * Go to Discuss
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * <p>
 * Examples:
 * <p>
 * s = "leetcode"
 * return 0.
 * <p>
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 *
 * @author: zys
 * @date: 2019/7/6 16:27
 */
public class FindUniqueChar {
    public int firstUniqChar1(String s) {
        if (s == null) {
            return -1;
        }
        Map<Character, Integer> map = new HashMap<>(16);
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char key = s.charAt(i);
            if (map.containsKey(key)) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (key == s.charAt(j)) {
                    map.put(key, i);
                    break;
                }
            }
            if (!map.containsKey(key)) {
                return i;
            }
        }
        return -1;
    }


    public int firstUniqChar2(String s) {
        if (s == null) {
            return -1;
        }
        Map<Character, Integer> map = new HashMap<>(16);
        int n = s.length();
        for (int i = 0; i < n; i++) {
            Character key = s.charAt(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            Character key = s.charAt(i);
            if (map.get(key) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static int firstUniqChar(String s) {
        // 边界条件
        if (s == null) {
            return -1;
        }
        // 字符串长度
        int index = s.length();
        // 字符串是小写字母组成的字符串，所以字符范围在 a ~ z
        for (char i = 'a'; i <= 'z'; i++) {
            // String.indexOf（返回第一次出现指定字符的字符串中的索引，没有出现则返回 -1），所以 s.indexOf(i) != -1
            // String.lastIndexOf(返回指定字符的最后一次出现的字符串中的索引)，所以 s.indexOf(i) == s.lastIndexOf(i) 时，该字符没有重复
            // s.indexOf(i) < index 是要求出第一个没有重复字符
            if (s.indexOf(i) != -1 && s.indexOf(i) == s.lastIndexOf(i) && s.indexOf(i) < index) {
                index = s.indexOf(i);
            }
        }
        // 当index != s.length() 证明存在没有重复的字符
        if (index != s.length()) {
            return index;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }
}
