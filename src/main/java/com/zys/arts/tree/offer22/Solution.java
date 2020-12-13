package com.zys.arts.tree.offer22;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 * <p>
 * 来源：力扣（LeetCode）
 */
public class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        // 先遍历，计算个数，然后在输出
        int size = 0;
        ListNode tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
            size++;
        }
        int offset = size - k;
        while (--offset >= 0) {
            head = head.next;
        }
        return head;
    }
}
