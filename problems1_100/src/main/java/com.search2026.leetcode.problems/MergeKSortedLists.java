package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.ListNode;

import java.util.*;

public class MergeKSortedLists {

    /*
        Merge K Sorted Lists - Heap
        Leetcode #23
        https://leetcode.com/problems/merge-k-sorted-lists/
        Difficulty: Hard
     */
    public class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) return null;
            Queue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return Integer.compare(o1.val, o2.val);
                }
            });
            Arrays.stream(lists).filter(Objects::nonNull).forEach(pq::offer);

            ListNode dummy = new ListNode(0);
            ListNode p = dummy;
            while (!pq.isEmpty()) {
                p.next = pq.poll();
                p = p.next;
                if (p.next != null) {
                    pq.offer(p.next);
                }
            }
            return dummy.next;
        }
    }

    /*
        Merge K Sorted Lists - Divide and Conquer
        leetcode #23
        https://leetcode.com/problems/merge-k-sorted-lists/
        Difficulty: Hard
     */
    public class Solution_2 {
        // This function is from Leetcode #21 Merge Two Sorted Lists.
        private ListNode merge(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            if (l1.val < l2.val) {
                l1.next = merge(l1.next, l2);
                return l1;
            } else {
                l2.next = merge(l1, l2.next);
                return l2;
            }
        }

        private ListNode partition(ListNode[] lists, int start, int end) {
            if (start == end) return lists[start];
            if (start < end) {
                int q = (start + end) / 2;
                ListNode l1 = partition(lists, start, q);
                ListNode l2 = partition(lists, q + 1, end);
                return merge(l1, l2);
            } else
                return null;
        }

        public ListNode mergeKLists(ListNode[] lists) {
            return partition(lists, 0, lists.length - 1);
        }
    }

}
