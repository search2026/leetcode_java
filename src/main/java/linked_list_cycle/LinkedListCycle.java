package linked_list_cycle;

import common.ListNode;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListCycle {
    /*
        Linked List Cycle
        https://leetcode.com/problems/linked-list-cycle/
        leetcode 141
        Difficulty: Medium
     */
    public class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            do {
                if (fast == null || fast.next == null) {
                    return false;
                }
                fast = fast.next.next;
                slow = slow.next;
            } while (fast != slow);
            return true;
        }
    }

    /*
        Linked List Cycle
        https://leetcode.com/problems/linked-list-cycle-ii/
        leetcode 142
        Difficulty: Medium
     */
    public class Solution_2 {
        public ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null) {
                return null;
            }

            ListNode fast, slow;
            fast = head.next;
            slow = head;
            while (fast != slow) {
                if (fast == null || fast.next == null)
                    return null;
                fast = fast.next.next;
                slow = slow.next;
            }

            while (head != slow.next) {
                head = head.next;
                slow = slow.next;
            }
            return head;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new LinkedListCycle().new Solution();
            assertEquals(3, 3);
        }
    }
}
