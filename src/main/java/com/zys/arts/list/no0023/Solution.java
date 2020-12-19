package com.zys.arts.list.no0023;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zys
 * @date 2020-12-04 12:54
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode head = new ListNode(), curNode = head;
        Queue<ListNode> queue = new LinkedList<>();
        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(list);
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode minNode = queue.poll();
            for (int i = 1; i < size; i++) {
                ListNode temp = queue.poll();
                if (minNode.val > temp.val) {
                    queue.offer(minNode);
                    minNode = temp;
                } else {
                    queue.offer(temp);
                }
            }
            curNode.next = minNode;
            curNode = minNode;
            if (minNode != null && minNode.next != null) {
                queue.offer(minNode.next);
            }
        }
        return head.next;
    }
}
