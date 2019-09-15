package com.zys.arts.Strings;

import java.util.Arrays;

/**
 * Implement strStr().
 * <p>
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Example 1:
 * <p>
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 * <p>
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 * <p>
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * <p>
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 * 译文：
 * <p>
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 著名的字符串匹配算法有：BF算法（Brute Force 暴力匹配算法，又称朴素匹配算法。）、RK算法（Rabin-Karp BF算法的升级版）  BM算法、KMP算法、AC算法
 *
 * @author: zys
 * @date: 2019/8/18 21:53
 */
public class Strstr {


    /**
     * 利用现成的 Java API 来实现
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr1(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    /**
     * 采用 BF算法 来实现
     * 思路：
     * 很简单，将字符串 haystack 作为主串，将字符串 needle 作为 模式串，在主串中，检查起始位置分别是0、1、2....n-m 且长度为 m 的 n-m+1 个子串，看有没有跟模式串匹配的
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr2(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) {
            return 0;
        }
        int z = 0;
        while (z <= haystack.length() - needle.length()) {
            int i;
            for (i = 0; i < needle.length(); ++i) {
                if (haystack.charAt(z + i) != needle.charAt(i)) {
                    break;
                }
            }
            if (i != needle.length()) {
                ++z;
            } else {
                return z;
            }
        }
        return -1;
    }


    /**
     * 采用 RK 算法
     * 自定义一个 hash 算法，例如：字符串 是
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr3(String haystack, String needle) {
        return -1;
    }

    /**
     * 采用BM算法
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr4(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) {
            return 0;
        }
        return bm(haystack.toCharArray(), haystack.length(), needle.toCharArray(), needle.length());
    }

    /**
     * 全局变量
     */
    private static final int SIZE = 256;

    /**
     * 构建坏字符的散列表
     *
     * @param patternStr 模式串
     * @param m          模式串的长度
     * @param hash       散列表，这里简单实现一个散列表，假设字符串的字符集不是很大，每个字符长度是1字节，
     *                   用大小为256的数组，来记录每个字符在模式串中出现的位置。
     *                   数组的下标对应字符的ASCIl码值，数组中存储这个字符在模式串中出现的位置。
     */
    private void generateHash(char[] patternStr, int m, int[] hash) {
        // 初始化散列表
        Arrays.fill(hash, -1);
        for (int i = 0; i < m; i++) {
            // 字符转成 int 就是 ASCII 值了
            int ascii = (int) patternStr[i];
            // 数组中存储这个字符在模式串中出现的位置
            hash[ascii] = i;
        }
    }

    /**
     * 构建好后缀的 suffix 数组和 prefix 数组
     *
     * @param patternStr 模式串
     * @param m          模式串长度
     * @param suffix     数组的下标，表示后缀子串的长度，下标对应的值是模式串中跟好后缀 {u} 相匹配的子串 {u*}的起始下标
     * @param prefix     记录模式串的后缀子串是否能匹配模式串中的前缀子串，下标为公共后缀子串的长度
     */
    private void generateGS(char[] patternStr, int m, int[] suffix, boolean[] prefix) {
        // 初始化 suffix 和 prefix
        for (int i = 0; i < m; i++) {
            suffix[i] = -1;
            prefix[i] = false;
        }

        // m 是模式串的长度，所以 m-1 是模式串的末尾下标
        for (int i = 0; i < m - 1; i++) {
            int j = i;
            // 公共后缀子串的长度 k
            int k = 0;
            // 与 patternStr[0, i] 求公共后缀子串
            while (j >= 0 && patternStr[j] == patternStr[m - 1 - k]) {
                --j;
                ++k;
                // j+1 表示公共后缀子串在 patternStr[0, i] 中的起始下标，j+1的原因是，前面先进行了 --j 的操作
                suffix[k] = j + 1;
            }
            if (j == -1) {
                //表明公共后缀子串也是模式串的前缀子串，比如cabcab，前缀子串是 cab，后缀子串是cab
                prefix[k] = true;
            }
        }
    }

