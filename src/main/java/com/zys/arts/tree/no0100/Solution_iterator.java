package com.zys.arts.tree.no0100;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zys
 * @date 2020-11-10 10:32
 */
public class Solution_iterator {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()) {
            TreeNode p1 = queue.poll();
            TreeNode q1 = queue.poll();
            if (p1 == null && q1 == null) {
                continue;
            }
            if (p1 == null || q1 == null) {
                return false;
            }
            if (p1.val != q1.val) {
                return false;
            }
            queue.offer(p1.left);
            queue.offer(q1.left);
            queue.offer(p1.right);
            queue.offer(q1.right);
        }
        return true;
    }
}
