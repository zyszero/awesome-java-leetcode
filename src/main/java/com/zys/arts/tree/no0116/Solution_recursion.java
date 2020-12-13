package com.zys.arts.tree.no0116;

public class Solution_recursion {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            root.left.next = root.right;
            // 因为是完美二叉树，所以非叶子节点必有左右节点
            root.right.next = root.next != null ? root.next.left : null;
            connect(root.left);
            connect(root.right);
        }
        return root;
    }
}
