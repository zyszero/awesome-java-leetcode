package com.zys.arts.Strings;

/**
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * You may assume all the characters consist of printable ascii characters.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 * <p>
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 *
 * @Author: Created by zys
 * @Description:
 * @Date: 2019/3/18 22:31
 * @Modified By:
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] input = new char[]{'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString(input);
    }

    private static void reverseString(char[] s) {
        char temp;
        int midIndex = s.length / 2;
        for (int i = 0; i < midIndex; i++) {
            temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
        System.out.println(s);
    }


}
