package range_sum_query;

import org.junit.Test;

import static org.junit.Assert.*;

public class RangeSumQuery {
    /*
        Range Sum Query - Immutable
        https://leetcode.com/problems/range-sum-query-immutable/
        Difficulty: Easy
     */
    public class NumArray {
        private int[] sums;

        public NumArray(int[] nums) {
            sums = new int[nums.length];
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                sums[i] = sum;
            }
        }

        public int sumRange(int i, int j) {
            int toMinus = 0;
            if (i > 0)
                toMinus = sums[i - 1];
            return sums[j] - toMinus;
        }
    }

    /*
    Range Sum Query - Mutable
    https://leetcode.com/problems/range-sum-query-mutable/
    Difficulty: Medium
   */
    public class NumArrayII {
        int[] processed;
        int[] nums;
        int length;

        public NumArrayII(int[] nums) {
            length = nums.length;
            processed = new int[length + 1];
            this.nums = nums;

            //init processed
            for (int i = 1; i <= length; i++) {
                int sum = 0;
                int count = 1;
                int counter = lowBit(i);

                while (count <= counter) {
                    sum += nums[i - count];
                    count++;
                }
                processed[i] = sum;
            }
        }

        void update(int i, int val) {
            //更新树状数组
            int gap = val - nums[i];
            nums[i] = val;

            int index = i + 1;
            while (index <= length) {
                processed[index] += gap;
                index += lowBit(index);
            }
        }

        public int sumRange(int i, int j) {
            return sum(j + 1) - sum(i);
        }

        private int sum(int index) {
            int sum = 0;
            while (index > 0) {
                sum += processed[index];
                index -= lowBit(index);
            }
            return sum;
        }

        private int lowBit(int index) {
            return index & (-index);
        }
    }


    /*
        Range Sum Query 2D - Immutable
        https://leetcode.com/problems/range-sum-query-immutable/
        Difficulty: Medium
    */
    public class NumMatrix {
        private int[][] sum;

        public NumMatrix(int[][] matrix) {
            if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
                sum = new int[][]{};
                return;
            }

            sum = new int[matrix.length][matrix[0].length];

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (i == 0) {
                        if (j == 0)
                            sum[i][j] = matrix[0][0];
                        else
                            sum[i][j] = sum[i][j - 1] + matrix[i][j];
                    } else {
                        if (j == 0)
                            sum[i][j] = matrix[i][j] + sum[i - 1][j];
                        else
                            sum[i][j] = sum[i - 1][j] + sum[i][j - 1] + matrix[i][j] - sum[i - 1][j - 1];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int left = 0;
            if (col1 > 0)
                left = sum[row2][col1 - 1];

            int top = 0;
            if (row1 > 0)
                top = sum[row1 - 1][col2];

            int leftTop = 0;
            if (row1 > 0 && col1 > 0)
                leftTop = sum[row1 - 1][col1 - 1];

            return sum[row2][col2] - left - top + leftTop;
        }
    }


    // Following version timeout at leetcode Online judgement
