package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {

    /*
        Minimum Depth of Binary Tree - Depth First Traversal
        Leetcode #111
        https://leetcode.com/problems/minimum-depth-of-binary-tree/
        Difficulty: Easy
     */
    public class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
        }
    }

    /*
        Minimum Depth of Binary Tree - Breadth First Traversal
        Leetcode #111
        https://leetcode.com/problems/minimum-depth-of-binary-tree/
        Difficulty: Easy
     */
    public class Solution_2 {
        public int minDepth(TreeNode root) {
            if (root == null) return 0;

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            TreeNode rightMost = root;
            int depth = 1;

            while (!q.isEmpty()) {
                TreeNode curr = q.poll();
                if (curr.left == null && curr.right == null) break;
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
                if (curr == rightMost) {
                    depth++;
                    rightMost = (curr.right != null) ? curr.right : curr.left;
                }
            }

            return depth;
        }
    }

}
