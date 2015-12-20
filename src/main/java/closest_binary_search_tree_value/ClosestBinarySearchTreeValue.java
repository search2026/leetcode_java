package closest_binary_search_tree_value;

import common.TreeNode;

import java.util.*;

public class ClosestBinarySearchTreeValue {
    // Closest Binary Search Tree Value
    // http://blog.csdn.net/xudli/article/details/48749493
    // Difficulty: Easy
    public class Solution {
        public int closestValue(TreeNode root, double target) {
            int closest = root.val;
            double min = Double.MAX_VALUE;

            while(root!=null) {
                if( Math.abs(root.val - target) < min  ) {
                    min = Math.abs(root.val - target);
                    closest = root.val;
                }

                if(target < root.val) {
                    root = root.left;
                } else if(target > root.val) {
                    root = root.right;
                } else {
                    return root.val;
                }
            }

            return closest;
        }
    }

    // Closest Binary Search Tree Value II
    // http://blog.csdn.net/xudli/article/details/48752907
    // Difficulty: Hard
    public class SolutionII {
        public List<Integer> closestKValues(TreeNode root, double target, int k) {
            PriorityQueue<Double> maxHeap = new PriorityQueue<Double>(k, new Comparator<Double>() {
                @Override
                public int compare(Double x, Double y) {
                    return (int)(y-x);
                }
            });
            Set<Integer> set = new HashSet<Integer>();

            rec(root, target, k, maxHeap, set);

            return new ArrayList<Integer>(set);
        }

        private void rec(TreeNode root, double target, int k, PriorityQueue<Double> maxHeap, Set<Integer> set) {
            if(root==null) return;
            double diff = Math.abs(root.val-target);
            if(maxHeap.size()<k) {
                maxHeap.offer(diff);
                set.add(root.val);
            } else if( diff < maxHeap.peek() ) {
                double x = maxHeap.poll();
                if(! set.remove((int)(target+x))) set.remove((int)(target-x));
                maxHeap.offer(diff);
                set.add(root.val);
            } else {
                if(root.val > target) rec(root.left, target, k, maxHeap,set);
                else rec(root.right, target, k, maxHeap, set);
                return;
            }
            rec(root.left, target, k, maxHeap, set);
            rec(root.right, target, k, maxHeap, set);
        }
    }

    public static class UnitTest {

    }
}
