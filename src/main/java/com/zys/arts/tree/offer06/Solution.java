package com.zys.arts.tree.offer06;

public class Solution {
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        ListNode pre = null;
        ListNode cur = head;
        int size = 0;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
            size++;
        }
        cur = pre;
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = cur.val;
            cur = cur.next;
        }
        return res;
    }
}
