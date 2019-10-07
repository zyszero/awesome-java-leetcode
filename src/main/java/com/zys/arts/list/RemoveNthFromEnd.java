package com.zys.arts.list;

/**
 * Remove Nth Node From End of List
 * Solution
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * <p>
 * Example:
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * <p>
 * Given n will always be valid.
 * <p>
 * Follow up:
 * <p>
 * Could you do this in one pass?
 * <p>
 * source: https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/603/
 *
 * @author: zys
 * @date: 2019/9/28 20:37
 */
public class RemoveNthFromEnd {
    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    class Solution {
        public ListNode removeNthFromEnd1(ListNode head, int n) {
            // 限制条件
            if (head == null || n <= 0) {
                return head;
            }
            ListNode tmpNode = head;
            int count = 1;
            // 遍历链表
            while (tmpNode.next != null) {
                // 计算节点个数
                ++count;
                tmpNode = tmpNode.next;
            }
            tmpNode = head;
            int preTargetIndex = count - n;
            // 当 preTargetIndex == 0 时，即要删除头结点
            if (preTargetIndex == 0) {
                return head.next;
            }
            // 找到要删除的目标节点的上一个节点
            while (preTargetIndex > 1) {
                --preTargetIndex;
                tmpNode = tmpNode.next;
            }
            // 移除节点
            tmpNode.next = tmpNode.next.next;
            return head;
        }
    }

    /**
     * 采用快慢指针的方法来做
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 限制条件
        if (head == null || n <= 0) {
            return head;
        }
        // 虚设一个起始节点，为了方便删除头结点的情况
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 慢指针指向起始节点
        ListNode slow = dummy;
        ListNode fast = dummy;
        // 快指针指向慢指针的前 n 个节点
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }
        // 遍历链表直至快指针 fast 移至尾部节点的后继节点处
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 删除节点
        slow.next = slow.next.next;
        return dummy.next;
    }

}
