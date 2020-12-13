package com.zys.arts.tree.offer27;

public class Solution_recursion {
    /**
     * 递归公式：
     * root.left = root.right;
     * root.right = root.left;
     *
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp;
        temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }
}
