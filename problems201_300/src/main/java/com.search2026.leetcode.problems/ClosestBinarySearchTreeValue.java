package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeNode;

import java.util.*;

public class ClosestBinarySearchTreeValue {

    /*
        Closest Binary Search Tree Value - Recursion
        Leetcode #270
        https://github.com/search2026/leetcode_java/blob/master/problems201_300/resources/ClosestBinarySearchTreeValue.md
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
        https://github.com/search2026/leetcode_java/blob/master/problems201_300/resources/ClosestBinarySearchTreeValue.md
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
        https://github.com/search2026/leetcode_java/blob/master/problems201_300/resources/ClosestBinarySearchTreeValueII.md
        Difficulty: Hard
      */
    public class Solution_3 {
        public List<Integer> closestKValues(TreeNode root, double target, int k) {
            PriorityQueue<Double> maxHeap = new PriorityQueue<>(k, new Comparator<Double>() {
                @Override
                public int compare(Double x, Double y) {
                    return (int) (y - x);
                }
            });
            Set<Integer> set = new HashSet<>();

            search(root, target, k, maxHeap, set);

            return new ArrayList<>(set);
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

}
