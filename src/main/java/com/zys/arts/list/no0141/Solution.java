package com.zys.arts.list.no0141;


/**
 * @author zys
 * @date 2020-12-04 11:45
 */
public class Solution {
    /**
     * 1. 可以利用哈希表来实现
     * 2. 快慢指针（最优解）
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head.next, slow = head;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}
