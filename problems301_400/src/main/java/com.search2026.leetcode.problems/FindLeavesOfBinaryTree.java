package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree {

    /*
        Find Leaves of Binary Tree
        Leetcode #366
        https://github.com/search2026/leetcode_java/blob/master/problems301_400/resources/FindLeavesOfBinaryTree.md
        Difficulty: Medium
     */
    public class Solution {
        private List<List<Integer>> list = new ArrayList<>();

        private int search(TreeNode node){
            if (node == null) return -1;

            int level = Math.max(search(node.left), search(node.right)) + 1;

            if (list.size() == level) {
                list.add(new ArrayList<>());
            }

            list.get(level).add(node.val);

            return level;
        }

        public List<List<Integer>> findLeaves(TreeNode root) {
            search(root);
            return list;
        }
    }

    /*
        Find Leaves of Binary Tree - Modify Tree Nodes
        Leetcode #366
        https://github.com/search2026/leetcode_java/blob/master/problems301_400/resources/FindLeavesOfBinaryTree.md
        Difficulty: Medium
   */
    public class Solution_2 {
        private TreeNode search(TreeNode node, List<Integer> currList) {
            if (node == null) return null;
            if (node.left == null && node.right == null) {
                currList.add(node.val);
                return null;
            }
            node.left = search(node.left, currList);
            node.right = search(node.right, currList);

            return node;
        }

        public List<List<Integer>> findLeaves(TreeNode root) {
            List<List<Integer>> list = new ArrayList<>();
            while (root != null) {
                List<Integer> currList = new ArrayList<>();
                root = search(root, currList);
                list.add(currList);
            }
            return list;
        }
    }

}
