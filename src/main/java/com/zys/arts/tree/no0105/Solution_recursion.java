package com.zys.arts.tree.no0105;

import java.util.HashMap;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 */
public class Solution_recursion {

    private HashMap<Integer, Integer> indexMap;

    /**
     * 借助递归来实现
     * 二叉树前序遍历的顺序为：
     * 先遍历根节点；
     * 随后递归地遍历左子树；
     * 最后递归地遍历右子树。
     * <p>
     * 二叉树中序遍历的顺序为：
     * 先递归地遍历左子树；
     * 随后遍历根节点；
     * 最后递归地遍历右子树。
     * <p>
     * 对于任意一颗树而言，前序遍历的形式总是
     * [ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
     * <p>
     * 即根节点总是前序遍历中的第一个节点。而中序遍历的形式总是
     * [ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
     * 只要我们在中序遍历中定位到根节点，那么我们就可以分别知道左子树和右子树中的节点数目。由于同一颗子树的前序遍历和中序遍历的长度显然是相同的，因此我们就可以对应到前序遍历的结果中，对上述形式中的所有左右括号进行定位。
     * <p>
     * 这样以来，我们就知道了左子树的前序遍历和中序遍历结果，以及右子树的前序遍历和中序遍历结果，我们就可以递归地对构造出左子树和右子树，再将这两颗子树接到根节点的左右位置。
     * <p>
     * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/cong-qian-xu-yu-zhong-xu-bian-li-xu-lie-gou-zao-9/
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, n - 1, 0);
    }

    public TreeNode buildTreeHelper(int[] preorder, int pre_left, int pre_right, int in_left) {
        if (pre_left > pre_right) {
            return null;
        }
        // 构建根节点
        // 获取中序遍历中根节点的位置
        int in_root = indexMap.get(preorder[pre_left]);
        // 构建根节点
        TreeNode root = new TreeNode(preorder[pre_left]);
        // 获得左子树的节点个数
        int size_left_subtree = in_root - in_left;
        // 递归构建左子树
        // 前序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = buildTreeHelper(preorder, pre_left + 1, pre_left + size_left_subtree, in_left);
        // 递归构建右子树
        // 中序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = buildTreeHelper(preorder, pre_left + size_left_subtree + 1, pre_right, in_root + 1);
        return root;
    }


}
