package com.zys.arts.recursion;

/**
 * @Author: Created by zys
 * @Description:
 * @Date: 2019/4/7 22:24
 * @Modified By:
 */
public class BinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Solution1 {
        public int maxDepth(TreeNode root) {
            return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }

    public class Solution2 {
        int max = 0;
        public int maxDepth(TreeNode root) {
            dsf(root, 0);
            return max;
        }


        public void dsf(TreeNode root, int depth){
            if (root == null){
                max = Math.max(max, depth);
                return;
            }

            depth++;
            dsf(root.left, depth);
            dsf(root.right, depth);
        }
    }
}
