package com.zys.arts.tree.no0144;

import java.util.ArrayList;
import java.util.List;

public class Solution_Morris {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode cur1 = root;
        TreeNode cur2;
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    res.add(cur1.val);
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                }
            }else {
                res.add(cur1.val);
            }
            cur1 = cur1.right;
        }
        return res;
    }
}
