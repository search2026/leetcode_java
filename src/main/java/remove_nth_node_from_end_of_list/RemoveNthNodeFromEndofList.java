package remove_nth_node_from_end_of_list;

import common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveNthNodeFromEndofList {
    /*
        Remove Nth Node From End of List
        Leetcode #19
        https://leetcode.com/problems/remove-nth-node-from-end-of-list/
        Difficulty: Easy
     */
    public class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode fast = head;
            while (n > 1) {
                fast = fast.next;
                n--;
            }
            if (fast.next == null) {
                return head.next;
            }
            ListNode slow = head;
            fast = fast.next;
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
            slow.next = slow.next.next;
            return head;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new RemoveNthNodeFromEndofList().new Solution();
            assertEquals(7, 7);
        }
    }
}
