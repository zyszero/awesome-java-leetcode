package com.zys.arts.list.no0023;

/**
 * @author zys
 * @date 2020-12-04 13:18
 */
public class Solution_divideMerge {

    /**
     * 分治合并，利用递归来实现
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (r + 1) >> 1;
        return mergeList(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public ListNode mergeList(ListNode n1, ListNode n2) {
        if (n1 == null || n2 == null) {
            return n1 != null ? n1 : n2;
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
        cur.next = n1 != null ? n1 : n2;
        return target.next;
    }
}
