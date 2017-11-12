package intersection_of_two_linked_lists;

import common.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntersectionofTwoLinkedLists {
    /*
        Intersection of Two Linked Lists
        leetcode #160
        https://leetcode.com/problems/intersection-of-two-linked-lists/
        Difficulty: Easy
     */
    public class Solution {
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
    public class Solution_2 {
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
            assertEquals(3, 3);
        }
    }
}