package com.zys.arts.tree.offer54;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zys
 * @date 2020-11-24 12:39
 */
public class Solution_iterator {

    public int kthLargest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.right;
            }
            cur = stack.pollLast();
            if (--k == 0) {
                return cur.val;
            }
            cur = cur.left;
        }
        return 0;
    }

}
