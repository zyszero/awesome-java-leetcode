package com.zys.arts.tree.no0114;

public class Solution {
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                // 找到左子树的最右边的节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                // 将原来右子树的节点接到左子树的最右边节点的右节点上
                pre.right = root.right;
                // 将左子树插入右子树的位置
                root.right = root.left;
                root.left = null;
                // 到下一个节点
                root = root.right;
            }
        }
    }
}
