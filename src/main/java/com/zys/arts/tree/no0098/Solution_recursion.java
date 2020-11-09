package com.zys.arts.tree.no0098;

/**
 * @author zys
 * @date 2020-11-09 14:57
 */
public class Solution_recursion {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root, null, null);
    }

    /**
     * 要解决这道题首先我们要了解二叉搜索树有什么性质可以给我们利用，由题目给出的信息我们可以知道：如果该二叉树的左子树不为空，则左子树上所有节点的值均小于它的根节点的值； 若它的右子树不空，则右子树上所有节点的值均大于它的根节点的值；它的左右子树也为二叉搜索树。
     * <p>
     * 这启示我们设计一个递归函数 helper(root, lower, upper) 来递归判断，函数表示考虑以 root 为根的子树，判断子树中所有节点的值是否都在 (l,r)(l,r) 的范围内（注意是开区间）。如果 root 节点的值 val 不在 (l,r)(l,r) 的范围内说明不满足条件直接返回，否则我们要继续递归调用检查它的左右子树是否满足，如果都满足才说明这是一棵二叉搜索树。
     * <p>
     * 那么根据二叉搜索树的性质，在递归调用左子树时，我们需要把上界 upper 改为 root.val，即调用 helper(root.left, lower, root.val)，因为左子树里所有节点的值均小于它的根节点的值。同理递归调用右子树时，我们需要把下界 lower 改为 root.val，即调用 helper(root.right, root.val, upper)。
     * <p>
     * 函数递归调用的入口为 helper(root, -inf, +inf)， inf 表示一个无穷大的值。
     * <p>
     * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree/solution/yan-zheng-er-cha-sou-suo-shu-by-leetcode-solution/
     *
     * @param node
     * @param lower
     * @param upper
     * @return
     */
    private boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }

        if (lower != null && lower >= node.val) {
            return false;
        }
        if (upper != null && upper <= node.val) {
            return false;
        }
        if (!helper(node.right, node.val, upper)) {
            return false;
        }
        return helper(node.left, lower, node.val);
    }

    public static void main(String[] args) {

    }
}
