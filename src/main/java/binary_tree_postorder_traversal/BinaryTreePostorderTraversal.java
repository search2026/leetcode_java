package binary_tree_postorder_traversal;

import common.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BinaryTreePostorderTraversal {
    /*
        Binary Tree Postorder Traversal - Using Stacks
        Leetcode #94
        https://leetcode.com/problems/binary-tree-inorder-traversal/
        Difficulty: Medium
    */
    public class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            ArrayList<Integer> rslt = new ArrayList<Integer>();
            if (root == null) return rslt;

            ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
            TreeNode pre = null;
            stack.offerLast(root);
            while (!stack.isEmpty()) {
                TreeNode p = stack.peekLast();
                if (pre == null || pre.left == p || pre.right == p) {
                    if (p.left != null) {
                        stack.offerLast(p.left);
                    } else if (p.right != null) {
                        stack.offerLast(p.right);
                    }
                } else if (p.left == pre) {
                    if (p.right != null) {
                        stack.offerLast(p.right);
                    }
                } else {
                    rslt.add(p.val);
                    stack.removeLast();
                }
                pre = p;
            }
            return rslt;
        }
    }

    /*
        Binary Tree Postorder Traversal - Morris Traversal
        Leetcode #94
        https://leetcode.com/problems/binary-tree-inorder-traversal/
        Difficulty: Medium
    */
    public class Solution_2 {
        public List<Integer> postorderTraversal(TreeNode root) {
            ArrayList<Integer> rslt = new ArrayList<Integer>();
            TreeNode dummy = new TreeNode(0);
            dummy.left = root;
            TreeNode cur = dummy;
            TreeNode pre = null;
            while (cur != null) {
                if (cur.left == null) {
                    cur = cur.right;
                } else {
                    pre = cur.left;
                    while (pre.right != null && pre.right != cur)
                        pre = pre.right;
                    if (pre.right == null) {
                        pre.right = cur;
                        cur = cur.left;
                    } else {
                        reverse(cur.left, pre);
                        TreeNode temp = pre;
                        while (temp != cur.left) {
                            rslt.add(temp.val);
                            temp = temp.right;
                        }
                        rslt.add(temp.val);
                        reverse(pre, cur.left);
                        pre.right = null;
                        cur = cur.right;
                    }
                }
            }
            return rslt;
        }

        private void reverse(TreeNode start, TreeNode end) {
            if (start == end)
                return;
            TreeNode pre = start;
            TreeNode cur = start.right;
            TreeNode next;
            while (pre != end) {
                next = cur.right;
                cur.right = pre;
                pre = cur;
                cur = next;
            }
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new BinaryTreePostorderTraversal().new Solution();
            assertEquals(1, 1);
        }
    }
}
