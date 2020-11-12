package com.zys.arts.tree.no0111;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zys
 * @date 2020-11-10 11:13
 */
public class Solution_iterator {

    static class QueueNode {
        private int depth;
        private TreeNode treeNode;

        public QueueNode(int depth, TreeNode treeNode) {
            this.depth = depth;
            this.treeNode = treeNode;
        }
    }

    /**
     * BFS 广度优先遍历
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<QueueNode> queue = new LinkedList<>();
        QueueNode rootNode = new QueueNode(1, root);
        queue.offer(rootNode);
        while (!queue.isEmpty()) {
            QueueNode curQueueNode = queue.poll();
            TreeNode cur = curQueueNode.treeNode;
            int depth = curQueueNode.depth;
            if (cur.left == null && cur.right == null) {
                return depth;
            }
            if (cur.left != null) {
                queue.offer(new QueueNode(depth + 1, cur.left));
            }
            if (cur.right != null) {
                queue.offer(new QueueNode(depth + 1, cur.right));
            }
        }
        return 0;
    }
}
