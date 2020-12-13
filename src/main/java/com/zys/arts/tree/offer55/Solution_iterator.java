package com.zys.arts.tree.offer55;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution_iterator {
    /**
     * bfs
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = 0, depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left == null && cur.right == null) {
                    max = Math.max(max, depth);
                    continue;
                }
                if (cur.left != null){
                    queue.offer(cur.left);
                }
                if (cur.right != null){
                    queue.offer(cur.right);
                }
            }
        }
        return max;
    }
}
