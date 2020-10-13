package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;

public class LargestBSTSubtree {

    /*
        Largest BST Subtree - New Node Structure
        Leetcode #333
        https://github.com/search2026/leetcode_java/blob/master/resources/LargestBSTSubtree.md
        Difficulty: Medium
     */
    public class Solution {
        private Node search(TreeNode root, int[] count) {
            Node cur = new Node();
            if (root == null) {
                cur.isBST = true;
                return cur;
            }
            Node left = search(root.left, count);
            Node right = search(root.right, count);
            if (left.isBST && root.val > left.max && right.isBST && root.val < right.min) {
                cur.isBST = true;
                cur.min = Math.min(root.val, left.min);
                cur.max = Math.max(root.val, right.max);
                cur.size = left.size + right.size + 1;
                if (cur.size > count[0]) {
                    count[0] = cur.size;
                }
            }
            return cur;
        }

        public int largestBSTSubtree(TreeNode root) {
            int[] count = {0};
            search(root, count);
            return count[0];
        }
    }

    class Node {
        boolean isBST;
        int min;
        int max;
        int size;

        public Node() {
            isBST = false;
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            size = 0;
        }
    }

    /*
        Largest BST Subtree - O(NlogN)
        Leetcode #333
        https://github.com/search2026/leetcode_java/blob/master/resources/LargestBSTSubtree.md
        Difficulty: Medium
     */
    public class Solution_2 {
        private int isValidBST(TreeNode node, int min, int max) {
            if (node == null) {
                return 0;
            }
            if (node.val < min || node.val > max) {
                return -1;
            }
            int left = isValidBST(node.left, min, node.val);
            int right = isValidBST(node.right, node.val, max);
            return (left >= 0 && right >= 0) ? left + right + 1 : -1;
        }

        public int largestBSTSubtree(TreeNode root) {
            int count = isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
            if (count >= 0) return count;

            return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
        }
    }

    /*
        Largest BST Subtree - O(N)
        Leetcode #333
        https://github.com/search2026/leetcode_java/blob/master/resources/LargestBSTSubtree.md
        Difficulty: Medium
     */
    public class Solution_3 {
        private boolean search(TreeNode root, int[] min, int[] max, int[] count) {
            if (root == null) return true;

            int[] lMin = {Integer.MAX_VALUE};
            int[] lMax = {Integer.MIN_VALUE};
            int[] lSize = {0};
            boolean isLeftValid = search(root.left, lMin, lMax, lSize);

            int[] rMin = {Integer.MAX_VALUE};
            int[] rMax = {Integer.MIN_VALUE};
            int[] rSize = {0};
            boolean isRightValid = search(root.right, rMin, rMax, rSize);

            if (!isLeftValid || !isRightValid || (root.left != null && root.val <= lMax[0]) || (root.right != null && root.val >= rMin[0])) {
                count[0] = Math.max(lSize[0], rSize[0]);
                return false;
            }

            min[0] = root.left == null ? root.val : lMin[0];
            max[0] = root.right == null ? root.val : rMax[0];
            count[0] = lSize[0] + rSize[0] + 1;

            return true;
        }

        public int largestBSTSubtree(TreeNode root) {
            int[] count = {0};
            int[] min = {Integer.MIN_VALUE};
            int[] max = {Integer.MAX_VALUE};
            search(root, min, max, count);
            return count[0];
        }
    }


}
