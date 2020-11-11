package com.zys.arts.tree.no0112;

/**
 * 112. 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */
public class Solution_recursion {
    /**
     * dfs
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, sum, 0);
    }

    public boolean dfs(TreeNode node, int sum, int accum) {
        if (node == null){
            return false;
        }
        if (node.left == null && node.right == null) {
            return sum == (node.val + accum);
        }
        return dfs(node.left, sum, accum + node.val) || dfs(node.right, sum, accum + node.val);
    }
}
