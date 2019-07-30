package com.zys.arts.Strings;

/**
 * TODO 有待优化
 *
 * @author: zys
 * @date: 2019/7/25 23:11
 */
public class ValidPalindrome {
    public static boolean isPalindrome1(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        String tmp = s.replaceAll("[^A-Za-z0-9]?", "").toLowerCase();

        char[] chars = tmp.toCharArray();
        if (chars.length == 0) {
            return false;
        }
        int start = 0, end = chars.length - 1;
        while (start <= end) {
            if (chars[start] != chars[end]) {
                return false;
            }
            ++start;
            --end;
        }
        return true;
    }

    public static boolean isPalindrome2(String s) {
        // 通过正则过滤掉除字母数字之外的字符，并将字母全部转为小写字母
        String s1 = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        // 利用 StringBuilder#reverse() API 翻转字符串
        String s2 = new StringBuilder(s1).reverse().toString();
        // 比较两个字符串
        return s1.equals(s2);
    }

    // 定义一个长度为256的整形数组来模拟散列表，下标为字符的值，数组的值用于标识字符(ASCII 码表加上拓展集共256个字符)。
    private static final int[] map = new int[256];

    // 初始化整形数组，字母或数字字符对应数组存储的值，要唯一的，其余字符皆为0，这样就不用过滤除字母或数字之外的字符了。
    static {
        for (int i = 0; i < 10; i++) {
            // 初始化数字字符的值，+ 1 是为了值不出现 0
            map[i + '0'] = i + 1;
        }
        for (int i = 0; i < 26; i++) {
            // 初始化字母的值，并做大小写忽略处理，值相同即可
            map[i + 'a'] = map[i + 'A'] = 11 + i;
        }
    }

    public static boolean isPalindrome(String s) {
        // 换成字符数组
        char[] pChars = s.toCharArray();
        // 头尾指针
        int start = 0, end = pChars.length - 1;
        // sV 头指针指向的值，eV 尾指针指向的值
        int sV, eV;
        while (start < end) {
            sV = map[pChars[start]];
            eV = map[pChars[end]];
            // sV != 0 代表 pChars[start] 是字母或数字字符
            if (sV != 0 && eV != 0) {
                // 值不相同，pChars[start] ！= pChars[end] 即字符不同
                if (sV != eV) {
                    return false;
                }
                start++;
                end--;
            } else {
                // 如果头指针指向的字符是字母或数字字符之外的字符，则往前移动头指针
                if (sV == 0) {
                    start++;
                }
                // 如果尾指针指向的字符是字母或数字字符之外的字符，则往后移动尾指针
                if (eV == 0) {
                    end--;
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(
                "0P"));

    }
}
