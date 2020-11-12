package com.zys.arts.tree.no0111;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zys
 * @date 2020-11-10 11:36
 */
public class Solution_BFS {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        return bfsMinDepth(queue, 1);
    }

    /**
     * BFS广度优先遍历
     *
     * @param queue
     * @param depth
     * @return
     */
    public int bfsMinDepth(Queue<TreeNode> queue, int depth) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            TreeNode curr = queue.poll();
            if (curr.left == null && curr.right == null) {
                return depth;
            } else {
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
        }
        return bfsMinDepth(queue, depth + 1);
    }
}
