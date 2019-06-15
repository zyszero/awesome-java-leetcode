package com.zys.arts.recursion;

/**
 * @Author: Created by zys
 * @Description:
 * @Date: 2019/3/21 22:38
 * @Modified By:
 */
public class ReverseLinkedList {

     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    class Solution {
       /* public ListNode reverseList(ListNode head) {
            if (head == null){
                return null;
            }
            ListNode tmpHead = head;
            ListNode tmp;
            while (tmpHead.next != null){
                tmp = tmpHead.next;
                tmpHead.next = tmpHead.next.next;
                tmp.next = head;
                head = tmp;
            }
            return head;
        }*/

//        ListNode reverseList(ListNode head) {
//            if (head == null || head.next == null){
//                return head;
//            }
//            ListNode p = reverseList(head.next);
//            head.next.next = head;
//            head.next = null;
//
//            return p;
//        }


        public ListNode reverseList(ListNode head) {
            // 用于记录上一个节点（一开始为null，是为了让单链表的头结点的前驱节点指向NULL）
            ListNode prev = null;
            // 当前节点
            ListNode curr = head;
            // 循环遍历至尾结点
            while(curr != null){
                // 临时节点，保存当前节点的后继节点
                ListNode nextTemp = curr.next;
                // 改变当前节点的后继节点为前驱节点
                curr.next = prev;
                // 移动节点
                prev = curr;
                curr = nextTemp;
            }
            // 返回旧单链表的尾结点（即反转后的新单链表的头结点）
            return prev;
        }
    }
}
