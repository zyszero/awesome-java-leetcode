package com.zys.arts.stack.no0155;

import java.util.LinkedList;

/**
 * @author zys
 * @date 2020-07-29 12:43
 */
public class MinStack_1 {
    private LinkedList<Integer> list1 = new LinkedList<Integer>();
    private LinkedList<Integer> list2 = new LinkedList<Integer>();


    /**
     * initialize your data structure here.
     */
    public MinStack_1() {

    }

    public void push(int x) {
        if (list2.size() == 0 || list2.getLast() >= x) {
            list2.addLast(x);
        }
        list1.addLast(x);
    }

    public void pop() {
        if (list1.getLast().equals(list2.getLast())) {
            list2.removeLast();
        }
        list1.removeLast();
    }

    public int top() {
        return list1.getLast();
    }

    public int getMin() {
        return list2.getLast();
    }
}
