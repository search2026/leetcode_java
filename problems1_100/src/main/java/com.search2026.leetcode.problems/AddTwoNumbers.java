package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.ListNode;

public class AddTwoNumbers {

    /*
        Add Two Numbers
        Leetcode #2
        https://leetcode.com/problems/add-two-numbers/
        Difficulty: Medium
     */
    public static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            ListNode dummy = new ListNode(0);
            ListNode p = dummy;
            int carry = 0;
            while (l1 != null || l2 != null || carry > 0) {
                int x = (l1 == null) ? 0 : l1.val;
                int y = (l2 == null) ? 0 : l2.val;
                int sum = x + y + carry;
                p.next = new ListNode(sum % 10);
                carry = sum / 10;
                p = p.next;
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }

            return dummy.next;
        }
    }

}
