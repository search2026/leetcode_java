package delete_node_in_a_linked_list;

import common.ListNode;

public class DeleteNodeinaLinkedList {
    /*
        Delete Bode in a Linked List
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

    }
}