//    public class NumArray {
//        private SegmentTreeNode root = null;
//        private int size = 0;
//
//        public NumArray(int[] nums) {
//            root = buildSegmentTree(nums, 0, nums.length - 1);
//            size = nums.length;
//        }
//
//        public void update(int i, int val) {
//            if(i < 0 || i >= size)
//                return;
//            update(root, i, val);
//        }
//
//        public int sumRange(int i, int j) {
//            if(i < 0 || j >= size || i > j)
//                return -1;
//            return sumRange(root, i, j);
//        }
//
//        class SegmentTreeNode {
//            int low = 0;
//            int high = 0;
//            int val = 0;
//            SegmentTreeNode left = null;
//            SegmentTreeNode right = null;
//            SegmentTreeNode(int l, int h, int v) {
//                low =l;
//                high = h;
//                val = v;
//            }
//        }
//
//        private SegmentTreeNode buildSegmentTree(int[] nums, int start, int end) {
//            if(start > end)
//                return null;
//            if(start == end) {
//                SegmentTreeNode leaf = new SegmentTreeNode(start, end, nums[start]);
//                return leaf;
//            }
//            SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
//            int mid = (start + end) / 2;
//            root.left = buildSegmentTree(nums, start, mid);
//            root.right = buildSegmentTree(nums, mid + 1, end);
//            root.val = root.left.val + root.right.val;
//            return root;
//        }
//
//        private int update(SegmentTreeNode root, int i, int val) {
//            if(root.low == root.high && root.low == i) {
//                int old = root.val;
//                root.val = val;
//                return old;
//            }
//
//            int mid = (root.low + root.high) / 2;
//            int old = 0;
//            if(i >= root.low && i <= mid)
//                old = update(root.left, i, val);
//            else
//                old = update(root.right, i, val);
//            root.val = root.val - old + val;
//            return old;
//        }
//
//        private int sumRange(SegmentTreeNode root, int i, int j) {
//            if(root.low == i && root.high == j) {
//                return root.val;
//            }
//            int mid = (root.low + root.high) / 2;
//            if(i <= mid && j <= mid) {
//                return sumRange(root.left, i, j);
//            } else if(i > mid && j > mid) {
//                return sumRange(root.right, i, j);
//            } else {
//                return sumRange(root.left, i, mid) + sumRange(root.right, mid + 1, j);
//            }
//        }
//    }
    /*
        Range Sum Query 2D - Mutable
        https://leetcode.com/problems/range-sum-query-immutable/
        Difficulty: Hard
    */
    public class NumMatrixII {
        private class SegmentTreeNode2D {
            public int tlRow;
            public int tlCol;
            public int brRow;
            public int brCol;
            public int sum;
            public SegmentTreeNode2D nw, ne, sw, se;

            public SegmentTreeNode2D(int tlRow, int tlCol, int brRow, int brCol) {
                this.tlRow = tlRow;
                this.tlCol = tlCol;
                this.brRow = brRow;
                this.brCol = brCol;
                this.sum = 0;
            }
        }

        public SegmentTreeNode2D root;

        public NumMatrixII(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return;
            }
            root = buildTree(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1);
        }

        public void update(int row, int col, int val) {
            update(root, row, col, val);
        }

        private void update(SegmentTreeNode2D node, int row, int col, int val) {
            if (node.tlRow == row && node.brRow == row && node.tlCol == col && node.brCol == col) {
                node.sum = val;
                return;
            }
            int rowMid = node.tlRow + (node.brRow - node.tlRow) / 2;
            int colMid = node.tlCol + (node.brCol - node.tlCol) / 2;
            if (row <= rowMid) {
                if (col <= colMid) {
                    update(node.nw, row, col, val);
                } else {
                    update(node.ne, row, col, val);
                }
            } else {
                if (col <= colMid) {
                    update(node.sw, row, col, val);
                } else {
                    update(node.se, row, col, val);
                }
            }

            node.sum = 0;
            if (node.nw != null) {
                node.sum += node.nw.sum;
            }
            if (node.ne != null) {
                node.sum += node.ne.sum;
            }
            if (node.sw != null) {
                node.sum += node.sw.sum;
            }
            if (node.se != null) {
                node.sum += node.se.sum;
            }
        }


        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sumRegion(root, row1, col1, row2, col2);
        }

        private int sumRegion(SegmentTreeNode2D node, int tlRow, int tlCol, int brRow, int brCol) {
            if (node.tlRow == tlRow && node.tlCol == tlCol && node.brRow == brRow && node.brCol == brCol) {
                return node.sum;
            }
            int rowMid = node.tlRow + (node.brRow - node.tlRow) / 2;
            int colMid = node.tlCol + (node.brCol - node.tlCol) / 2;
            if (brRow <= rowMid) {  // top-half plane
                if (brCol <= colMid) {         // north-west quadrant
                    return sumRegion(node.nw, tlRow, tlCol, brRow, brCol);
                } else if (tlCol > colMid) {    // north-east quadrant
                    return sumRegion(node.ne, tlRow, tlCol, brRow, brCol);
                } else {                // intersection between nw and ne
                    return sumRegion(node.nw, tlRow, tlCol, brRow, colMid) + sumRegion(node.ne, tlRow, colMid + 1, brRow, brCol);
                }
            } else if (tlRow > rowMid) {         // bot-half plane
                if (brCol <= colMid) {         // south-west quadrant
                    return sumRegion(node.sw, tlRow, tlCol, brRow, brCol);
                } else if (tlCol > colMid) {    // south-east quadrant
                    return sumRegion(node.se, tlRow, tlCol, brRow, brCol);
                } else {                //intersection between sw and sw
                    return sumRegion(node.sw, tlRow, tlCol, brRow, colMid) + sumRegion(node.se, tlRow, colMid + 1, brRow, brCol);
                }
            } else {                // full-plane intersection
                if (brCol <= colMid) {         // left half plane
                    return sumRegion(node.nw, tlRow, tlCol, rowMid, brCol) + sumRegion(node.sw, rowMid + 1, tlCol, brRow, brCol);
                } else if (tlCol > colMid) {    // right half plane
                    return sumRegion(node.ne, tlRow, tlCol, rowMid, brCol) + sumRegion(node.se, rowMid + 1, tlCol, brRow, brCol);
                } else {                // full-plane intersection
                    return sumRegion(node.nw, tlRow, tlCol, rowMid, colMid)
                            + sumRegion(node.ne, tlRow, colMid + 1, rowMid, brCol)
                            + sumRegion(node.sw, rowMid + 1, tlCol, brRow, colMid)
                            + sumRegion(node.se, rowMid + 1, colMid + 1, brRow, brCol);
                }
            }
        }


        private SegmentTreeNode2D buildTree(int[][] matrix, int tlRow, int tlCol, int brRow, int brCol) {
            if (tlRow > brRow || tlCol > brCol) {
                return null;
            } else {
                SegmentTreeNode2D node = new SegmentTreeNode2D(tlRow, tlCol, brRow, brCol);
                if (tlRow == brRow && tlCol == brCol) {
                    node.sum = matrix[tlRow][tlCol];
                } else {
                    int rowMid = tlRow + (brRow - tlRow) / 2;
                    int colMid = tlCol + (brCol - tlCol) / 2;
                    node.nw = buildTree(matrix, tlRow, tlCol, rowMid, colMid);
                    node.ne = buildTree(matrix, tlRow, colMid + 1, rowMid, brCol);
                    node.sw = buildTree(matrix, rowMid + 1, tlCol, brRow, colMid);
                    node.se = buildTree(matrix, rowMid + 1, colMid + 1, brRow, brCol);
                    node.sum = 0;
                    if (node.nw != null) {
                        node.sum += node.nw.sum;
                    }
                    if (node.ne != null) {
                        node.sum += node.ne.sum;
                    }
                    if (node.sw != null) {
                        node.sum += node.sw.sum;
                    }
                    if (node.se != null) {
                        node.sum += node.se.sum;
                    }
                }
                return node;
            }
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            int[] tests = new int[]{-2, 0, 3, -5, 2, -1};
            NumArray sol = new RangeSumQuery().new NumArray(tests);
            assertEquals(sol.sumRange(0, 2), 1);
            assertEquals(sol.sumRange(2, 5), -1);
            assertEquals(sol.sumRange(0, 5), -3);
        }
    }
}
