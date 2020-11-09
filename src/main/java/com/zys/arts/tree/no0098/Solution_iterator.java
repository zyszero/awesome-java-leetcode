package com.zys.arts.tree.no0098;

import java.util.Stack;

/**
 * @author zys
 * @date 2020-11-09 14:46
 */
public class Solution_iterator {
    /**
     * 利用栈来实现中序遍历
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        long pre = Long.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre >= root.val) {
                return false;
            }
            pre = root.val;
            root = root.right;
        }
        return true;
    }
}
