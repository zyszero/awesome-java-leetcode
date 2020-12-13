package com.zys.arts.tree.no0116;

public class Solution_iterator {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node leftmost = root;
        while (leftmost.left != null) {
            Node head = leftmost;
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                // 指针后移
                head = head.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }
}
