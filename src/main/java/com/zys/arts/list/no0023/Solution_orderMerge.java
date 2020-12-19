package com.zys.arts.list.no0023;

/**
 * @author zys
 * @date 2020-12-04 13:17
 */
public class Solution_orderMerge {
    /**
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode target = null;
        for (ListNode list : lists) {
            target = mergeList(target, list);
        }
        return target;
    }

    public ListNode mergeList(ListNode n1, ListNode n2) {
        if (n1 == null || n2 == null) {
            return n1 == null ? n2 : n1;
        }
        ListNode target = new ListNode(), cur = target;
        while (n1 != null && n2 != null) {
            if (n1.val > n2.val) {
                cur.next = n2;
                n2 = n2.next;
            } else {
                cur.next = n1;
                n1 = n1.next;
            }
            cur = cur.next;
        }
        cur.next = n1 == null ? n2 : n1;
        return target.next;
    }
}
