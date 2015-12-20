package kth_smallest_element_in_a_bst;

import common.TreeNode;

public class KthSmallestElementinaBST {
    /*
        Kth Smallest Element in a BST
        https://leetcode.com/problems/kth-smallest-element-in-a-bst/
        Difficulty: Medium
     */
    public class Solution {
        private int counter = 0;
        private boolean found = false;
        private int val = Integer.MIN_VALUE;

        public int kthSmallest(TreeNode root, int k) {
            if (root == null) {
                return 0;
            }

            kthSmallestHelper(root, k);

            return val;
        }

        private void kthSmallestHelper(TreeNode root, int k) {
            if (root == null) {
                return;
            }

            if (!found) {
                kthSmallestHelper(root.left, k);
            }

            counter++;
            if (counter == k) {
                found = true;
                val = root.val;
            }

            if (!found) {
                kthSmallestHelper(root.right, k);
            }
        }
    }

    /*
    Kth Smallest Element in a BST
    https://leetcode.com/problems/kth-smallest-element-in-a-bst/
    Difficulty: Medium
    */
    public class SolutionModifyStructure {
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
            if (root == null) {
                return 0;
            }

            return getNumberNodes(root.left) + getNumberNodes(root.right) + 1;
        }
    }

    public static class UnitTest {

    }
}