    /**
     * 利用好后缀原则，计算模式串需要往后移动的位数
     *
     * @param j      坏字符对应模式串中的下标
     * @param m      模式串的长度
     * @param suffix
     * @param prefix
     * @return
     */
    private int moveByGS(int j, int m, int[] suffix, boolean[] prefix) {
        // 好后缀的长度
        int k = m - 1 - j;
        // 如果找到另一个相匹配的子串 {u*}，将模式串滑动到子串 {u*} 与 主串中 {u} 对齐的位置
        if (suffix[k] != -1) {
            return j - suffix[k] + 1;
        }
        // r = j + 2，是因为 数组 prexfix 的下标是后缀子串的长度，所以 r = j + 2，其实是 0 到下标 j + 1的长度
        for (int r = j + 2; r < m - 1; ++r) {
            // m -r 是后缀子串的长度 即 k = m -r
            if (prefix[m - r]) {
                return r;
            }
        }
        // 证明公共后缀子串不是模式串的前缀子串
        return m;
    }


    /**
     * BM 算法
     *
     * @param primaryArr 主串
     * @param n          主串长度
     * @param patternArr 模式串
     * @param m          模式串长度
     * @return 匹配成功，返回主串与模式串第一个匹配的字符的位置；匹配失败，返回 -1。
     */
    public int bm(char[] primaryArr, int n, char[] patternArr, int m) {
        // 创建散列表
        int[] hash = new int[SIZE];
        // 构建坏字符的散列表
        generateHash(patternArr, m, hash);
        int[] suffix = new int[m];
        boolean[] prefix = new boolean[m];
        // 构建好后缀的 suffix 数组 和 prefix 数组
        generateGS(patternArr, m, suffix, prefix);
        // i 表示主串与模式串对齐的第一个字符
        int i = 0;
        //直至模式串移至主串尾部
        while (i <= n - m) {
            // j 表示坏字符对应模式串中的下标
            int j;
            // 模式串从后外前匹配
            for (j = m - 1; j >= 0; j--) {
                // 找到坏字符
                if (primaryArr[i + j] != patternArr[j]) {
                    break;
                }
            }
            if (j < 0) {
                // 匹配成功，返回主串与模式串第一个匹配的字符的位置
                return i;
            }
            // 存在坏字符，i+j 是坏字符在主串中的下标，primaryArr[i+j] 是坏字符，
            // hash[(int) primaryArr[i + j]] 是模式串中与坏字符相等的字符的下标
            // j - hash[(int) primaryArr[i + j]] 则是模式串需要往后移动的位数，这样模式串中的“坏字符”才能和主串中的坏字符对齐
            int x = j - hash[(int) primaryArr[i + j]];
            int y = 0;
            // 判断是否存在好后缀，只要坏字符对应模式串中的下标不是模式串的末尾，就证明存在好后缀
            if (j < m - 1) {
                y = moveByGS(j, m, suffix, prefix);
            }
            // 比较坏字符原则和好后缀原则计算得到的位数，取最大数，作为滑动位数，这样还可以避免采用坏字符规则计算滑动位数，可能出现负数的情况。
            i = i + Math.max(x, y);
        }
        return -1;
    }


