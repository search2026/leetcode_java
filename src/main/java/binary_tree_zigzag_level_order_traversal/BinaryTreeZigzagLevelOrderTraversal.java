package binary_tree_zigzag_level_order_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import common.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    /*
        Binary Tree Zigzag Level Order Traversal
        leetcode #103
        https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
        Difficulty: Medium
     */
    public class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;

            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            boolean order = true;

            while (!q.isEmpty()) {
                List<Integer> curr = new ArrayList<>();
                int size = q.size();
                for (int i = 0; i < size; ++i) {
                    TreeNode t = q.poll();
                    if (order) {
                        curr.add(t.val);
                    } else {
                        curr.add(0, t.val);
                    }
                    if (t.left != null) q.add(t.left);
                    if (t.right != null) q.add(t.right);
                }
                res.add(curr);
                order = !order;
            }

            return res;
        }
    }

    /*
        Binary Tree Zigzag Level Order Traversal
        leetcode #103
        https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
        Difficulty: Medium
     */
    public class Solution_2 {
        private void travel(TreeNode curr, List<List<Integer>> sol, int level) {
            if (curr == null) return;

            if (sol.size() <= level) {
                List<Integer> newLevel = new LinkedList<>();
                sol.add(newLevel);
            }

            List<Integer> collection = sol.get(level);
            if (level % 2 == 0) collection.add(curr.val);
            else collection.add(0, curr.val);

            travel(curr.left, sol, level + 1);
            travel(curr.right, sol, level + 1);
        }

        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            travel(root, res, 0);
            return res;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
            TreeNode root = new TreeNode(3);
            root.left = new TreeNode(9);
            root.right = new TreeNode(20);
            root.right.left = new TreeNode(15);
            root.right.right = new TreeNode(7);
            List<List<Integer>> res = sol.zigzagLevelOrder(root);
            assertEquals(3, res.size());
            assertEquals(1, res.get(0).size());
            assertEquals(3, (int) res.get(0).get(0));
            assertEquals(2, res.get(1).size());
            assertEquals(20, (int) res.get(1).get(0));
            assertEquals(9, (int) res.get(1).get(1));
            assertEquals(2, res.get(2).size());
            assertEquals(15, (int) res.get(2).get(0));
            assertEquals(7, (int) res.get(2).get(1));
        }

        @Test
        public void test2() {
            Solution_2 sol = new BinaryTreeZigzagLevelOrderTraversal().new Solution_2();
            TreeNode root = new TreeNode(3);
            root.left = new TreeNode(9);
            root.right = new TreeNode(20);
            root.right.left = new TreeNode(15);
            root.right.right = new TreeNode(7);
            List<List<Integer>> res = sol.zigzagLevelOrder(root);
            assertEquals(3, res.size());
            assertEquals(1, res.get(0).size());
            assertEquals(3, (int) res.get(0).get(0));
            assertEquals(2, res.get(1).size());
            assertEquals(20, (int) res.get(1).get(0));
            assertEquals(9, (int) res.get(1).get(1));
            assertEquals(2, res.get(2).size());
            assertEquals(15, (int) res.get(2).get(0));
            assertEquals(7, (int) res.get(2).get(1));
        }
    }
}
