package count_of_range_sum;

import common.SegmentTreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class CountofRangeSum {
    /*
        Count of Range Sum - Segment Tree
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
            int rslt = 0;
            int n = nums.length;
            if (n <= 0) return rslt;

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
                rslt += count(root, lower + sum, upper + sum);
            }

            return rslt;
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

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new CountofRangeSum().new Solution();
            assertEquals(3, sol.countRangeSum(new int[]{-2, 5, -1}, -2, 2));
            assertEquals(4, sol.countRangeSum(new int[]{2147483647, -2147483648, -1, 0}, -1, 0));
            assertEquals(2, sol.countRangeSum(new int[]{0, -3, -3, 1, 1, 2}, 3, 5));
            assertEquals(10, sol.countRangeSum(new int[]{-2,0,0,2,2,-2}, -3, 1));
            assertEquals(3, sol.countRangeSum(new int[]{-2147483647,0,-2147483647,2147483647}, -564, 3864));
        }
    }
}

