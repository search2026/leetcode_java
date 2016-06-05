package reverse_linked_list;

import common.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ReverseLinkedList {
    /*
        Reverse Linked List
        Leetcode #206
        https://leetcode.com/problems/reverse-linked-list/
        Difficulty: Easy
     */
    public class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            while (head != null) {
                ListNode temp = head.next;
                head.next = prev;
                prev = head;
                head = temp;
            }
            return prev;
        }
    }

    /*
        Reverse Linked List II
        Leetcode #92
        https://leetcode.com/problems/reverse-linked-list-ii/
        Difficulty: Medium
     */
    public class Solution_2 {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (m >= n || head == null) {
                return head;
            }

            ListNode dummy = new ListNode(0);
            dummy.next = head;
            head = dummy;

            for (int i = 1; i < m; i++) {
                if (head == null) return null;
                head = head.next;
            }

            ListNode premNode = head;
            ListNode mNode = head.next;
            ListNode nNode = mNode, postnNode = mNode.next;
            for (int i = m; i < n; i++) {
                if (postnNode == null) return null;
                ListNode temp = postnNode.next;
                postnNode.next = nNode;
                nNode = postnNode;
                postnNode = temp;
            }
            mNode.next = postnNode;
            premNode.next = nNode;

            return dummy.next;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new ReverseLinkedList().new Solution();
            assertTrue(true);
        }
    }
}

