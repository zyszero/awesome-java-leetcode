package com.zys.arts.tree.no0404;

/**
 * @author zys
 * @date 2020-11-20 14:35
 */
public class Solution {
    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root, root);
        return sum;
    }

    public void dfs(TreeNode node, TreeNode pre) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (node == pre.left) {
                sum += node.val;
            }
        }
        dfs(node.left, node);
        dfs(node.right, node);
    }
}
