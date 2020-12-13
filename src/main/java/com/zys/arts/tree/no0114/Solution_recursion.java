package com.zys.arts.tree.no0114;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 *  
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 */
public class Solution_recursion {
    public void flatten(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        dfs(root, queue);
        TreeNode pre = queue.poll();
        while (!queue.isEmpty()){
            pre.left = null;
            TreeNode cur = queue.poll();
            pre.right = cur;
            pre = cur;
        }
    }

    public void dfs(TreeNode node, Queue<TreeNode> queue) {
        if(node == null){
            return;
        }
        queue.offer(node);
        dfs(node.left, queue);
        dfs(node.right, queue);
    }
}
