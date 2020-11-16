package com.zys.arts.stack;

import java.util.Stack;

/**
 * @author: zys
 * @date: 2020/2/20 9:57
 */
public class EvaluateReversePolishNotation {

    /**
     * switch代替if-else，效率优化(存疑)
     * 还有另一种优化方式：
     * 使用数组代替Stack，自行实现栈
     *
     * @param tokens
     * @return
     */
    public int evalRPN1(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();
        for (String token : tokens) {
            int a, b;
            switch (token) {
                case "+":
                    a = numStack.pop();
                    b = numStack.pop();
                    numStack.push(b + a);
                    break;
                case "-":
                    a = numStack.pop();
                    b = numStack.pop();
                    numStack.push(b - a);
                    break;
                case "*":
                    a = numStack.pop();
                    b = numStack.pop();
                    numStack.push(b * a);
                    break;
                case "/":
                    a = numStack.pop();
                    b = numStack.pop();
                    numStack.push(b / a);
                    break;
                default:
                    numStack.push(Integer.parseInt(token));
                    break;

            }
        }
        return numStack.pop();
    }


    /**
     * 1. 使用数组模拟栈结构
     * 2。数组长度为 n/2 + 1
     *
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        int[] numsStack = new int[tokens.length / 2 + 1];
        int index = 0;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    numsStack[index - 2] += numsStack[--index];
                    break;
                case "-":
                    numsStack[index - 2] -= numsStack[--index];
                    break;
                case "*":
                    numsStack[index - 2] *= numsStack[--index];
                    break;
                case "/":
                    numsStack[index - 2] /= numsStack[--index];
                    break;
                default:
                    numsStack[index++] = Integer.parseInt(token);
                    break;

            }
        }
        return numsStack[0];
    }
}
