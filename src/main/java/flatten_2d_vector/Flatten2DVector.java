package flatten_2d_vector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    public static class UnitTest {
        @Test
        public void test1() {
            List<List<Integer>> test = new ArrayList<>();
            test.add(new ArrayList<Integer>() {{
                add(1);
                add(2);
            }});
            test.add(new ArrayList<Integer>() {{
                add(3);
            }});
            test.add(new ArrayList<Integer>() {{
                add(4);
                add(5);
                add(6);
            }});
            Solution sol = new Flatten2DVector().new Solution(test);
            List<Integer> res = new ArrayList<>();
            while (sol.hasNext()) {
                res.add(sol.next());
            }
            assertEquals(6, res.size());
            assertEquals(1, (int) res.get(0));
            assertEquals(3, (int) res.get(2));
            assertEquals(6, (int) res.get(5));
        }

        @Test
        public void test2() {
            List<List<Integer>> test = new ArrayList<>();
            test.add(new ArrayList<Integer>() {{
                add(1);
                add(2);
            }});
            test.add(new ArrayList<Integer>() {{
                add(3);
            }});
            test.add(new ArrayList<Integer>() {{
                add(4);
                add(5);
                add(6);
            }});
            Solution_2 sol = new Flatten2DVector().new Solution_2(test);
            List<Integer> res = new ArrayList<>();
            while (sol.hasNext()) {
                res.add(sol.next());
            }
            assertEquals(6, res.size());
            assertEquals(1, (int) res.get(0));
            assertEquals(3, (int) res.get(2));
            assertEquals(6, (int) res.get(5));
        }

        @Test
        public void test3() {
            List<List<Integer>> test = new ArrayList<>();
            test.add(new ArrayList<Integer>() {{
                add(1);
                add(2);
            }});
            test.add(new ArrayList<Integer>() {{
                add(3);
            }});
            test.add(new ArrayList<Integer>() {{
                add(4);
                add(5);
                add(6);
            }});
            Solution_3 sol = new Flatten2DVector().new Solution_3(test);
            assertTrue(sol.hasNext());
            assertEquals(1, (int) sol.next());
            sol.remove();
            List<Integer> res = new ArrayList<>();
            while (sol.hasNext()) {
                res.add(sol.next());
            }
            assertEquals(5, res.size());
            assertEquals(2, (int) res.get(0));
            assertEquals(4, (int) res.get(2));
            assertEquals(6, (int) res.get(4));

            test = new ArrayList<>();
            test.add(new ArrayList<Integer>() {{
                add(1);
                add(2);
            }});
            test.add(new ArrayList<Integer>() {{
                add(3);
            }});
            sol = new Flatten2DVector().new Solution_3(test);
            assertTrue(sol.hasNext());
            assertEquals(1, (int) sol.next());
            assertTrue(sol.hasNext());
            assertEquals(2, (int) sol.next());
            sol.remove();
            assertTrue(sol.hasNext());
            assertEquals(3, (int) sol.next());
        }

        @Test
        public void test4() {
            List<List<Integer>> test = new ArrayList<>();
            test.add(new ArrayList<Integer>() {{
                add(1);
                add(2);
            }});
            test.add(new ArrayList<Integer>() {{
                add(3);
            }});
            test.add(new ArrayList<Integer>() {{
                add(4);
                add(5);
                add(6);
            }});
            Solution_4 sol = new Flatten2DVector().new Solution_4(test);
            assertTrue(sol.hasNext());
            assertEquals(1, (int) sol.next());
            sol.remove();
            List<Integer> res = new ArrayList<>();
            while (sol.hasNext()) {
                res.add(sol.next());
            }
            assertEquals(5, res.size());
            assertEquals(2, (int) res.get(0));
            assertEquals(4, (int) res.get(2));
            assertEquals(6, (int) res.get(4));

            test = new ArrayList<>();
            test.add(new ArrayList<Integer>() {{
                add(1);
                add(2);
            }});
            test.add(new ArrayList<Integer>() {{
                add(3);
            }});
            sol = new Flatten2DVector().new Solution_4(test);
            assertTrue(sol.hasNext());
            assertEquals(1, (int) sol.next());
            assertTrue(sol.hasNext());
            assertEquals(2, (int) sol.next());
            sol.remove();
            assertTrue(sol.hasNext());
            assertEquals(3, (int) sol.next());
        }
    }
}
