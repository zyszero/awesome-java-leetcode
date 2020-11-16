package com.zys.arts.tree.no0543;

public class Solution_recursion {
    private int max;

    /**
     * 分解问题：
     * 1. 求任意两结点之间的最短路径，即是两结点的根结点到这两结点的最短路径之和，即是根节点左右子树的深度之和 node = l + r
     * 2. 求任意两个结点路径长度中的最大值 即 max(node)
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = depth(node.left);
        int r = depth(node.right);
        max = Math.max(max, l + r);
        return Math.max(l, r) + 1;
    }
}
