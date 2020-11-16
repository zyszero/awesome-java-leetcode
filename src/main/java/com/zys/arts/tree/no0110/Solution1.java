package com.zys.arts.tree.no0110;

public class Solution1 {
    /**
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight, rightHeight;
        if ((leftHeight = height(node.left)) == -1
                || (rightHeight = height(node.right)) == -1
                || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
