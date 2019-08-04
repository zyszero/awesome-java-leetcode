package com.zys.arts.Strings;

/**
 * Implement atoi which converts a string to an integer.
 * <p>
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 * <p>
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 * <p>
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * <p>
 * If no valid conversion could be performed, a zero value is returned.
 * <p>
 * Note:
 * <p>
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 * Example 1:
 * <p>
 * Input: "42"
 * Output: 42
 * Example 2:
 * <p>
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 * Then take as many numerical digits as possible, which gets 42.
 * Example 3:
 * <p>
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * Example 4:
 * <p>
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 * digit or a +/- sign. Therefore no valid conversion could be performed.
 * Example 5:
 * <p>
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 * Thefore INT_MIN (−231) is returned.
 *
 * @author: zys
 * @date: 2019/8/3 18:05
 */
public class Atoi {
    private static final int map[] = new int[256];

    static {
        for (int i = 0; i < 10; i++) {
            map[i + '0'] = i + 1;
        }
        map['-'] = 11;
        map['+'] = 12;
    }


    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        // 数字的正负，true 为 正数
        int flag = 1;
        // 表示遇到有效字符个数
        int count = 0;
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if((map[chars[i]] == 0 || map[chars[i]] > 10) && count != 0){
                break;
            }
            if (chars[i] == ' ') {
                continue;
            }
            if (map[chars[i]] == 0 && count == 0 && chars[i] != '-' && chars[i] != '+') {
                return 0;
            }
            if (count != 0 && (chars[i] == '-' || chars[i] == '+')){
                return 0;
            }
            if (map[chars[i]] == 11 && count == 0 && chars[i] == '-') {
                flag = -1;
                count++;
            }
            if (map[chars[i]] == 12 && count == 0 && chars[i] == '+') {
                count++;
            }
            if (map[chars[i]] != 0 && chars[i] != '-' && chars[i] != '+') {
                count++;
                tmp.append(chars[i]);
            }
        }
        String s = tmp.toString();
        if (s.isEmpty()) {
            return 0;
        }
        char[] cChars = s.toCharArray();
        int result = 0;
        int length = 0;
        for (int i = cChars.length -1; i >= 0; i--) {
            int c = cChars[i] - '0';
            int newResult = result + c * (int) StrictMath.pow(10, length);
            if (newResult / (int) StrictMath.pow(10, length) != c) {
                if (flag > 0) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            result = newResult;
            ++length;
        }
        return result * flag;
    }

    public static void main(String[] args) {
        System.out.println(new Atoi().myAtoi("   -42"));
    }
}
