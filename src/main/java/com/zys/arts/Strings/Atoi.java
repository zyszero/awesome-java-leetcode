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
        // 初始化字符 '0' - '9'
        for (int i = 0; i < 10; i++) {
            map[i + '0'] = i + 1;
        }
    }

    public int myAtoi1(String str) {
        if (str == null) {
            return 0;
        }
        // 1. 去掉字符串首尾的空格
        String trim = str.trim();
        if (trim.isEmpty()) {
            return 0;
        }
        // 2. 将字符串转成字符数组
        char[] chars = trim.toCharArray();
        // 用于标识数字的正负 1 代表的是正数，-1代表的是负数
        int start = 0;
        int flag = 1;
        // 限制条件2
        if (chars[0] == '-') {
            flag = -1;
            start++;
        } else if (chars[0] == '+') {
            start++;
        }
        // 表示遇到有效数字字符个数
        int count = 0;
        StringBuilder tmp = new StringBuilder();
        for (int i = start; i < chars.length; i++) {
            // 限制条件3，count != 0表示有效字符存在了；map[chars[i]] = 0 表示当前字符不是‘0’-‘9’
            if (count != 0 && map[chars[i]] == 0) {
                break;
            }
            // 限制条件4
            if (map[chars[i]] == 0 && count == 0) {
                return 0;
            }
            // 当前字符属于‘0’-‘9’，需要保存起来
            if (map[chars[i]] != 0) {
                // 有效字符+1
                count++;
                tmp.append(chars[i]);
            }
        }
        // 将有效数字字符串转成数组，不直接强转的原因是，存在限制条件5，可能会溢出
        char[] cChars = tmp.toString().toCharArray();
        int result = 0;
        int length = 0;
        // 从数值的低位遍历至高位
        for (int i = cChars.length - 1; i >= 0; i--) {
            // 转成有效数字
            int c = cChars[i] - '0';
            int newResult = result + c * (int) StrictMath.pow(10, length);
            // 判断溢出的方法，当新值➗当前位数后，得到的结果与当前的数字不一致，那么就是出现溢出的情况了，假设字符串为“8678”， 8/1 = 8, 78/10 = 7，以此类推，只有溢出时，才会不一致
            if (newResult / (int) StrictMath.pow(10, length) != c) {
                // 根据正负，返回不同的结果
                if (flag > 0) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            result = newResult;
            ++length;
        }
        // 相当于 result * 1 或 result * -1
        return result * flag;
    }

    public int myAtoi2(String str) {
        if (str == null) {
            return 0;
        }
        // 去掉字符串首尾的空格
        String s = str.trim();
        if (s.isEmpty()) {
            return 0;
        }
        // 用于标识数字的正负 1 代表的是正数，-1代表的是负数；start 表示开始的下标；result表示数字的累加结果
        int sign = 1, start = 0, result = 0;
        // 满足限制条件2
        if (s.charAt(0) == '-') {
            sign = -1;
            start++;
        } else if (s.charAt(0) == '+') {
            start++;
        }
        // 当遍历字符为无效字符时，终止遍历
        while (start < s.length() && map[s.charAt(start)] != 0) {
            // 将当前字符转为数值
            int num = s.charAt(start) - '0';
            // 当前累加数值大于 Integer.MAX_VALUE / 10，那么接下来，继续累加必然会溢出
            // 还需排除一种特殊情况，当前累加数值等于 Integer.MAX_VALUE / 10，需要比较接下来的累加值是否大于 Integer.MAX_VALUE的最后一位数，大于则溢出
            if (result > Integer.MAX_VALUE / 10 ||
                    (result == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10)) {
                // 根据标识，判断是Integer.MAX_VALUE还是Integer.MIN_VALUE
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            // 数值累加
            result = result * 10 + num;
            // 往前继续遍历
            start++;
        }
        return result * sign;
    }


    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        int start = 0, flag = 1, base = 0;
        if (str.charAt(start) == '-' || str.charAt(start) == '+') {
            flag = (str.charAt(start) == '-' ? -1 : 1);
            start++;
        }
        while (start < str.length() && str.charAt(start) >= '0' && str.charAt(start) <= '9') {
            if (base > Integer.MAX_VALUE / 10 ||
                    (base == Integer.MAX_VALUE / 10 && (str.charAt(start) - '0' > Integer.MAX_VALUE % 10))) {
                return flag > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            base = base * 10 + (str.charAt(start++) - '0');
        }
        return base * flag;
    }

    public static void main(String[] args) {
        System.out.println(new Atoi().myAtoi2("2147483646"));
    }
}
