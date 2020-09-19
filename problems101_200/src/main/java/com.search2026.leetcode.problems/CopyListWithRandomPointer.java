package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.RandomListNode;

public class CopyListWithRandomPointer {

    /*
        Copy List with Random Pointer
        Leetcode #138
        https://leetcode.com/problems/copy-list-with-random-pointer/
        Difficulty: Hard
     */
    public class Solution {
        public RandomListNode copyRandomList(RandomListNode head) {
            if (head == null) return null;

            RandomListNode p = head;
            while (p != null) {
                RandomListNode next = p.next;
                RandomListNode copy = new RandomListNode(p.label);
                p.next = copy;
                copy.next = next;
                p = next;
            }

            p = head;
            while (p != null) {
                p.next.random = (p.random != null) ? p.random.next : null;
                p = p.next.next;
            }

            p = head;
            RandomListNode headCopy = (p != null) ? p.next : null;
            while (p != null) {
                RandomListNode copy = p.next;
                p.next = copy.next;
                p = p.next;
                copy.next = (p != null) ? p.next : null;
            }
            return headCopy;
        }
    }

}
