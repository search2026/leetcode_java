package closest_binary_search_tree_value;

import common.TreeNode;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertTrue;

public class ClosestBinarySearchTreeValue {
    /*
        Closest Binary Search Tree Value - Recursion
        Leetcode #270
        https://leetcode.com/discuss/questions/oj/closest-binary-search-tree-value?sort=votes
        http://blog.csdn.net/xudli/article/details/48749493
        Difficulty: Easy
      */
    public class Solution {
        public int closestValue(TreeNode root, double target) {
            TreeNode kid = target < root.val ? root.left : root.right;
            if (kid == null) return root.val;
            int closest = closestValue(kid, target);

            return Math.abs(root.val - target) < Math.abs(closest - target) ? root.val : closest;
        }
    }

    /*
        Closest Binary Search Tree Value - Iterative
        Leetcode #270
        https://leetcode.com/discuss/questions/oj/closest-binary-search-tree-value?sort=votes
        http://blog.csdn.net/xudli/article/details/48749493
        Difficulty: Easy
      */
    public class Solution_2 {
        public int closestValue(TreeNode root, double target) {
            int closest = root.val;
            while (root != null) {
                closest = Math.abs(closest - target) < Math.abs(root.val - target) ? closest : root.val;
                root = target < root.val ? root.left : root.right;
            }
            return closest;
        }
    }

    /*
        Closest Binary Search Tree Value II
        Leetcode #272
        https://leetcode.com/discuss/questions/oj/closest-binary-search-tree-value-ii?sort=votes
        http://blog.csdn.net/xudli/article/details/48752907
        Difficulty: Hard
      */
    public class Solution_3 {
        public List<Integer> closestKValues(TreeNode root, double target, int k) {
            PriorityQueue<Double> maxHeap = new PriorityQueue<Double>(k, new Comparator<Double>() {
                @Override
                public int compare(Double x, Double y) {
                    return (int) (y - x);
                }
            });
            Set<Integer> set = new HashSet<Integer>();

            search(root, target, k, maxHeap, set);

            return new ArrayList<Integer>(set);
        }

        private void search(TreeNode root, double target, int k, PriorityQueue<Double> maxHeap, Set<Integer> set) {
            if (root == null) return;
            double diff = Math.abs(root.val - target);
            if (maxHeap.size() < k) {
                maxHeap.offer(diff);
                set.add(root.val);
            } else if (diff < maxHeap.peek()) {
                double x = maxHeap.poll();
                if (!set.remove((int) (target + x))) set.remove((int) (target - x));
                maxHeap.offer(diff);
                set.add(root.val);
            } else {
                if (root.val > target) search(root.left, target, k, maxHeap, set);
                else search(root.right, target, k, maxHeap, set);
                return;
            }
            search(root.left, target, k, maxHeap, set);
            search(root.right, target, k, maxHeap, set);
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new ClosestBinarySearchTreeValue().new Solution();
            assertTrue(true);
        }
    }
}
