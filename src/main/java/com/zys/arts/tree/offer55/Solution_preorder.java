package com.zys.arts.tree.offer55;

/**
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * <p>
 * 示例 2:
 * <p>
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 * <p>
 * 链接：https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof
 *
 * @author zys
 * @date 2020-11-25 10:22
 */
public class Solution_preorder {
    /**
     *
     * 递归：
     *  |depth(root.left) - depth(root.right)| <= 1
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        return  isBalanced(root.left) && isBalanced(root.right) && Math.abs(depth(root.left) - depth(root.right)) <= 1;
    }

    public int depth(TreeNode node){
        if (node == null){
            return 0;
        }
        return Math.max(depth(node.left) + 1, depth(node.right) + 1);
    }
}
