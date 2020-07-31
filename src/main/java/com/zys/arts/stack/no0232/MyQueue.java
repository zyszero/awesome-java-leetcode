package com.zys.arts.stack.no0232;

import java.util.Stack;

/**
 * Implement the following operations of a queue using stacks.
 * <p>
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * Example:
 * <p>
 * MyQueue queue = new MyQueue();
 * <p>
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // returns 1
 * queue.pop();   // returns 1
 * queue.empty(); // returns false
 * Notes:
 * <p>
 * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
 * <p>
 * 思路：双堆栈模拟即可
 * 入队操作：
 * 时间复杂度 - O(1)
 * 空间复杂度 - O(n)
 *
 * 出队操作：
 * 时间复杂度 - 摊换时间复杂度： O(1)
 * 空间复杂度 - 摊还空间复杂度： O(1)
 *
 * @author zys
 * @date 2020-07-29 10:33
 */
class MyQueue {

    private Stack<Integer> enStack;

    private Stack<Integer> deStack;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        this.enStack = new Stack<>();
        this.deStack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        enStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        fillDeStack();
        return deStack.pop();
    }

    private void fillDeStack() {
        if (deStack.empty()) {
            while(!enStack.isEmpty()){
                deStack.push(enStack.pop());
            }
        }
    }

    /**
     * Get the front element.
     */
    public int peek() {
        fillDeStack();
        return deStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return enStack.isEmpty() && deStack.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
