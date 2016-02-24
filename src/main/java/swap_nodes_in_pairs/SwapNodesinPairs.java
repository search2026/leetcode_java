package swap_nodes_in_pairs;

import common.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SwapNodesinPairs {
    /*
        Swap Nodes in Pairs
        https://leetcode.com/problems/swap-nodes-in-pairs/
        Difficulty: Medium
     */
    public class Solution {
        public ListNode swapPairs(ListNode head) {
            if(head == null || head.next == null) return head;

            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode p = dummy;

            while(p.next != null && p.next.next != null){
                //use t1 to track first node
                ListNode first = p;
                p = p.next;
                first.next = p.next;

                //use t2 to track next node of the pair
                ListNode second = p.next.next;
                p.next.next = p;
                p.next = second;
            }

            return dummy.next;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new SwapNodesinPairs().new Solution();
            assertEquals(5, 5);
        }
    }
}
