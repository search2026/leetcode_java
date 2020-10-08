package binary_tree_vertical_order_traversal;

import common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeVerticalOrderTraversal {
    /*
        Binary Tree Vertical Order Traversal
        Leetcode #314
        https://leetcode.com/discuss/questions/oj/binary-tree-vertical-order-traversal?sort=votes
        http://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/
        Difficulty: Medium
     */
    public class Solution {
        public List<List<Integer>> verticalOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            if (root == null) return res;
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            LinkedList<TreeNode> queue = new LinkedList<>();
            LinkedList<Integer> colQue = new LinkedList<>();
            queue.offer(root);
            colQue.offer(0);
            map.put(0, new ArrayList<Integer>());
            map.get(0).add(root.val);
            int min = 0, max = 0;
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                int col = colQue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                    colQue.offer(col - 1);
                    if (!map.containsKey(col - 1)) {
                        map.put(col - 1, new ArrayList<Integer>());
                    }
                    map.get(col - 1).add(cur.left.val);
                    if (col - 1 < min) min = col - 1;
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                    colQue.offer(col + 1);
                    if (!map.containsKey(col + 1)) {
                        map.put(col + 1, new ArrayList<Integer>());
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

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new BinaryTreeVerticalOrderTraversal().new Solution();
            assertTrue(true);
        }
    }
}
