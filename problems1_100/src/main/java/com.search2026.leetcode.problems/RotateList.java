package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.ListNode;

public class RotateList {

    /*
        Rotate List
        https://leetcode.com/problems/rotate-list/
        Leetcode #61
        Difficulty: Medium
     */
    public class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null) {
                return head;
            }
            int n = k;
            int listSize = 0;
            ListNode end = head;
            while (k > 0) {
                end = end.next;
                k--;
                listSize++;
                if (end == null) {
                    k = n % listSize;
                    end = head;
                    while (k > 0) {
                        end = end.next;
                        k--;
                    }
                    break;
                }
            }
            if (head == end) {
                return head;
            }
            ListNode start = head;
            while (end.next != null) {
                end = end.next;
                start = start.next;
            }
            end.next = head;
            head = start.next;
            start.next = null;
            return head;
        }
    }

}
