package linked_list_random_node;

import common.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListRandomNode {
  /*
      Linked List Random Node
      Leetcode #382
      https://leetcode.com/problems/linked-list-random-node/
      Difficulty: Medium
   */
  public class Solution {
    ListNode head;
    Random random;

    public Solution(ListNode head) {
      this.head = head;
    }

    public int getRandom() {
      ListNode c = head;
      int r = c.val;
      for (int i = 1; c.next != null; i++) {

        c = c.next;
        if (randInt(0, i) == i) r = c.val;
      }

      return r;
    }

    private int randInt(int min, int max) {
      return min + (int) (Math.random() * ((max - min) + 1));
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      //Solution_3 sol = new LinkedListRandomNode().new Solution_3();
      // Init a singly linked list [1,2,3].
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);
      Solution solution = new LinkedListRandomNode().new Solution(head);

      // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
      int rnd = solution.getRandom();
      assertTrue(rnd < 4);
      assertTrue(rnd > 0);
    }
  }
}

