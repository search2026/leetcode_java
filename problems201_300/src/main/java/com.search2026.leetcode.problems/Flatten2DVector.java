package com.search2026.leetcode.problems;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Flatten2DVector {

    /*
        Flatten 2D Vector
        Leetcode #251
        https://leetcode.com/discuss/questions/oj/flatten-2d-vector
        http://buttercola.blogspot.com/2015/08/leetcode-flatten-2d-vector.html
        Difficulty: Medium
     */
    public class Solution implements Iterator<Integer> {
        private int row, col;
        private List<List<Integer>> vec2d;

        public Solution(List<List<Integer>> vec) {
            row = 0;
            col = 0;
            vec2d = vec;
        }

        @Override
        public Integer next() {
            int val = vec2d.get(row).get(col);
            col++;
            return val;
        }

        @Override
        public boolean hasNext() {
            if (vec2d == null || vec2d.isEmpty())
                return false;
            while (row < vec2d.size()) {
                if (col < vec2d.get(row).size()) {
                    return true;
                } else {
                    row++;
                    col = 0;
                }
            }
            return false;
        }
    }

    /*
        Flatten 2D Vector
        Leetcode #251
        https://leetcode.com/discuss/questions/oj/flatten-2d-vector
        http://buttercola.blogspot.com/2015/08/leetcode-flatten-2d-vector.html
        Difficulty: Medium
     */
    public class Solution_2 implements Iterator<Integer> {
        private Iterator<List<Integer>> rowIter;
        private Iterator<Integer> colIter;

        public Solution_2(List<List<Integer>> vec2d) {
            rowIter = vec2d.iterator();
            colIter = Collections.emptyIterator();
        }

        @Override
        public Integer next() {
            return colIter.next();
        }

        @Override
        public boolean hasNext() {
            while ((colIter == null || !colIter.hasNext()) && rowIter.hasNext())
                colIter = rowIter.next().iterator();
            return colIter != null && colIter.hasNext();
        }
    }

    /*
        Flatten 2D Vector
        Leetcode #251
        https://leetcode.com/discuss/questions/oj/flatten-2d-vector
        http://buttercola.blogspot.com/2015/08/leetcode-flatten-2d-vector.html
        Difficulty: Medium
     */
    public class Solution_3 implements Iterator<Integer> {
        private int row, col;
        private List<List<Integer>> vec2d;

        public Solution_3(List<List<Integer>> vec) {
            row = 0;
            col = 0;
            vec2d = vec;
        }

        @Override
        public Integer next() {
            int val = vec2d.get(row).get(col);
            col++;
            return val;
        }

        @Override
        public boolean hasNext() {
            if (vec2d == null || vec2d.isEmpty())
                return false;
            while (row < vec2d.size()) {
                if (col < vec2d.get(row).size()) {
                    return true;
                } else {
                    row++;
                    col = 0;
                }
            }
            return false;
        }

        @Override
        public void remove() {
            List<Integer> listToBeRemoved;
            int rowToBeRemoved = row;
            int colToBeRemoved = col;
            if (col == 0) {
                rowToBeRemoved--;
                colToBeRemoved = vec2d.get(rowToBeRemoved).size() - 1;
                listToBeRemoved = vec2d.get(rowToBeRemoved);
            } else {
                colToBeRemoved--;
                listToBeRemoved = vec2d.get(rowToBeRemoved);
            }
            listToBeRemoved.remove(colToBeRemoved);
            if (listToBeRemoved.isEmpty()) {
                vec2d.remove(listToBeRemoved);
                row--;
            }
            if (col > 0)
                col--;
        }
    }


    /*
        Flatten 2D Vector
        Leetcode #251
        https://leetcode.com/discuss/questions/oj/flatten-2d-vector
        http://buttercola.blogspot.com/2015/08/leetcode-flatten-2d-vector.html
        Difficulty: Medium
     */
    public class Solution_4 implements Iterator<Integer> {
        private Iterator<List<Integer>> rowIter;
        private Iterator<Integer> colIter;

        public Solution_4(List<List<Integer>> vec2d) {
            rowIter = vec2d.iterator();
            colIter = Collections.emptyIterator();
        }

        @Override
        public Integer next() {
            return colIter.next();
        }

        @Override
        public boolean hasNext() {
            while ((colIter == null || !colIter.hasNext()) && rowIter.hasNext())
                colIter = rowIter.next().iterator();
            return colIter != null && colIter.hasNext();
        }

        @Override
        public void remove() {
            while (colIter == null && rowIter.hasNext())
                colIter = rowIter.next().iterator();
            if (colIter != null)
                colIter.remove();
        }
    }

}
