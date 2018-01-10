package range_sum_query_mutable;

import org.junit.jupiter.api.Test;
import common.SegmentTreeNode;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RangeSumQueryMutable {
    /*
        Range Summary Query Mutable
        Leetcode #307
        https://leetcode.com/problems/range-sum-query-mutable/
        Difficulty: Medium
     */
    public class NumArray {
        SegmentTreeNode root;

        public NumArray(int[] nums) {
            this.root = buildTree(nums, 0, nums.length - 1);
        }

        void update(int i, int val) {
            update(root, i, val);
        }

        public int sumRange(long i, long j) {
            return (int)sumRange(root, i, j);
        }

        public SegmentTreeNode buildTree(int[] nums, int start, int end) {
            if (start > end) return null;
            else {
                SegmentTreeNode cur = new SegmentTreeNode(start, end);
                if (start == end) {
                    cur.val = nums[start];
                } else {
                    int mid = start + (end - start) / 2;
                    cur.left = buildTree(nums, start, mid);
                    cur.right = buildTree(nums, mid + 1, end);
                    cur.val = cur.left.val + cur.right.val;
                }
                return cur;
            }
        }

        public void update(SegmentTreeNode root, long i, long val) {
            if (root.start == root.end) { //leaf node
                root.val = val;
                return;
            }
            long mid = root.start + (root.end - root.start) / 2;
            if (i <= mid) update(root.left, i, val);
            else update(root.right, i, val);
            root.val = root.left.val + root.right.val;
        }

        public long sumRange(SegmentTreeNode root, long i, long j) {
            if (i == root.start && j == root.end) return root.val;
            else {
                long mid = root.start + (root.end - root.start) / 2;
                if (j <= mid) return sumRange(root.left, i, j);
                else if (i >= mid + 1) return sumRange(root.right, i, j);
                else
                    return sumRange(root.left, i, mid) + sumRange(root.right, mid + 1, j);
            }
        }
    }

    /*
        Range Sum Query 2D - Mutable
        Leetcode #308
        https://leetcode.com/discuss/questions/oj/range-sum-query-2d-mutable?sort=votes
        http://blog.csdn.net/u012175043/article/details/50093933
        Difficulty: Hard
    */
    public class NumMatrix {
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

        public NumMatrix(int[][] matrix) {
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
            NumArray test = new RangeSumQueryMutable().new NumArray(new int[]{1, 3, 5});
            assertEquals(9, test.sumRange(0, 2));
            test.update(1, 2);
            assertEquals(8, test.sumRange(0, 2));
        }
    }
}

