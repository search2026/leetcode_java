package merge_k_sorted_lists;

import common.ListNode;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergekSortedLists {
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
                    if (o1.val < o2.val)
                        return -1;
                    else if (o1.val == o2.val)
                        return 0;
                    else
                        return 1;
                }
            });
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    pq.offer(lists[i]);
                }
            }

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
        //This function is from Leetcode #21 Merge Two Sorted Lists.
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

        private ListNode partion(ListNode[] lists, int start, int end) {
            if (start == end) return lists[start];
            if (start < end) {
                int q = (start + end) / 2;
                ListNode l1 = partion(lists, start, q);
                ListNode l2 = partion(lists, q + 1, end);
                return merge(l1, l2);
            } else
                return null;
        }

        public ListNode mergeKLists(ListNode[] lists) {
            return partion(lists, 0, lists.length - 1);
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new MergekSortedLists().new Solution();
            ListNode list1 = new ListNode(1);
            list1.next = new ListNode(3);
            list1.next.next = new ListNode(6);
            ListNode list2 = new ListNode(2);
            list2.next = new ListNode(4);
            ListNode list3 = new ListNode(5);
            ListNode[] lists = {list1, list2, list3};
            ListNode mergered = sol.mergeKLists(lists);
            assertEquals(1, mergered.val);
            assertEquals(2, mergered.next.val);
            assertEquals(3, mergered.next.next.val);
            assertEquals(4, mergered.next.next.next.val);
            assertEquals(5, mergered.next.next.next.next.val);
            assertEquals(6, mergered.next.next.next.next.next.val);
        }

        @Test
        public void test2() {
            Solution_2 sol = new MergekSortedLists().new Solution_2();
            ListNode list1 = new ListNode(1);
            list1.next = new ListNode(3);
            list1.next.next = new ListNode(6);
            ListNode list2 = new ListNode(2);
            list2.next = new ListNode(4);
            ListNode list3 = new ListNode(5);
            ListNode[] lists = {list1, list2, list3};
            ListNode mergered = sol.mergeKLists(lists);
            assertEquals(1, mergered.val);
            assertEquals(2, mergered.next.val);
            assertEquals(3, mergered.next.next.val);
            assertEquals(4, mergered.next.next.next.val);
            assertEquals(5, mergered.next.next.next.next.val);
            assertEquals(6, mergered.next.next.next.next.next.val);
        }
    }
}
