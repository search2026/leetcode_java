package binary_tree_level_order_traversal;

import common.TreeNode;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertTrue;

public class BinaryTreeLevelOrderTraversal {
    /*
        Binary Tree Level Order Traversal
        https://leetcode.com/problems/binary-tree-level-order-traversal/
        Difficulty: Medium
     */
    public class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> rslt = new LinkedList<List<Integer>>();
            if (root == null) return rslt;

            Queue<TreeNode> q = new LinkedList<TreeNode>();
            q.offer(root);
            while(!q.isEmpty()){
                int l_count = q.size();
                List<Integer> subList = new LinkedList<Integer>();
                for(int i=0; i<l_count; i++) {
                    if(q.peek().left != null) q.offer(q.peek().left);
                    if(q.peek().right != null) q.offer(q.peek().right);
                    subList.add(q.poll().val);
                }
                rslt.add(subList);
            }
            return rslt;
        }
    }

    /*
        Binary Tree Level Order Traversal
        https://leetcode.com/problems/binary-tree-level-order-traversal/
        Difficulty: Medium
     */
    public class Solution_2 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> rslt = new ArrayList<List<Integer>>();
            if (root == null) return rslt;

            int queueIn = 1;
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);

            while (queue.size() != 0) {
                int queueOut = 0;
                List<Integer> temp = new ArrayList<Integer>();
                while (queueOut < queueIn) {
                    TreeNode curr = queue.poll();
                    temp.add(curr.val);
                    if (curr.left != null) {
                        queue.offer(curr.left);
                    }
                    if (curr.right != null) {
                        queue.offer(curr.right);
                    }
                    queueOut++;
                }
                rslt.add(temp);
                queueIn = queue.size();
            }
            return rslt;
        }
    }

    /*
        Binary Tree Level Order Traversal II
        https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
        Difficulty: Medium
    */
    public class Solution_3 {
        private void search(TreeNode root, int level, List<List<Integer>> rslt) {
            if (root == null) return;

            if (level >= rslt.size())
                rslt.add(new ArrayList<Integer>());

            rslt.get(level).add(root.val);
            search(root.left, level + 1, rslt);
            search(root.right, level + 1, rslt);
        }

        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            search(root, 0, ans);
            Collections.reverse(ans);
            return ans;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new BinaryTreeLevelOrderTraversal().new Solution();
            assertTrue(true);
        }
    }
}
