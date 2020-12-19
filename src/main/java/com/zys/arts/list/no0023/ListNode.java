package com.zys.arts.list.no0023;

/**
 * @author: zys
 * @date: 2020/2/6 11:57
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int x) {
        val = x;
        next = null;
    }

    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
