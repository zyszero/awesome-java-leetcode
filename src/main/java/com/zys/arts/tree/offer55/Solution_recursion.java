package com.zys.arts.tree.offer55;

public class Solution_recursion {
    private int max = Integer.MIN_VALUE;

    /**
     * dfs
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return max;
    }

    public void dfs(TreeNode node, int depth) {
        if (node == null) {
            max = Math.max(max, depth);
            return;
        }
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }

}
