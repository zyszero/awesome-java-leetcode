package com.zys.arts.tree.no0404;

import java.util.Stack;

/**
 * @author zys
 * @date 2020-11-20 14:44
 */
public class Solution_iterator {
    public int sumOfLeftLeaves(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> preStack = new Stack<>();
        preStack.push(root);
        TreeNode cur = root;
        int sum = 0;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                preStack.push(root);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            preStack.pop();
            if (cur.left == null && cur.right == null) {
                if (cur == preStack.peek().left) {
                    sum += cur.val;
                }
            }
            cur = cur.right;
        }
        return sum;
    }
}
