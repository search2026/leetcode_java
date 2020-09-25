package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.ListNode;

public class IntersectionOfTwoLinkedLists {

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

}
