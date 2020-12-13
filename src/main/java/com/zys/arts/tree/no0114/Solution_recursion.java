package com.zys.arts.tree.no0114;

/**
 * 给定一个二叉树，原地将它展开为一个单链表。
 * <p>
 *  
 * <p>
 * 例如，给定二叉树
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * 将其展开为：
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 * <p>
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 *
 * @author zys
 * @date 2020-11-20 12:04
 */
public class Solution_recursion {
    private TreeNode pre = null;

    /**
     * 后序遍历的变形
     * 题目中，要求说是 in-place，之前一直以为这个意思就是要求空间复杂度是 O(1)O(1)。偶然看见评论区大神的解释， in-place 的意思可能更多说的是直接在原来的节点上改变指向，空间复杂度并没有要求。所以这道题也可以用递归解一下。
     * <p>
     * Java
     * <p>
     * 1
     * / \
     * 2   5
     * / \   \
     * 3   4   6
     * 利用递归的话，可能比解法一难理解一些。
     * <p>
     * 题目其实就是将二叉树通过右指针，组成一个链表。
     * <p>
     * Java
     * <p>
     * 1 -> 2 -> 3 -> 4 -> 5 -> 6
     * 我们知道题目给定的遍历顺序其实就是先序遍历的顺序，所以我们能不能利用先序遍历的代码，每遍历一个节点，就将上一个节点的右指针更新为当前节点。
     * <p>
     * 先序遍历的顺序是 1 2 3 4 5 6。
     * <p>
     * 遍历到 2，把 1 的右指针指向 2。1 -> 2 3 4 5 6。
     * <p>
     * 遍历到 3，把 2 的右指针指向 3。1 -> 2 -> 3 4 5 6。
     * <p>
     * ... ...
     * <p>
     * 一直进行下去似乎就解决了这个问题。但现实是残酷的，原因就是我们把 1 的右指针指向 2，那么 1 的原本的右孩子就丢失了，也就是 5 就找不到了。
     * <p>
     * 解决方法的话，我们可以逆过来进行。
     * <p>
     * 我们依次遍历 6 5 4 3 2 1，然后每遍历一个节点就将当前节点的右指针更新为上一个节点。
     * <p>
     * 遍历到 5，把 5 的右指针指向 6。6 <- 5 4 3 2 1。
     * <p>
     * 遍历到 4，把 4 的右指针指向 5。6 <- 5 <- 4 3 2 1。
     * <p>
     * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--26/
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        dfs(root);
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.right);
        dfs(node.left);
        node.right = pre;
        node.left = null;
        pre = node;
    }
}
