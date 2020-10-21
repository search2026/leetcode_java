package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeVerticalOrderTraversal {

    /*
        Binary Tree Vertical Order Traversal
        Leetcode #314
        https://github.com/search2026/leetcode_java/blob/master/problems301_400/resources/BinaryTreeVerticalOrderTraversal.md
        Difficulty: Medium
     */
    public class Solution {
        public List<List<Integer>> verticalOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            LinkedList<TreeNode> queue = new LinkedList<>();
            LinkedList<Integer> colQue = new LinkedList<>();
            queue.offer(root);
            colQue.offer(0);
            map.put(0, new ArrayList<>());
            map.get(0).add(root.val);
            int min = 0, max = 0;
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                int col = colQue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                    colQue.offer(col - 1);
                    if (!map.containsKey(col - 1)) {
                        map.put(col - 1, new ArrayList<>());
                    }
                    map.get(col - 1).add(cur.left.val);
                    if (col - 1 < min) min = col - 1;
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                    colQue.offer(col + 1);
                    if (!map.containsKey(col + 1)) {
                        map.put(col + 1, new ArrayList<>());
                    }
                    map.get(col + 1).add(cur.right.val);
                    if (col + 1 > max) max = col + 1;
                }
            }
            for (int k = min; k <= max; k++) {
                if (map.containsKey(k))
                    res.add(new ArrayList<Integer>(map.get(k)));
            }
            return res;
        }
    }

}
