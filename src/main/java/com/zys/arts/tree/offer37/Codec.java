package com.zys.arts.tree.offer37;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zys
 * @date 2020-11-26 11:18
 */
public class Codec {

    public String serialize(TreeNode root) {
        if(root == null) return "[]";
        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>() {{ add(root); }};
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node != null) {
                res.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            }
            else {
                res.append("null,");
            }
        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    public TreeNode deserialize(String data) {
        if("[]".equals(data)) {
            return null;
        }
        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>() {{ add(root); }};
        int i = 1;
        int length = vals.length;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(i < length &&!"null".equals(vals[i])) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;
            if(i < length && !"null".equals(vals[i])) {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        System.out.println(codec.serialize(codec.deserialize("[1,2,3,1,3,2,4]")));
    }
}