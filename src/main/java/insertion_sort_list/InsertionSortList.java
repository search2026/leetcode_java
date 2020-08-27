package insertion_sort_list;

import common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsertionSortList {
    /*
        Insert Sort List
        leetcode #147
        https://leetcode.com/problems/insertion-sort-list/
        Difficulty: Medium
     */
    public class Solution {
        public ListNode insertionSortList(ListNode head) {
            ListNode dummy = new ListNode(0);
            ListNode p = head;
            while (p != null) {
                ListNode pre = dummy;
                while (pre.next != null) {
                    if (pre.next.val <= p.val) {
                        pre = pre.next;
                    } else {
                        break;
                    }
                }
                ListNode temp = p.next;
                p.next = pre.next;
                pre.next = p;
                p = temp;
            }
            return dummy.next;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new InsertionSortList().new Solution();
            assertEquals(3, 3);
        }
    }
}
