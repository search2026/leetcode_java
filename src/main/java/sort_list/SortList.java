package sort_list;

import common.ListNode;

public class SortList {
    /*
        Sort List
        https://leetcode.com/problems/sort-list/
        Difficulty: Medium
     */
    public class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            // find the middle point
            ListNode slow = head;
            ListNode fast = head;

            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode leftHead = head;
            ListNode rightHead = slow.next;

            slow.next = null;

            // recursively merge
            leftHead = sortList(leftHead);
            rightHead = sortList(rightHead);

            return merge(leftHead, rightHead);
        }

        private ListNode merge(ListNode leftHead, ListNode rightHead) {
            ListNode newHead = new ListNode(0);
            ListNode curr = newHead;

            while (leftHead != null || rightHead != null) {
                if (leftHead == null) {
                    curr.next = rightHead;
                    break;
                }

                if (rightHead == null) {
                    curr.next = leftHead;
                    break;
                }

                if (leftHead.val <= rightHead.val) {
                    curr.next = leftHead;
                    leftHead = leftHead.next;
                    curr = curr.next;
                } else {
                    curr.next = rightHead;
                    rightHead = rightHead.next;
                    curr = curr.next;
                }
            }

            return newHead.next;
        }
    }

    public static class UnitTest {
    }
}
