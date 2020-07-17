package com.zys.arts.Strings;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 * <p>
 * Example:
 * <p>
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * Note:
 * <p>
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 *
 * @author zys
 * @date 2020-07-17 11:02
 */
public class GroupAnagrams {
    /**
     * 解法：充分利用哈希表，维护一个映射关系
     * 核心点：不同的字母异分词转换成相同的key即可
     * 利用数组来实现
     * N 是 strs 的长度，而 K 是 strs 中字符串的最大长度
     * 时间复杂度：O(NK)
     * 空间复杂度：O(NK)
     *
     * @param strs
     * @return {@link List<List<String>>}
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }
        int[] table = new int[26];
        Map<String, List<String>> map = new HashMap<>(strs.length);
        for (String str : strs) {
            Arrays.fill(table, 0);
            for (char c : str.toCharArray()) {
                table[c - 'a']++;
            }
            StringBuilder key = new StringBuilder();
            for (int i : table) {
                key.append(i);
            }
            if (!map.containsKey(key.toString())) {
                map.put(key.toString(), new ArrayList<>());
            }
            map.get(key.toString()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 解法：充分利用哈希表，维护一个映射关系
     * 核心点：不同的字母异分词转换成相同的key即可
     * 利用字符排序，可以做到
     * N 是 strs 的长度，而 K 是 strs 中字符串的最大长度
     * 时间复杂度： O(NKlogK)
     * 空间复杂度： O(NK)
     *
     * @param strs
     * @return {@link List<List<String>>}
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }
        Map<String, List<String>> map = new HashMap<>(strs.length);
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
