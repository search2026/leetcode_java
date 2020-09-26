package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {

    /*
        Binary Tree Right Side View
        Leetcode #199
        https://leetcode.com/problems/binary-tree-right-side-view/
        Difficulty: Medium
     */
    public class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root != null) {
                List<TreeNode> level = new ArrayList<>();
                level.add(root);
                while (!level.isEmpty()) {
                    res.add(level.get(level.size() - 1).val);
                    List<TreeNode> nextLevel = new ArrayList<>();
                    for (TreeNode node : level) {
                        if (node.left != null) {
                            nextLevel.add(node.left);
                        }
                        if (node.right != null) {
                            nextLevel.add(node.right);
                        }
                    }
                    level = nextLevel;
                }
            }
            return res;
        }
    }

}
