package remove_linked_list_elements;

import common.ListNode;

public class RemoveLinkedListElements {

    public class Solution {
        public ListNode removeElements(ListNode head, int val) {
            if (head == null) return null;
            head.next = removeElements(head.next, val);
            return head.val == val ? head.next : head;
        }
    }

    public static class UnitTest {

    }
}
