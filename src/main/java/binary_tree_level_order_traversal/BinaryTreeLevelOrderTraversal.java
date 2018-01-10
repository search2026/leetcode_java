package binary_tree_level_order_traversal;

import common.TreeNode;

import java.util.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeLevelOrderTraversal {
    /*
        Binary Tree Level Order Traversal - BFS
        Leetcode #102
        https://leetcode.com/problems/binary-tree-level-order-traversal/
        Difficulty: Medium
     */
    public class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                int size = q.size();
                List<Integer> curr = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode t = q.poll();
                    curr.add(t.val);
                    if (t.left != null)
                        q.offer(t.left);
                    if (t.right != null)
                        q.offer(t.right);
                }
                res.add(curr);
            }
            return res;
        }
    }

    /*
        Binary Tree Level Order Traversal - DFS
        Leetcode #102
        https://leetcode.com/problems/binary-tree-level-order-traversal/
        Difficulty: Medium
     */
    public class Solution_2 {
        public void search(List<List<Integer>> res, TreeNode root, int height) {
            if (root == null) return;
            if (height >= res.size()) {
                res.add(new LinkedList<>());
            }
            res.get(height).add(root.val);
            search(res, root.left, height + 1);
            search(res, root.right, height + 1);
        }

        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            search(res, root, 0);
            return res;
        }
    }

    /*
        Binary Tree Level Order Traversal II
        Leetcode #107
        https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
        Difficulty: Medium
    */
    public class Solution_3 {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                int size = q.size();
                List<Integer> curr = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode t = q.poll();
                    curr.add(t.val);
                    if (t.left != null)
                        q.offer(t.left);
                    if (t.right != null)
                        q.offer(t.right);
                }
                res.add(curr);
            }
            Collections.reverse(res);
            return res;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new BinaryTreeLevelOrderTraversal().new Solution();
            TreeNode root = new TreeNode(3);
            root.left = new TreeNode(9);
            root.right = new TreeNode(20);
            root.right.left = new TreeNode(15);
            root.right.right = new TreeNode(7);
            List<List<Integer>> res = sol.levelOrder(root);
            assertEquals(3, res.size());
            assertEquals(1, res.get(0).size());
            assertEquals(3, (int) res.get(0).get(0));
            assertEquals(2, res.get(1).size());
            assertEquals(9, (int) res.get(1).get(0));
            assertEquals(20, (int) res.get(1).get(1));
            assertEquals(2, res.get(2).size());
            assertEquals(15, (int) res.get(2).get(0));
            assertEquals(7, (int) res.get(2).get(1));
        }

        @Test
        public void test2() {
            Solution_2 sol = new BinaryTreeLevelOrderTraversal().new Solution_2();
            TreeNode root = new TreeNode(3);
            root.left = new TreeNode(9);
            root.right = new TreeNode(20);
            root.right.left = new TreeNode(15);
            root.right.right = new TreeNode(7);
            List<List<Integer>> res = sol.levelOrder(root);
            assertEquals(3, res.size());
            assertEquals(1, res.get(0).size());
            assertEquals(3, (int) res.get(0).get(0));
            assertEquals(2, res.get(1).size());
            assertEquals(9, (int) res.get(1).get(0));
            assertEquals(20, (int) res.get(1).get(1));
            assertEquals(2, res.get(2).size());
            assertEquals(15, (int) res.get(2).get(0));
            assertEquals(7, (int) res.get(2).get(1));
        }

        @Test
        public void test3() {
            Solution_3 sol = new BinaryTreeLevelOrderTraversal().new Solution_3();
            TreeNode root = new TreeNode(3);
            root.left = new TreeNode(9);
            root.right = new TreeNode(20);
            root.right.left = new TreeNode(15);
            root.right.right = new TreeNode(7);
            List<List<Integer>> res = sol.levelOrderBottom(root);
            assertEquals(3, res.size());
            assertEquals(2, res.get(0).size());
            assertEquals(15, (int) res.get(0).get(0));
            assertEquals(7, (int) res.get(0).get(1));
            assertEquals(2, res.get(1).size());
            assertEquals(9, (int) res.get(1).get(0));
            assertEquals(20, (int) res.get(1).get(1));
            assertEquals(1, res.get(2).size());
            assertEquals(3, (int) res.get(2).get(0));
        }
    }
}
