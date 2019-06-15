package com.zys.arts.recursion;

/**
 * @Author: Created by zys
 * @Description:
 * @Date: 2019/3/18 22:31
 * @Modified By:
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] input = new char[]{'H','a','n','n','a','h'};
        reverseString(input);
    }

    private static void reverseString(char[] s) {
        char temp;
        int midIndex = s.length / 2;
        for (int i = 0; i < midIndex; i++) {
            temp = s[i];
            s[i] = s[s.length - 1 -i];
            s[s.length - 1 - i] = temp;
        }
        System.out.println(s);
    }
}
