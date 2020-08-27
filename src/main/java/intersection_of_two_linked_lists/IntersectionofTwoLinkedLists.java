package intersection_of_two_linked_lists;

import common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntersectionofTwoLinkedLists {
    /*
        Intersection of Two Linked Lists - Calculate Length
        leetcode #160
        https://leetcode.com/problems/intersection-of-two-linked-lists/
        Difficulty: Easy
     */
    public class Solution {
        private int length(ListNode node) {
            int length = 0;
            while (node != null) {
                node = node.next;
                length++;
            }
            return length;
        }

        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int lenA = length(headA), lenB = length(headB);
            // move headA and headB to the same start point
            while (lenA > lenB) {
                headA = headA.next;
                lenA--;
            }
            while (lenA < lenB) {
                headB = headB.next;
                lenB--;
            }
            // find the intersection until end
            while (headA != headB) {
                headA = headA.next;
                headB = headB.next;
            }
            return headA;
        }
    }

    /*
        Intersection of Two Linked Lists
        leetcode #160
        https://leetcode.com/problems/intersection-of-two-linked-lists/
        Difficulty: Easy
     */
    public class Solution_2 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) return null;
            ListNode tailA = headA;
            while (tailA.next != null) {
                tailA = tailA.next;
            }
            tailA.next = headB;

            // Find the beginning of the cycle
            ListNode fast = headA;
            ListNode slow = headA;
            do {
                if (fast == null || fast.next == null) {
                    tailA.next = null;
                    return null;
                }
                fast = fast.next.next;
                slow = slow.next;
                if (slow == fast) {
                    fast = headA;
                    while (fast != slow) {
                        fast = fast.next;
                        slow = slow.next;
                    }
                    tailA.next = null;
                    return fast;
                }
            } while (true);
        }
    }

    /*
        Intersection of Two Linked Lists
        leetcode #160
        https://leetcode.com/problems/intersection-of-two-linked-lists/
        Difficulty: Easy
     */
    public class Solution_3 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) return null;
            ListNode a = headA, b = headB;

            //if a & b have different len, then we will stop the loop after second iteration
            while (a != b) {
                //for the end of first iteration, we just reset the pointer to the head of another linkedlist
                a = a == null ? headB : a.next;
                b = b == null ? headA : b.next;
            }

            return a;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new IntersectionofTwoLinkedLists().new Solution();
            ListNode node1 = new ListNode(1);
            ListNode node2 = new ListNode(2);
            ListNode node3 = new ListNode(3);
            ListNode node4 = new ListNode(4);
            ListNode node5 = new ListNode(5);
            ListNode node6 = new ListNode(6);
            ListNode node7 = new ListNode(7);
            ListNode node8 = new ListNode(8);
            ListNode node9 = new ListNode(9);
            node1.next = node3;
            node3.next = node5;
            node5.next = node7;
            node7.next = node9;
            node2.next = node3;
            ListNode res = sol.getIntersectionNode(node1, node2);
            assertEquals(3, (int)res.val);
            node2.next = node4;
            node4.next = node6;
            node6.next = node8;
            node8.next = node9;
            res = sol.getIntersectionNode(node1, node2);
            assertEquals(9, (int)res.val);
        }

        @Test
        public void test2() {
            Solution_2 sol = new IntersectionofTwoLinkedLists().new Solution_2();
            ListNode node1 = new ListNode(1);
            ListNode node2 = new ListNode(2);
            ListNode node3 = new ListNode(3);
            ListNode node4 = new ListNode(4);
            ListNode node5 = new ListNode(5);
            ListNode node6 = new ListNode(6);
            ListNode node7 = new ListNode(7);
            ListNode node8 = new ListNode(8);
            ListNode node9 = new ListNode(9);
            node1.next = node3;
            node3.next = node5;
            node5.next = node7;
            node7.next = node9;
            node2.next = node3;
            ListNode res = sol.getIntersectionNode(node1, node2);
            assertEquals(3, (int)res.val);
            node2.next = node4;
            node4.next = node6;
            node6.next = node8;
            node8.next = node9;
            res = sol.getIntersectionNode(node1, node2);
            assertEquals(9, (int)res.val);
        }

        @Test
        public void test3() {
            Solution_3 sol = new IntersectionofTwoLinkedLists().new Solution_3();
            ListNode node1 = new ListNode(1);
            ListNode node2 = new ListNode(2);
            ListNode node3 = new ListNode(3);
            ListNode node4 = new ListNode(4);
            ListNode node5 = new ListNode(5);
            ListNode node6 = new ListNode(6);
            ListNode node7 = new ListNode(7);
            ListNode node8 = new ListNode(8);
            ListNode node9 = new ListNode(9);
            node1.next = node3;
            node3.next = node5;
            node5.next = node7;
            node7.next = node9;
            node2.next = node3;
            ListNode res = sol.getIntersectionNode(node1, node2);
            assertEquals(3, (int)res.val);
            node2.next = node4;
            node4.next = node6;
            node6.next = node8;
            node8.next = node9;
            res = sol.getIntersectionNode(node1, node2);
            assertEquals(9, (int)res.val);
        }
    }
}