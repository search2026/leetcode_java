package count_of_range_sum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountofRangeSum {
    /*
        Count of Range Sum
        https://leetcode.com/problems/count-of-range-sum/
        Difficulty: Hard
     */
    public class Solution {
        public SegmentTreeNode buildTree(int[] nums, int low, int high) {
            if (low > high) return null;

            SegmentTreeNode cur = new SegmentTreeNode(low, high);
            if (low == high) {
                cur.sum = nums[low];
            } else {
                int mid = low + (high - low) / 2;
                cur.left = buildTree(nums, low, mid);
                cur.right = buildTree(nums, mid + 1, high);
                cur.sum = cur.left.sum + cur.right.sum;
            }
            return cur;
        }

        public int rangeCount(SegmentTreeNode node, int low, int high) {
            if (node == null) return 0;

            int curSum = node.sum;

            if (curSum > high || curSum < low)
                return rangeCount(node.right, low, high) + rangeCount(node.left, low, high);

            return 1 + rangeCount(node.right, low, high) + rangeCount(node.left, low, high);
        }

        public int countRangeSum(int[] nums, int lower, int upper) {
            int count = 0;
            if (nums == null || nums.length == 0) return count;

            SegmentTreeNode root = buildTree(nums, 0, nums.length - 1);

            count = rangeCount(root, lower, upper);
            return count;
        }

        public class SegmentTreeNode {
            int sum;
            int start;
            int end;
            SegmentTreeNode left;
            SegmentTreeNode right;

            public SegmentTreeNode(int start, int end) {
                this.sum = 0;
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
            //assertEquals(2, sol.countRangeSum(new int[]{0, -3, -3, 1, 1, 2}, 3, 5));
        }
    }
}

