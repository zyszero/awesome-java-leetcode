package com.zys.arts.list;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: zys
 * @date: 2020/2/6 11:55
 * @see <a href="https://leetcode.com/problems/merge-k-sorted-lists/">Merge k Sorted Lists</a>
 */
public class MergeKSortedLists {

    /**
     * 暴力破解也行
     * 采用 优先级队列 或者 归并排序来做
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(p -> p.val));
        for (ListNode node : lists) {
            if (node != null){
                queue.add(node);
            }
        }
        ListNode head = queue.poll();
        ListNode tmp = head;
        while (!queue.isEmpty()) {
            if (tmp.next != null) {
                queue.add(tmp.next);
            }
            ListNode node = queue.poll();
            tmp.next = node;
            tmp = node;
        }
        return head;
    }

    /**
     * 归并排序
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        mergeSort(lists, 0, lists.length);
        return lists[0];
    }

    private void mergeSort(ListNode[] lists, int start, int end) {
        if (end > start) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(lists, start, mid);
        mergeSort(lists, mid + 1, end);
        merge(lists, start, mid, end);
    }

    private void merge(ListNode[] lists, int start, int mid, int end) {
        ListNode[] mergeNodes = new ListNode[end + 1];
        int q = mid + 1;
        int k = 0;
        while (start <= mid && q <= end) {
            if (lists[start].val > lists[q].val) {
                mergeNodes[k++] = lists[q++];
            } else {
                mergeNodes[k++] = lists[start++];
            }
        }
        int j = mid;
        if (start > mid) {
            start = q;
            j = end;
        }
        while (start <= j) {
            mergeNodes[k++] = lists[start++];
        }
        System.arraycopy(mergeNodes, 0, lists, 0, lists.length);
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(p -> p));
        queue.add(1);
        queue.add(2);
        Integer poll = queue.poll();
        System.out.println(poll);
    }
}
