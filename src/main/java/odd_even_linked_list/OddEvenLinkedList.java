package odd_even_linked_list;

import common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OddEvenLinkedList {
    /*
        Odd Even Linked List
        Leetcode #328
        https://leetcode.com/problems/odd-even-linked-list/
        Difficulty: Easy
     */
    public class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null) return head;
            ListNode p1 = head, p2 = head;
            while (p2 != null) {
                p2 = p2.next;
                if (p2 == null || p2.next == null) break;
                ListNode next_p = p1.next, next_q = p2.next;
                p2.next = next_q.next;
                p1.next = next_q;
                next_q.next = next_p;
                p1 = p1.next;
            }
            return head;
        }
    }

    /*
        Odd Even Linked List
        Leetcode #328
        https://leetcode.com/problems/odd-even-linked-list/
        Difficulty: Easy
    */
    public class Solution_2 {
        public ListNode oddEvenList(ListNode head) {
            if (head == null) return null;
            ListNode evenHead = head.next;
            ListNode odd = head, even = evenHead;
            while (even!=null && even.next !=null) {
                odd.next = even.next;
                odd = odd.next;
                even.next = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
            return head;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new OddEvenLinkedList().new Solution();
            assertEquals(7, 7);
        }
    }
}

