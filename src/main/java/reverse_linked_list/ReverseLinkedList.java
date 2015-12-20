package reverse_linked_list;

import common.ListNode;

public class ReverseLinkedList {

    public class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode reversed = null;
            ListNode p = head;
            while (p != null) {
                ListNode temp = p.next;
                p.next = reversed;
                reversed = p;
                p = temp;
            }
            return reversed;
        }

        // Reverse Linked List II
        public ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode prefix = dummy;
            int count = n - m + 1;
            m--;
            while (m > 0) {
                prefix = prefix.next;
                m--;
            }
            ListNode pre = null;
            ListNode p = prefix.next;
            ListNode reversedTail = p;
            while (count > 0) {
                ListNode temp = p.next;
                p.next = pre;
                pre = p;
                p = temp;
                count--;
            }
            prefix.next = pre;
            if (reversedTail != null) {
                reversedTail.next = p;
            }
            return dummy.next;
        }
    }
}

