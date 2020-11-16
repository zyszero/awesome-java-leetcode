package com.zys.arts.list;

import java.util.List;
import java.util.ArrayList;

/**
 * @author: zys
 * @date: 2020/2/6 11:05
 * @see <a href="https://leetcode.com/problems/linked-list-cycle/">141. Linked List Cycle</a>
 */
public class LinkedListCycle {

    private List<ListNode> listNodeList = new ArrayList<ListNode>();

    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        while (head.next != null) {
            listNodeList.add(head);
            head = head.next;
            if (listNodeList.contains(head)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        // 快慢指针
        ListNode low = head;
        ListNode fast = head.next.next;
        while (low != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            low = low.next;
        }
        return true;
    }
}
