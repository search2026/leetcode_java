package kth_smallest_element_in_a_bst;

import common.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

public class KthSmallestElementinaBST {
    /*
        Kth Smallest Element in a BST
        Leetcode #230
        https://leetcode.com/problems/kth-smallest-element-in-a-bst/
        Difficulty: Medium
     */
    public class Solution {
        int counter;
        int rslt;
        public int kthSmallest(TreeNode root, int k) {
            if (root == null || k == 0) return 0;

            counter = k;
            helper(root);
            return rslt;
        }

        private void helper(TreeNode root) {
            if (root == null) return;

            helper(root.left);
            counter--;
            if (counter == 0) {
                rslt = root.val;
                return;
            }

            helper(root.right);
        }
    }

    /*
        Kth Smallest Element in a BST - Using List/Stack
        Leetcode #230
        https://leetcode.com/problems/kth-smallest-element-in-a-bst/
        Difficulty: Medium
     */
    public class Solution_2 {
        public int kthSmallest(TreeNode root, int k) {
            TreeNode node = root;
            Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
            int counter = 0;
            while (!stack.isEmpty() || node != null) {
                if (node != null) {
                    stack.addLast(node);
                    node = node.left;
                } else {
                    node = stack.removeLast();
                    counter++;
                    if (counter == k) return node.val;
                    node = node.right;
                }
            }
            return -1;
        }
    }

    /*
        Kth Smallest Element in a BST - Count Number
        Leetcode #230
        https://leetcode.com/problems/kth-smallest-element-in-a-bst/
        Difficulty: Medium
    */
    public class Solution_3 {
        public int kthSmallest(TreeNode root, int k) {
            if (root == null) {
                return 0;
            }

            int leftNodes = getNumberNodes(root.left);
            if (k == leftNodes + 1) {
                return root.val;
            } else if (k > leftNodes + 1) {
                return kthSmallest(root.right, k - leftNodes - 1);
            } else {
                return kthSmallest(root.left, k);
            }
        }

        private int getNumberNodes(TreeNode root) {
            if (root == null) return 0;

            return getNumberNodes(root.left) + getNumberNodes(root.right) + 1;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new KthSmallestElementinaBST().new Solution();
            assertTrue(true);
        }
    }
}
