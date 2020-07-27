package com.zys.arts.list.no002;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 *
 * @author zys
 * @date 2020-07-23 10:59
 */
public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 思路：
     * 1. 各自遍历至链表尾部，将遍历的值放入堆栈中
     * 2. 两数相加整除10，进位+1
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode r = null, head = null;
        boolean isAdd = false;
        while (l1 != null || l2 != null || isAdd) {
            int t1 = 0, t2 = 0, sum, val;
            if (l1 != null) {
                t1 = l1.val;
            }
            if (l2 != null) {
                t2 = l2.val;
            }
            sum = t1 + t2;
            if (isAdd) {
                sum += 1;
            }
            val = sum % 10;
            ListNode t = new ListNode(val);
            if (head == null) {
                head = t;
                r = head;
            } else {
                r.next = t;
                r = t;
            }
            isAdd = sum > 9;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return head;
    }

    /**
     * 初等数学
     * 思路讲解：https://leetcode-cn.com/problems/add-two-numbers/solution/liang-shu-xiang-jia-by-leetcode/
     * 亮点： head作为哨兵节点
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0), curr = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val, y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            curr.next = node;
            curr = node;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (carry > 0) {
            curr.next = new ListNode(1);
        }
        return head.next;
    }

}
