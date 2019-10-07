package com.zys.arts.Strings;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 * <p>
 * All given inputs are in lowercase letters a-z.
 *
 * @author: zys
 * @date: 2019/9/25 22:19
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix0(String[] strs) {
        if (strs == null || strs.length == 0 || strs[0].isEmpty()) {
            return "";
        }
        String s0 = strs[0];
        String[] prefixStrings = new String[s0.length()];
        for (int i = 0; i < s0.length(); i++) {
            prefixStrings[i] = s0.substring(0, i + 1);
        }
        int index = 0;
        boolean flag = true;
        while (flag) {
            for (int i = 1; i < strs.length; i++) {
                if (prefixStrings[index].length() > strs[i].length()) {
                    break;
                } else {
                    flag = prefixStrings[index].equals(strs[i].substring(0, prefixStrings[index].length()));
                }
                if (!flag) {
                    break;
                }
            }
            if (!flag) {
                break;
            }
            index++;
            if (prefixStrings.length == index) {
                flag = false;
            }
        }
        if (index == 0) {
            return "";
        }
        return prefixStrings[index - 1];
    }

    /**
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 取第一个字符串（任意一个字符串也行）作为比较字符串，其余的作为被比较字符串
        // 这道题的本质上是拿第一个字符串的所有子串，去匹配其余字符串，找到其中的全都能匹配的最长子串，就是最长的公共子串了
        String s0 = strs[0];
        // 寻找最长公共子串
        for (int i = 1; i < strs.length; i++) {
            // 当 strs[i].indexOf(s0) == 0 时，证明找到了strs[i] 的最长子串
            // String.indexOf("") == 0  这招用的妙啊
            while (strs[i].indexOf(s0) != 0) {
                // 从最长的子串开始匹配，直至找到最长公共字符串或变为空串
                s0 = strs[0].substring(0, s0.length() - 1);
            }
        }
        // 最长公共字符串 或 空串
        return s0;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"c","acc","ccc"}));
    }
}
