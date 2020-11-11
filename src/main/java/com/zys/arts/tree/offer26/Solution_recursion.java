package com.zys.arts.tree.offer26;

public class Solution_recursion {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean recur(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null || (a.val != b.val)) {
            return false;
        }
        return recur(a.left, b.left) && recur(a.right, b.right);
    }
}
