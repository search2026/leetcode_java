package merge_k_sorted_lists;

import common.ListNode;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

public class MergekSortedLists {
  /*
      Merge K Sorted Lists - Heap
      leetcode #23
      https://leetcode.com/problems/merge-k-sorted-lists/
      Difficulty: Hard
   */
  public class Solution {
    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
      @Override
      public int compare(ListNode left, ListNode right) {
        if (left == null) {
          return 1;
        } else if (right == null) {
          return -1;
        }
        return left.val - right.val;
      }
    };

    public ListNode mergeKLists(ListNode[] lists) {
      if (lists == null || lists.length == 0) return null;

      Queue<ListNode> pq = new PriorityQueue<>(lists.length, ListNodeComparator);
      for (int i = 0; i < lists.length; i++) {
        if (lists[i] != null) {
          pq.add(lists[i]);
        }
      }

      ListNode dummy = new ListNode(0);
      ListNode curr = dummy;
      while (!pq.isEmpty()) {
        curr.next = pq.poll();
        curr = curr.next;
        if (curr.next != null) {
          pq.add(curr.next);
        }
      }
      return dummy.next;
    }
  }

  /*
      Merge K Sorted Lists - Divide and Conquer
      leetcode #23
      https://leetcode.com/problems/merge-k-sorted-lists/
      Difficulty: Hard
   */
  public class Solution_2 {
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      if (l1 == null) return l2;
      if (l2 == null) return l1;

      ListNode dummy = new ListNode(0);
      ListNode p = dummy;
      while (l1 != null && l2 != null) {
        if (l1.val < l2.val) {
          p.next = l1;
          l1 = l1.next;
        } else {
          p.next = l2;
          l2 = l2.next;
        }
        p = p.next;
      }

      if (l1 != null) p.next = l1;
      else p.next = l2;

      return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
      if (lists == null || lists.length == 0) return null;
      int end = lists.length - 1;

      while (end  > 0) {
        int begin = 0;
        while (begin < end) {
          lists[begin] = mergeTwoLists(lists[begin], lists[end]);
          begin++;
          end--;
        }
      }

      return lists[0];
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new MergekSortedLists().new Solution();
      ListNode list1 = new ListNode(1);
      list1.next = new ListNode(3);
      list1.next.next = new ListNode(6);
      ListNode list2 = new ListNode(2);
      list2.next = new ListNode(4);
      ListNode list3 = new ListNode(5);
      ListNode[] lists = {list1, list2, list3};
      ListNode mergered = sol.mergeKLists(lists);
      assertEquals(1, mergered.val);
      assertEquals(2, mergered.next.val);
      assertEquals(3, mergered.next.next.val);
      assertEquals(4, mergered.next.next.next.val);
      assertEquals(5, mergered.next.next.next.next.val);
      assertEquals(6, mergered.next.next.next.next.next.val);
    }

    @Test
    public void test2() {
      Solution_2 sol = new MergekSortedLists().new Solution_2();
      ListNode list1 = new ListNode(1);
      list1.next = new ListNode(3);
      list1.next.next = new ListNode(6);
      ListNode list2 = new ListNode(2);
      list2.next = new ListNode(4);
      ListNode list3 = new ListNode(5);
      ListNode[] lists = {list1, list2, list3};
      ListNode mergered = sol.mergeKLists(lists);
      assertEquals(1, mergered.val);
      assertEquals(2, mergered.next.val);
      assertEquals(3, mergered.next.next.val);
      assertEquals(4, mergered.next.next.next.val);
      assertEquals(5, mergered.next.next.next.next.val);
      assertEquals(6, mergered.next.next.next.next.next.val);
    }
  }
}
