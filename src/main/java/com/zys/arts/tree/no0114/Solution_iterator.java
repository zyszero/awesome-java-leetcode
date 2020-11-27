package com.zys.arts.tree.no0114;

import java.util.Stack;

/**
 * @author zys
 * @date 2020-11-20 12:08
 */
public class Solution_iterator {
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.peek();
            // 在不存在左节点或者右节点已经访问的情况下
            if (cur.left == null || cur.left == pre) {
                stack.pop();
                cur.right = pre;
                cur.left = null;
                pre = cur;
                cur = null;
            } else {
                cur = cur.left;
            }
        }
    }
}
