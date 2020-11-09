package com.zys.arts.tree.no0094;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zys
 * @date 2020-11-09 10:56
 */
public class Solution_iterator {
    /**
     * 利用栈来做中序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;
    }


}
