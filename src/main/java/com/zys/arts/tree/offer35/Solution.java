package com.zys.arts.tree.offer35;

import java.util.HashMap;

public class Solution {


    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head, sentinel = new Node(-1), pre = sentinel;
        while (cur != null) {
            Node node;
            if (map.containsKey(cur)) {
                node = map.get(cur);
            } else {
                node = new Node(cur.val);
                map.put(cur, node);
            }
            if (map.containsKey(cur.random)) {
                node.random = map.get(cur.random);
            } else {
                if (cur.random == null) {
                    node.random = null;
                } else {
                    node.random = new Node(cur.random.val);
                    map.put(cur.random, node.random);
                }
            }
            pre.next = node;
            cur = cur.next;
            pre = node;
        }
        return sentinel.next;
    }
}
