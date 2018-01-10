package swap_nodes_in_pairs;

import common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwapNodesinPairs {
    /*
        Swap Nodes in Pairs - Iterative
        Leetcode #24
        https://leetcode.com/problems/swap-nodes-in-pairs/
        Difficulty: Medium
     */
    public class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) return head;

            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode p = dummy;

            while (p.next != null && p.next.next != null) {
                ListNode first = p.next;
                ListNode second = p.next.next;
                first.next = second.next;
                p.next = second;
                second.next = first;
                p = first;
            }

            return dummy.next;
        }
    }

    /*
        Swap Nodes in Pairs - Iterative with previous pointer
        Leetcode #24
        https://leetcode.com/problems/swap-nodes-in-pairs/
        Difficulty: Medium
     */
    public class Solution_2 {
        public ListNode swapPairs(ListNode head) {
            if ((head == null) || (head.next == null)) return head;
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode p = head;
            ListNode prev = dummy;
            while (p != null && p.next != null) {
                prev.next = p.next;
                prev = p;
                p = p.next.next;
                prev.next.next = prev;
            }
            prev.next = p;
            return dummy.next;
        }
    }

    /*
        Swap Nodes in Pairs - Recursion
        Leetcode #24
        https://leetcode.com/problems/swap-nodes-in-pairs/
        Difficulty: Medium
     */
    public class Solution_3 {
        public ListNode swapPairs(ListNode head) {
            if ((head == null) || (head.next == null)) return head;
            ListNode n = head.next;
            head.next = swapPairs(head.next.next);
            n.next = head;
            return n;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new SwapNodesinPairs().new Solution();
            ListNode root = new ListNode(1);
            root.next = new ListNode(2);
            root.next.next = new ListNode(3);
            root.next.next.next = new ListNode(4);
            ListNode reversed = sol.swapPairs(root);
            assertEquals(2, reversed.val);
            assertEquals(1, reversed.next.val);
            assertEquals(4, reversed.next.next.val);
            assertEquals(3, reversed.next.next.next.val);
        }

        @Test
        public void test2() {
            Solution_2 sol = new SwapNodesinPairs().new Solution_2();
            ListNode root = new ListNode(1);
            root.next = new ListNode(2);
            root.next.next = new ListNode(3);
            root.next.next.next = new ListNode(4);
            ListNode reversed = sol.swapPairs(root);
            assertEquals(2, reversed.val);
            assertEquals(1, reversed.next.val);
            assertEquals(4, reversed.next.next.val);
            assertEquals(3, reversed.next.next.next.val);
        }

        @Test
        public void test3() {
            Solution_3 sol = new SwapNodesinPairs().new Solution_3();
            ListNode root = new ListNode(1);
            root.next = new ListNode(2);
            root.next.next = new ListNode(3);
            root.next.next.next = new ListNode(4);
            ListNode reversed = sol.swapPairs(root);
            assertEquals(2, reversed.val);
            assertEquals(1, reversed.next.val);
            assertEquals(4, reversed.next.next.val);
            assertEquals(3, reversed.next.next.next.val);
        }
    }
}
