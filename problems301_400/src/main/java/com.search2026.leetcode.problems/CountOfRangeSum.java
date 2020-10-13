package com.search2026.leetcode.problems;

import java.util.Arrays;

public class CountOfRangeSum {

    /*
        Count of Range Sum - Segment Tree
        Leetcode #327
        https://leetcode.com/problems/count-of-range-sum/
        Difficulty: Hard
     */
    public class Solution {
        SegmentTreeNode root = null;

        public SegmentTreeNode buildTree(long[] nums, int left, int right) {
            if (left > right) return null;

            SegmentTreeNode p = new SegmentTreeNode(nums[left], nums[right]);
            if (left == right) return p;

            int mid = left + (right - left) / 2;
            p.left = buildTree(nums, left, mid);
            p.right = buildTree(nums, mid + 1, right);
            return p;
        }

        public void update(SegmentTreeNode node, long key) {
            if (node != null && node.start <= key && node.end >= key) {
                node.val++;
                update(node.left, key);
                update(node.right, key);
            }
        }

        public long count(SegmentTreeNode node, long low, long high) {
            if (node == null || node.start > high || node.end < low) return 0;
            if (node.start >= low && node.end <= high) return node.val;
            return count(node.left, low, high) + count(node.right, low, high);
        }

        public int countRangeSum(int[] nums, int lower, int upper) {
            int res = 0;
            int n = nums.length;
            if (n <= 0) return res;

            long[] sum_array = new long[n];
            sum_array[0] = nums[0];
            for (int i = 1; i < n; i++) {
                sum_array[i] = nums[i] + sum_array[i - 1];
            }
            long sum = sum_array[n - 1];
            Arrays.sort(sum_array);
            int unique = 1;
            for (int j=1; j<n; j++ ) {
                if (sum_array[j] != sum_array[j-1]) {
                    sum_array[unique] = sum_array[j];
                    unique++;
                }
            }
            root = buildTree(sum_array, 0, unique - 1);

            for (int i = n - 1; i >= 0; i--) {
                update(root, sum);
                sum -= nums[i];
                res += count(root, lower + sum, upper + sum);
            }

            return res;
        }

        public class SegmentTreeNode {
            long val;
            long start;
            long end;
            SegmentTreeNode left;
            SegmentTreeNode right;

            public SegmentTreeNode(long start, long end) {
                this.val = 0;
                this.start = start;
                this.end = end;
                this.left = null;
                this.right = null;
            }
        }
    }

}
