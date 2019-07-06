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


    public int firstUniqChar(String s) {
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
}
