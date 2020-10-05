package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PalindromeLinkedListTests {

    @Test
    public void test1() {
        PalindromeLinkedList.Solution sol = new PalindromeLinkedList().new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        assertFalse(sol.isPalindrome(head));
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        assertTrue(sol.isPalindrome(head));
    }

}
