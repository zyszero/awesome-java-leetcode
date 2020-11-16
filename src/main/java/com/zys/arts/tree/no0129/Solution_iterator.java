package com.zys.arts.tree.no0129;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution_iterator {
    /**
     * bfs
     * 二叉树的层次遍历
     * 借助两个Queue来实现
     *
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> valQueue = new LinkedList<>();
        nodeQueue.offer(root);
        valQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode cur = nodeQueue.poll();
            Integer curVal = valQueue.poll();
            if (cur.left == null && cur.right == null) {
                sum += curVal;
                continue;
            }
            if (cur.left != null) {
                nodeQueue.offer(cur.left);
                valQueue.offer(curVal * 10 + cur.left.val);
            }
            if (cur.right != null) {
                nodeQueue.offer(cur.right);
                valQueue.offer(curVal * 10 + cur.right.val);
            }
        }
        return sum;
    }
}
