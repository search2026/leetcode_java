package remove_duplicates_from_sorted_list;

import common.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveDuplicatesfromSortedList {
    /*
        Remove Duplicates from Sorted List
        https://leetcode.com/problems/remove-duplicates-from-sorted-list/
        leetcode 83
        Difficulty: Easy
     */
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
    }

    /*
        Remove Duplicates from Sorted List
        https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
        leetcode 82
        Difficulty: Medium
     */
    public class Solution_2 {
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
        @Test
        public void test1() {
            Solution sol = new RemoveDuplicatesfromSortedList().new Solution();
            assertEquals(7, 7);
        }
    }
}
