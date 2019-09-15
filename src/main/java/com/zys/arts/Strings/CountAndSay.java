package com.zys.arts.Strings;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * <p>
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 * <p>
 * Note: Each term of the sequence of integers will be represented as a string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 1
 * Output: "1"
 * <p>
 * Example 2:
 * <p>
 * Input: 4
 * Output: "1211"
 *
 * @author: zys
 * @date: 2019/9/14 22:17
 */
public class CountAndSay {
    public static String countAndSay1(int n) {
        if (n == 1) {
            return "1";
        }
        StringBuilder currSequence = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            int count = 1;
            char[] sequence = currSequence.toString().toCharArray();
            currSequence = new StringBuilder();
            for (int j = 0; j < sequence.length; j++) {
                if (j == sequence.length - 1) {
                    currSequence.append(count).append(sequence[j]);
                    break;
                }
                if (sequence[j] == sequence[j + 1]) {
                    ++count;
                } else {
                    currSequence.append(count).append(sequence[j]);
                    count = 1;
                }
            }
        }
        return currSequence.toString();
    }


    public static String countAndSay(int n) {
        StringBuilder currSequence = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            char[] sequence = currSequence.toString().toCharArray();
            currSequence = new StringBuilder();
            int count = 1;
            if (sequence.length == 1) {
                currSequence.append(count).append(sequence[0]);
                continue;
            }
            for (int j = 0; j < sequence.length; j++) {
                if (j == sequence.length - 1) {
                    currSequence.append(count).append(sequence[j]);
                    break;
                }
                if (sequence[j] == sequence[j + 1]) {
                    count++;
                } else {
                    currSequence.append(count).append(sequence[j]);
                    count = 1;
                }
            }
        }
        return currSequence.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay1(4));
    }
}



