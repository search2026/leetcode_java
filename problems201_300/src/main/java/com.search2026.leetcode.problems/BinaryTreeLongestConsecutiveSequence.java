package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;

public class BinaryTreeLongestConsecutiveSequence {

    /*
        Binary Tree Longest Consecutive Sequence
        Leetcode #298
        https://github.com/search2026/leetcode_java/blob/master/resources/BinaryTreeLongestConsecutiveSequence.md
        Difficulty: Medium
     */
    public class Solution {
        private int search(TreeNode root, int len, int pre) {
            if (root == null) return len;

            int currLen = pre + 1 == root.val ? len + 1 : 1;

            return Math.max(currLen, Math.max(search(root.left, currLen, root.val), search(root.right, currLen, root.val)));
        }

        public int longestConsecutive(TreeNode root) {
            if (root == null)
                return 0;
            return search(root, 0, root.val);
        }
    }

    /*
        Binary Tree Longest Consecutive Sequence
        Leetcode #298
        https://github.com/search2026/leetcode_java/blob/master/resources/BinaryTreeLongestConsecutiveSequence.md
        Difficulty: Medium
     */
    public class Solution_2 {
        private int max = 0;

        private void search(TreeNode root, int cur, int target) {
            if (root == null) return;
            if (root.val == target) cur++;
            else cur = 1;
            max = Math.max(cur, max);
            search(root.left, cur, root.val + 1);
            search(root.right, cur, root.val + 1);
        }

        public int longestConsecutive(TreeNode root) {
            if (root == null) return 0;
            search(root, 0, root.val);
            return max;
        }
    }

    /*
        Binary Tree Longest Consecutive Sequence II
        Leetcode #549
        https://github.com/search2026/leetcode_java/blob/master/resources/BinaryTreeLongestConsecutiveSequenceII.md
        Difficulty: Hard
     */
    public class Solution_3 {
        private int search(TreeNode node, int diff) {
            if (node == null) return 0;
            int left = 0, right = 0;
            if (node.left != null && node.val - node.left.val == diff) {
                left = 1 + search(node.left, diff);
            }
            if (node.right != null && node.val - node.right.val == diff) {
                left = 1 + search(node.right, -diff);
            }

            return Math.max(left, right);
        }

        public int longestConsecutive(TreeNode root) {
            if (root == null) return 0;
            int res = search(root, 1) + search(root, -1) + 1;
            return Math.max(res, Math.max(longestConsecutive(root.left), longestConsecutive(root.right)));
        }
    }

    /*
        Binary Tree Longest Consecutive Sequence II
        Leetcode #549
        https://github.com/search2026/leetcode_java/blob/master/resources/BinaryTreeLongestConsecutiveSequenceII.md
        Difficulty: Hard
     */
    public class Solution_4 {
        private int max = 1;

        private int[] search(TreeNode root) {
            if (root == null) return null;
            int[] right = search(root.right);
            int[] left = search(root.left);
            int[] res = new int[]{1, 1};
            if (right == null && left == null) return res;

            if (root.right != null) {
                if (root.val == root.right.val + 1) {
                    max = Math.max(max, right[0] + 1);
                    res[0] = right[0] + 1;
                    res[1] = 1;
                } else if (root.val == root.right.val - 1) {
                    max = Math.max(max, right[1] + 1);
                    res[0] = 1;
                    res[1] = right[1] + 1;
                }
            }
            if (root.left != null) {
                if (root.val == root.left.val + 1) {
                    max = Math.max(max, left[0] + res[1]);
                    res[0] = Math.max(res[0], left[0] + 1);
                } else if (root.val == root.left.val - 1) {
                    max = Math.max(max, left[1] + res[0]);
                    res[1] = Math.max(res[1], left[1] + 1);
                }
            }

            return res;
        }

        public int longestConsecutive(TreeNode root) {
            if (root == null) return 0;
            search(root);
            return max;
        }
    }

}
