package remove_duplicates_from_sorted_list;

import common.ListNode;

public class RemoveDuplicatesfromSortedList {

    public class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head != null) {
                ListNode pre = head;
                ListNode p = pre.next;
                while (p != null) {
                    if (p.val == pre.val) {
                        pre.next = p.next;
                    } else {
                        pre = p;
                    }
                    p = p.next;
                }
            }
            return head;
        }

        // Remove Duplicates from Sorted List II
        public ListNode deleteDuplicatesII(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode pre = null;
            int count = 1;
            ListNode p = head;
            while (p.next != null) {
                if (p.next.val == p.val) {
                    count++;
                } else if (count == 1) {
                    if (pre == null) {
                        head = p;
                    }
                    pre = p;
                } else {
                    if (pre != null) {
                        pre.next = p.next;
                    }
                    count = 1;
                }
                p = p.next;
            }
            if (count == 1) {
                if (pre == null) {
                    return p;
                } else {
                    return head;
                }
            }
            if (pre == null) {
                return null;
            }
            pre.next = null;
            return head;
        }
    }

    public static class UnitTest {

    }
}
