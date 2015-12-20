package binary_tree_vertical_order_traversal;

import common.TreeNode;
import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;

public class BinaryTreeVerticalOrderTraversal {
    /*
        Binary Tree Vertical Order Traversal
        http://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/
        Difficulty: Medium
     */
    public class Solution {
        TreeNode root;

        public void printTopView() {
            // base case
            if (root == null) {
                return;
            }

            // Creates an empty hashset
            HashSet<Integer> set = new HashSet<>();

            // Create a queue and add root to it
            Queue<QItem> Q = new LinkedList<QItem>();
            Q.add(new QItem(root, 0)); // Horizontal distance of root is 0

            // Standard BFS or level order traversal loop
            while (!Q.isEmpty()) {
                // Remove the front item and get its details
                QItem qi = Q.remove();
                int hd = qi.hd;
                TreeNode n = qi.node;

                // If this is the first node at its horizontal distance,
                // then this node is in top view
                if (!set.contains(hd)) {
                    set.add(hd);
                    System.out.print(n.val + " ");
                }

                // Enqueue left and right children of current node
                if (n.left != null)
                    Q.add(new QItem(n.left, hd - 1));
                if (n.right != null)
                    Q.add(new QItem(n.right, hd + 1));
            }
        }


        class QItem {
            TreeNode node;
            int hd;

            public QItem(TreeNode n, int h) {
                node = n;
                hd = h;
            }
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new BinaryTreeVerticalOrderTraversal().new Solution();
        }
    }
}
