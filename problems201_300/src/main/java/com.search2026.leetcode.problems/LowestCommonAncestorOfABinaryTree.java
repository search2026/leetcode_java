package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;

import java.util.*;

public class LowestCommonAncestorOfABinaryTree {

    /*
        Lowest Common Ancestor of a Binary Tree - Recursive
        Leetcode #236
        https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
        Difficulty: Medium
     */
    public class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) return root;
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left != null && right != null) return root;
            return left != null ? left : right;
        }
    }

    /*
        Lowest Common Ancestor of a Binary Tree - Iterative
        Leetcode #236
        https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
        Difficulty: Medium
     */
    public class Solution_2 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            Map<TreeNode, TreeNode> parent = new HashMap<>();
            Deque<TreeNode> stack = new ArrayDeque<>();
            parent.put(root, null);
            stack.push(root);

            while (!parent.containsKey(p) || !parent.containsKey(q)) {
                TreeNode node = stack.pop();
                if (node.left != null) {
                    parent.put(node.left, node);
                    stack.push(node.left);
                }
                if (node.right != null) {
                    parent.put(node.right, node);
                    stack.push(node.right);
                }
            }
            Set<TreeNode> ancestors = new HashSet<>();
            while (p != null) {
                ancestors.add(p);
                p = parent.get(p);
            }
            while (!ancestors.contains(q))
                q = parent.get(q);
            return q;
        }
    }


    /*
        Lowest Common Ancestor of a Binary Tree - Using Height
        Leetcode #236
        https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
        Difficulty: Medium
     */
    public class Solution_3 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || p == null || q == null) {
                return null;
            }

            List<TreeNode> list1 = new ArrayList<>();
            List<TreeNode> list2 = new ArrayList<>();

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
//    public class Solution_4 {
//        public Node findLCA(Node findRoot, Node p, Node q) {
//            if (findRoot == null || p == null || q == null) return null;
//            int depth1 = getDepth(findRoot, p);
//            int depth2 = getDepth(findRoot, q);
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
//        public int getDepth(Node findRoot, Node n) {
//            if (findRoot == null || n == null) return null;
//            int depth = 0;
//            while (findRoot != n) {
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

}
