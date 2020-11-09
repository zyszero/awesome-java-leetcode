package com.zys.arts.tree.no0098;

/**
 * @author zys
 * @date 2020-11-09 11:34
 */
public class Solution {

    private long prev = Long.MIN_VALUE;

    /**
     * 递归 - 中序遍历
     * 根据BST的特性，遍历结果是升序的，所以当前节点的值，必然比前一个节点的值，否则就不是BST
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= prev) {
            return false;
        }
        prev = root.val;
        return isValidBST(root.right);
    }
}
