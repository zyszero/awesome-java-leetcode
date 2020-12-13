package com.zys.arts.tree.no0617;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zys
 * @date 2020-11-20 16:00
 */
public class Solution_iterator {
    /**
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(t1);
        queue.offer(t2);
        while (!queue.isEmpty()) {
            TreeNode q1 = queue.remove();
            TreeNode q2 = queue.remove();
            q1.val += q2.val;
            if (q1.left != null && q2.left != null) {
                queue.offer(q1.left);
                queue.offer(q2.left);
            } else if (q1.left == null) {
                q1.left = q2.left;
            }

            if (q1.right != null && q2.right != null) {
                queue.offer(q1.right);
                queue.offer(q2.right);
            } else if (q1.right == null) {
                q1.right = q2.right;
            }
        }
        return t1;
    }
}
