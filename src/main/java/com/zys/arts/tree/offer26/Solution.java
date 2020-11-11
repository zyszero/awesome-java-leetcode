package com.zys.arts.tree.offer26;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null && B == null){
            return true;
        }
        if (A == null || B == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);
        boolean flag = false;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll == null) {
                continue;
            }

            queue.offer(poll.left);
            queue.offer(poll.right);
            if (poll.val ==  B.val) {
                flag = recur(poll, B);
            }
            if (flag){
                return true;
            }
        }
        return false;
    }

    private boolean recur(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null) {
            return false;
        }

        if (a.val != b.val) {
            return false;
        }
        if (!recur(a.left, b.left)) {
            return false;
        }
        return recur(a.right, b.right);
    }
}
