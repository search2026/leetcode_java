package n_queens;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

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

        public void search(int n, int row, int[] colForRow, List<List<String>> rslt) {
            if (row == n) { //findRoot a suitable solution, insert to result list
                List<String> list = new ArrayList<String>();
                for (int i = 0; i < n; i++) {
                    StringBuilder buff = new StringBuilder();
                    for (int m = 0; m < n; m++) {
                        if (colForRow[i] == m) buff.append('Q');
                        else buff.append('.');
                    }
                    String st = buff.toString();
                    list.add(st);
                }
                rslt.add(list);
                return;
            }

            for (int i = 0; i < n; i++) {
                colForRow[row] = i;
                if (validate(row, colForRow)) {
                    search(n, row+1, colForRow, rslt);
                }
            }
        }

        public List<List<String>> solveNQueens(int n) {
            List<List<String>> rslt = new ArrayList<List<String>>();
            search(n, 0, new int[n], rslt);
            return rslt;
        }
    }

    /*
        N-Queens II - Mathmatic
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

        private void search(int n, int row, int[] ColForRow, ArrayList<Integer> rslt) {
            if (row == n) { //findRoot a suitable solution
                rslt.set(0, rslt.get(0) + 1);
                return;
            }
            for (int i = 0; i < n; i++) {
                ColForRow[row] = i;
                if (validate(row, ColForRow)) {
                    search(n, row + 1, ColForRow, rslt);
                }
            }
        }

        public int totalNQueens(int n) {
            ArrayList<Integer> rslt = new ArrayList<Integer>();
            rslt.add(0);
            search(n, 0, new int[n], rslt);
            return rslt.get(0);
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution_2 sol2 = new NQueens().new Solution_2();
            Solution_3 sol3 = new NQueens().new Solution_3();
            assertEquals(1, sol2.totalNQueens(1));
            assertEquals(1, sol3.totalNQueens(1));
            assertEquals(92, sol2.totalNQueens(8));
            assertEquals(92, sol3.totalNQueens(8));
        }
    }
}

