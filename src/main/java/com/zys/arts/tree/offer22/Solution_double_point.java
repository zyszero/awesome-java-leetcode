package com.zys.arts.tree.offer22;

public class Solution_double_point {
    /**
     * 双指针：设置快慢指针，快指针先移动K位，然后快慢指针同时移动，直至快指针等于null
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        int i = 0;
        while (fast != null) {
            if (i >= k) {
                slow = slow.next;
            }
            fast = fast.next;
            i++;
        }
        return slow;
    }
}
