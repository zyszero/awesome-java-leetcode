package com.zys.arts.recursion;

/**
 * @Author: Created by zys
 * @Description:
 * @Date: 2019/3/18 23:13
 * @Modified By:
 */
public class SwapPairs {
    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode tmp = head;
            head = head.next;
            tmp.next = swapPairs(head.next);
            head.next = tmp;
            return head;
        }
    }

}
