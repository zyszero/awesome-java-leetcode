package com.zys.arts.recursion.no0856;


import java.util.Stack;

/**
 * @author zys
 * @date 2020-08-05 9:42
 */
public class Solution {
    /**
     * 1. 构建一个栈
     * 2. 如果遇到(就往栈里面添加
     * 3. 如果遇到)就去寻找最近的左括号抵消，同时计算里面的分数
     * 拿(()(()))示例, 栈结构变化如下
     * <p>
     * <p>
     * [(]                # 遇到 ( 往栈添加
     * [(, (]             # 继续添加
     * [(, 1]             # 遇到 ） 合成一个1
     * [(, 1, (]          # 遇到 ( 往栈添加
     * [(, 1, (, (]       # 继续添加
     * [(, 1, (, 1]       # 遇到 ） 合成一个1
     * [(, 1, 2]          # 遇到 ） ，结构就是（1）， 所以计算的话是 1 * 2
     * [6]                # 遇到 ） ，结构是（1，2）， 所以计算的话是 （1 + 2） * 2
     * <p>
     * 作者：finnwu
     * 链接：https://leetcode-cn.com/problems/score-of-parentheses/solution/kan-bu-dong-bie-ren-de-ti-jie-zi-ji-you-xie-liao-y/
     *
     * @param S
     * @return
     */
    public static int scoreOfParentheses(String S) {
        if (S == null || S.length() == 0) {
            return 0;
        }
        var stack = new Stack<Character>();
        for (var c : S.toCharArray()) {
            if (c == '(') {
                stack.push('(');
            } else {
                var a = stack.pop();
                if (a == '(') {
                    stack.push('1');
                } else {
                    var temp = 0;
                    while (a != '(') {
                        temp += ((int) a - 48);
                        a = stack.pop();
                    }
                    stack.push((char) (temp * 2 + '0'));
                }
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += (int) stack.pop() - 48;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(scoreOfParentheses("(()(()()))"));
    }
}
