package com.zys.arts.tree.no0114;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution_iterator {
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                queue.offer(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (cur == null){
                continue;
            }
            cur = cur.right;
        }
        TreeNode pre = queue.poll();
        while (!queue.isEmpty()){
            pre.left = null;
            TreeNode node = queue.poll();
            pre.right = node;
            pre = node;
        }
    }
}
