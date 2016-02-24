package merge_k_sorted_lists;

import common.ListNode;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

public class MergekSortedLists {
    /*
        Merge K Sorted Lists
        https://leetcode.com/problems/merge-k-sorted-lists/
        leetcode 23
        Difficulty: Hard
     */
    public class Solution {
        private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
            public int compare(ListNode left, ListNode right) {
                if (left == null) {
                    return 1;
                } else if (right == null) {
                    return -1;
                }
                return left.val - right.val;
            }
        };

        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) return null;

            Queue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, ListNodeComparator);
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    pq.add(lists[i]);
                }
            }

            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;
            while (!pq.isEmpty()) {
                ListNode head = pq.poll();
                tail.next = head;
                tail = head;
                if (head.next != null) {
                    pq.add(head.next);
                }
            }
            return dummy.next;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new MergekSortedLists().new Solution();
            assertEquals(3, 3);
        }
    }
}
