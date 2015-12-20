package n_queens;

import java.util.*;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList();
        List<String> sol = new ArrayList<String>();
        HashMap<Integer, Integer> flag = new HashMap<Integer, Integer>();
        int column = 0;
        int row = 0;
        find(row, -1, n, flag, sol, res);
        return res;
    }

    public void find(int row, int index, int n, HashMap<Integer, Integer> flag, List<String> sol, List<List<String>> res) {
        if (row <= n - 1) {
            int p = 0;
            for (int i = 0; i < n; i++) {
                if (!check(flag, index, n, row, i))
                    continue;
                if (!flag.containsKey(i)) {
                    //if(row < n-1)
                    flag.put(i, row);
                    p = 1;
                    place(sol, n, i);
                    if (row == n - 1) {
                        ArrayList<String> q = new ArrayList<String>(sol);
                        res.add(q);
                    } else
                        find(row + 1, i, n, flag, sol, res);
                    sol.remove(sol.size() - 1);
                    flag.remove(i);
                }
            }
            if (p == 0)
                return;
        }
    }

    public void place(List<String> sol, int n, int i) {
        char[] temp = new char[n];
        Arrays.fill(temp, '.');
        temp[i] = 'Q';
        String tmp = new String(temp);
        sol.add(tmp);
    }

    public boolean check(HashMap flag, int index, int n, int row, int i) {
        if (index == -1)
            return true;
        if (index - 2 < i && i < index + 2)
            return false;
        int flag2 = 0;
        for (int ii = 0; ii < n; ii++) {
            if (flag.containsKey(ii)) {
                if (Math.abs(i - ii) == Math.abs(row - (int) flag.get(ii)))
                    flag2 = 1;
            }
        }
        if (flag2 == 1)
            return false;
        return true;
    }

    // N-Queens II
    private int search(int row, int lDiag, int rDiag, int upper) {
        if (row == upper) {
            return 1;
        }
        int count = 0;
        int allow = upper & ~(row | lDiag | rDiag);
        while (allow != 0) {
            int pos = (-allow) & allow;
            count += search(row + pos, (lDiag + pos) >> 1,
                    (rDiag + pos) << 1, upper);
            allow = allow - pos;
        }
        return count;
    }

    public int totalNQueens(int n) {
        return search(0, 0, 0, (1 << n) - 1);
    }

    public static class UnitTest {

    }
}

