package com.zys.arts.tree.no0112;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution_iterator {
    /**
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> accumQueue= new LinkedList<>();
        queue.offer(root);
        accumQueue.offer(root.val);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int accum = accumQueue.poll();
            if (cur.left == null && cur.right == null) {
                if (accum == sum) {
                    return true;
                }
                continue;
            }
            if (cur.left != null) {
                queue.offer(cur.left);
                accumQueue.offer(accum + cur.left.val);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                accumQueue.offer(accum + cur.right.val);
            }
        }
        return false;
    }
}
