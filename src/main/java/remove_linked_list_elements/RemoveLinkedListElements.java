package remove_linked_list_elements;

import common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveLinkedListElements {
    /*
        Remove Linked List Elements
        Leetcode #203
        https://leetcode.com/problems/remove-linked-list-elements/
        Difficulty: Easy
     */
    public class Solution {
        public ListNode removeElements(ListNode head, int val) {
            if (head == null) return null;
            head.next = removeElements(head.next, val);
            return head.val == val ? head.next : head;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new RemoveLinkedListElements().new Solution();
            assertEquals(7, 7);
        }
    }
}