    /**
     * 采用KMP算法
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr5(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) {
            return 0;
        }
        return kmp(haystack.toCharArray(), haystack.length(), needle.toCharArray(), needle.length());
    }

    /**
     * 求部分匹配表（PMT），或者叫做失效函数。在这里假设为 next 数组
     * 在这里，next 数组的下标是每个前缀结尾字符下标，next 数组的值是这个前缀的最长可以匹配前缀子串的结尾字符下标
     * 如果不存在最长可匹配的前缀子串，next 数组对应下标的值为 -1
     * <p>
     * PMT 的本质是：求出模式串中每种前缀子串的最长可匹配前缀子串
     * 对于模式串的每种前缀子串，依次取出前缀子串的所有后缀子串，然后逐个对比，找出最长可匹配前缀子串，可以形成 PMT 数组，但这样的效率太低
     * <p>
     * 那如何快速求出 PMT 数组呢？
     * 核心思维是：
     * 假设字符串的 b[0, i-1] 的最长可匹配前缀子串是 b[0, k-1]，即 next[i-1] = k-1; 那么当 b[k] = b[i]时，b[0, k] 是 b[0, i]的最长可匹配前缀子串 即 next[i] = k
     * <p>
     * 若 b[k] != b[i] 的时候，假设字符串 b[0, i] 的最长可匹配后缀子串是 b[r, i]，那么 b[r, i-1] 肯定是 b[0, i-1] 的可匹配后缀子串，但不一定是最长可匹配后缀子串。
     * 这时我们比较 b[0, i-1] 的次长可匹配后缀子串 b[x, i-1] 对应的次长可匹配前缀子串 b[0, i-1-x] 的下一个字符 b[i-x] 是否匹配 b[i]，
     * 如果等于，那b[x, i] 就是 b[0, i]的最长可匹配后缀子串
     * <p>
     * 那如果求得 b[0, i-1] 的次长可匹配后缀子串呢？
     * 次长可匹配后缀子串肯定被包含在最长可匹配后缀子串中，而最长可匹配后缀子串又对应最长可匹配前缀子串 b[0，y]。
     * 于是，查找 b[0，i-1] 的次长可匹配后缀子串，这个问题就变成，查找 b[0，y] 的最长匹配后缀子串的问题了。
     * 按照这个思路，我们可以考察完所有的 b[0，i-1] 的可匹配后缀子串 b[y，i-1]，
     * 直到找到一个可匹配的后缀子串，它对应的前缀子串的下一个字符等于 b[i]，那这个 b[y，i] 就是 b[0，i]的最长可匹配后缀子串。
     *
     * @param b 模式串
     * @param m 模式串的长度
     * @return 返回 PMT 的数组
     */
    public static int[] getNext(char[] b, int m) {
        //初始化 next 数组
        int[] next = new int[m];
        next[0] = -1;
        //假设 k 是最长可匹配前缀子串的结尾下标， -1 表示不存在
        int k = -1;
        // 这里的 i 表示模式串的每种前缀子串的尾下标
        for (int i = 1; i < m; i++) {
            while (k != -1 && b[k + 1] != b[i]) {
                // 因为前一个的最长可匹配前缀字符串的下一个字符不与最后一个字符相等，需要找前一个的次长串，问题就变成了求 0 到 next[k] 的最长可匹配前缀字符串，
                // 如果它的下个字符与最后一个不等，继续求次长串，也就是下一个next[k]，直到找到，或者完全没有。
                k = next[k];
            }
            if (b[k + 1] == b[i]) {
                ++k;
            }
            next[i] = k;
        }
        return next;
    }

    /**
     * 采用 KMP 字符串匹配算法
     *
     * @param a 主串
     * @param n 主串的长度
     * @param b 模式串
     * @param m 模式串的长度
     * @return 匹配成功，返回主串与模式串第一个匹配的字符的位置；匹配失败，返回 -1。
     */
    public int kmp(char[] a, int n, char[] b, int m) {
        // j 代表坏字符在模式串中对应的下标
        int j = 0;
        int[] next = getNext(b, m);
        for (int i = 0; i < n; i++) {
            // 当b[j] != a[i]时，j 即为坏字符在模式串中对应的下标
            while (j > 0 && b[j] != a[i]) {
                // next[j - 1] 即为好前缀
                j = next[j - 1] + 1;
            }
            if (a[i] == b[j]) {
                // ++j 有两种含义，一种是看成移动位置的字符串的长度，另一种是坐标往后挪动一位
                ++j;
            }
            // 当 j == m 时，证明找到匹配模式串了
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    /**
     * 利用equals API 来做
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) {
            return 0;
        }
        int n = needle.length();
        int i = 0;
        while (i + n <= haystack.length()) {
            if (haystack.substring(i, n + i).equals(needle)) {
                return i;
            }
            ++i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Strstr().strStr("a", "a"));
    }
}
