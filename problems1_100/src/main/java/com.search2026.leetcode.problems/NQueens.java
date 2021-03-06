package com.search2026.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    /*
        N-Queens
        Leetcode #51
        https://leetcode.com/problems/n-queens/
        Difficulty: Hard
     */
    public class Solution {
        public boolean validate(int row, int[] colForRow) {
            for (int i = 0; i < row; i++) {
                if (colForRow[i] == colForRow[row] || Math.abs(colForRow[i] - colForRow[row]) == Math.abs(i - row))
                    return false;
            }
            return true;
        }

        public void search(int n, int row, int[] colForRow, List<List<String>> res) {
            if (row == n) { //findRoot a suitable solution, insert to result list
                List<String> list = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    StringBuilder buff = new StringBuilder();
                    for (int m = 0; m < n; m++) {
                        if (colForRow[i] == m) buff.append('Q');
                        else buff.append('.');
                    }
                    String st = buff.toString();
                    list.add(st);
                }
                res.add(list);
                return;
            }

            for (int i = 0; i < n; i++) {
                colForRow[row] = i;
                if (validate(row, colForRow)) {
                    search(n, row+1, colForRow, res);
                }
            }
        }

        public List<List<String>> solveNQueens(int n) {
            List<List<String>> res = new ArrayList<>();
            search(n, 0, new int[n], res);
            return res;
        }
    }

    /*
        N-Queens II - Mathematics
        Leetcode #52
        https://leetcode.com/problems/n-queens_ii/
        Difficulty: Hard
    */
    public class Solution_2 {
        private int search(int row, int left, int right, int upper) {
            if (row == upper) {
                return 1;
            }
            int count = 0;
            int allow = upper & ~(row | left | right);
            while (allow != 0) {
                int pos = (-allow) & allow;
                count += search(row + pos, (left + pos) >> 1, (right + pos) << 1, upper);
                allow = allow - pos;
            }
            return count;
        }

        public int totalNQueens(int n) {
            return search(0, 0, 0, (1 << n) - 1);
        }
    }

    /*
        N-Queens II - Backtracking
        Leetcode #52
        https://leetcode.com/problems/n-queens_ii/
        Difficulty: Hard
    */
    public class Solution_3 {
        private boolean validate(int row, int[] ColForRow) {
            for (int i = 0; i < row; i++) {
                if (ColForRow[i] == ColForRow[row] || Math.abs(ColForRow[i] - ColForRow[row]) == Math.abs(i - row)) {
                    return false;
                }
            }
            return true;
        }

        private void search(int n, int row, int[] ColForRow, ArrayList<Integer> res) {
            if (row == n) { //findRoot a suitable solution
                res.set(0, res.get(0) + 1);
                return;
            }
            for (int i = 0; i < n; i++) {
                ColForRow[row] = i;
                if (validate(row, ColForRow)) {
                    search(n, row + 1, ColForRow, res);
                }
            }
        }

        public int totalNQueens(int n) {
            ArrayList<Integer> res = new ArrayList<>();
            res.add(0);
            search(n, 0, new int[n], res);
            return res.get(0);
        }
    }

}
