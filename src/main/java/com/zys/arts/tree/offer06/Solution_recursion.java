package com.zys.arts.tree.offer06;

import java.util.ArrayList;
import java.util.List;

public class Solution_recursion {
    private List<Integer> list = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        recursion(head);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    void recursion(ListNode node) {
        if (node == null) {
            return;
        }
        recursion(node.next);
        list.add(node.val);
    }

}
