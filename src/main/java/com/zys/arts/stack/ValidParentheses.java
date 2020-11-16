package com.zys.arts.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author: zys
 * @date: 2020/2/19 9:42
 * @see <a href="https://leetcode.com/problems/valid-parentheses/">20. Valid Parentheses</a>
 */
public class ValidParentheses {

    public boolean isValid1(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        char firstChar = s.charAt(0);
        if (s.length() % 2 != 0 || firstChar == ')' || firstChar == ']' || firstChar == '}') {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        stack.push(firstChar);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.empty()) {
                stack.push(c);
                continue;
            }
            Character top = stack.pop();
            if (top == '(') {
                if (c == ')') {
                    continue;
                } else if (c == ']' || c == '}') {
                    return false;
                } else {
                    stack.push(top);
                    stack.push(c);
                }
            }
            if (top == '[') {
                if (c == ']') {
                    continue;
                } else if (c == ')' || c == '}') {
                    return false;
                } else {
                    stack.push(top);
                    stack.push(c);
                }
            }
            if (top == '{') {
                if (c == ')' || c == ']') {
                    return false;
                }
                if (c != '}') {
                    stack.push(top);
                    stack.push(c);
                }
            }
        }
        return stack.empty();
    }

    // Hash table that takes care of the mappings.
    private HashMap<Character, Character> mappings;

    // Initialize hash map with mappings. This simply makes the code easier to read.
    public ValidParentheses() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    /**
     * isValid1的优化版，思路是一致的
     * @param s
     * @return
     */
    public boolean isValid2(String s) {

        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket.
            if (this.mappings.containsKey(c)) {

                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }


    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.empty();
    }
}
