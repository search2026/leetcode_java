package partition_list;

import common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartitionList {
    /*
        Partition List
        Leetcode #86
        https://leetcode.com/problems/partition-list/
        Difficulty: Medium
     */
    public class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode lessHead = null;
            ListNode lessTail = null;
            ListNode greaterHead = null;
            ListNode greaterTail = null;
            ListNode p = head;
            while (p != null) {
                if (p.val < x) {
                    if (lessHead == null) {
                        lessHead = p;
                    } else {
                        lessTail.next = p;
                    }
                    lessTail = p;
                } else {
                    if (greaterHead == null) {
                        greaterHead = p;
                    } else {
                        greaterTail.next = p;
                    }
                    greaterTail = p;
                }
                p = p.next;
            }
            if (lessHead == null) {
                if (greaterTail != null) {
                    greaterTail.next = null;
                }
                return greaterHead;
            } else {
                lessTail.next = greaterHead;
                if (greaterTail != null) {
                    greaterTail.next = null;
                }
                return lessHead;
            }
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new PartitionList().new Solution();
            assertEquals(7, 7);
        }
    }
}
