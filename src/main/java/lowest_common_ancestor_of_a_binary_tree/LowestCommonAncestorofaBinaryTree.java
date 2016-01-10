package lowest_common_ancestor_of_a_binary_tree;

import common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class LowestCommonAncestorofaBinaryTree {
    /*
        Lowest Common Ancestor of a Binary Tree
        https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
        Difficulty: Medium
     */
    public class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q)
                return root;

            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            if (left != null && right != null)
                return root;

            if (left != null)
                return left;

            if (right != null)
                return right;

            return null;
        }
    }

    /*
        Lowest Common Ancestor of a Binary Tree
        https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
        Difficulty: Medium
     */
    public class SolutionUseHeight {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || p == null || q == null) {
                return null;
            }

            List<TreeNode> list1 = new ArrayList<TreeNode>();
            List<TreeNode> list2 = new ArrayList<TreeNode>();

            if (!getPath(root, p, list1)) {
                return null;
            }

            if (!getPath(root, q, list2)) {
                return null;
            }

            int i = 0;
            for (i = 0; i < list1.size() && i < list2.size(); i++) {
                if (list1.get(i) != list2.get(i)) {
                    return list1.get(i - 1);
                }
            }

            return list1.get(i - 1);
        }

        private boolean getPath(TreeNode root, TreeNode target, List<TreeNode> result) {
            if (root == null) {
                return false;
            }

            result.add(root);

            if (root == target) {
                return true;
            }

            if (root.left != null) {
                if (getPath(root.left, target, result)) {
                    return true;
                } else {
                    result.remove(result.size() - 1);
                }
            }

            if (root.right != null) {
                if (getPath(root.right, target, result)) {
                    return true;
                } else {
                    result.remove(result.size() - 1);
                }
            }

            return false;
        }
    }

    /*
        Lowest Common Ancestor of a Binary Tree with Parent Pointer
        https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
        Difficulty: Medium
     */
//    public class SolutionWithParentPointer {
//        public Node findLCA(Node root, Node p, Node q) {
//            if (root == null || p == null || q == null) return null;
//            int depth1 = getDepth(root, p);
//            int depth2 = getDepth(root, q);
//            if (depth1 > depth2) {
//                swap(depth1, depth2);
//                swap(p, q);
//            }
//            for (int i = 0; i < depth1 - depth2; i++) {
//                q = q.parent;
//            }
//            while (p) {
//                if (p == q) return p;
//                p = p.parent;
//                q = q.parent;
//            }
//            return null;
//        }
//
//        public int getDepth(Node root, Node n) {
//            if (root == null || n == null) return null;
//            int depth = 0;
//            while (root != n) {
//                depth++;
//                n = n.parent;
//            }
//            return depth;
//        }
//
//        public void swap(Object<T> a, Object<T> b) {
//            Object<T> tmp = a;
//            a = b;
//            b = tmp;
//        }
//    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new LowestCommonAncestorofaBinaryTree().new Solution();
            assertTrue(true);
        }
    }
}

