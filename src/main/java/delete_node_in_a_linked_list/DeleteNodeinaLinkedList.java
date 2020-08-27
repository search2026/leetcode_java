package delete_node_in_a_linked_list;

import common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeleteNodeinaLinkedList {
    /*
        Delete Node in a Linked List
        Leetcode #237
        https://leetcode.com/problems/delete-node-in-a-linked-list/
        Difficulty: Easy
     */
    public class Solution {
        public void deleteNode(ListNode node) {
            if (node == null) {
                return;
            }

            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new DeleteNodeinaLinkedList().new Solution();
            assertTrue(true);
        }
    }
}

