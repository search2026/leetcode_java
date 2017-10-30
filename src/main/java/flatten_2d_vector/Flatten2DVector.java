package flatten_2d_vector;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Flatten2DVector {
    /*
        Flatten 2D Vector
        Leetcode #251
        https://leetcode.com/discuss/questions/oj/flatten-2d-vector
        http://buttercola.blogspot.com/2015/08/leetcode-flatten-2d-vector.html
        Difficulty: Medium
     */
    public class Solution {
        int outerIdx, innerIdx;
        List<List<Integer>> vec;

        public Solution(List<List<Integer>> vec2d) {
            outerIdx = 0;
            innerIdx = 0;
            vec = vec2d;
        }

        public int next() {
            return vec.get(outerIdx).get(innerIdx++);
        }

        public boolean hasNext() {
            while (outerIdx < vec.size()) {
                if (innerIdx < vec.get(outerIdx).size())
                    return true;
                else {
                    outerIdx++;
                    innerIdx = 0;
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
    public class Solution_2 {
        private Iterator<List<Integer>> outerIter;
        private Iterator<Integer> innerIter;

        public Solution_2(List<List<Integer>> vec2d) {
            outerIter = vec2d.iterator();
            innerIter = Collections.emptyIterator();
        }

        public int next() {
            return innerIter.next();
        }

        public boolean hasNext() {
            while ((innerIter == null || !innerIter.hasNext()) && outerIter.hasNext())
                innerIter = outerIter.next().iterator();
            return innerIter != null && innerIter.hasNext();
        }
    }

    /*
        Flatten 2D Vector with remove()
        Leetcode #251
        https://leetcode.com/discuss/questions/oj/flatten-2d-vector
        http://buttercola.blogspot.com/2015/08/leetcode-flatten-2d-vector.html
        Difficulty: Medium
     */
    public class Vector2DIterator implements Iterator<Integer> {
        private Integer cur;
        private int outerIndex;
        private int innerIndex;
        private int lastOuterIndex;
        private int lastInnerIndex;
        private List<List<Integer>> vector;

        public Vector2DIterator(List<List<Integer>> vec2d) {
            this.vector = vec2d;
            this.outerIndex = 0;
            this.innerIndex = 0;
            this.lastOuterIndex = -1;
            this.lastInnerIndex = -1;
            searchNext();
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                return null;
            }
            int temp = cur;
            lastOuterIndex = outerIndex;
            lastInnerIndex = innerIndex;
            innerIndex++;
            searchNext();
            return temp;
        }

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public void remove() {
            if (lastOuterIndex == -1 && lastInnerIndex == -1) {
                throw new IllegalStateException("remove() can be called only once per call to next()");
            }

            vector.get(lastOuterIndex).remove(lastInnerIndex);
            if (lastOuterIndex == outerIndex) {
                innerIndex--;
            }
            lastOuterIndex = -1;
            lastInnerIndex = -1;
        }

        private void searchNext() {
            if (outerIndex < vector.size()) {
                if (innerIndex < vector.get(outerIndex).size()) {
                    cur = vector.get(outerIndex).get(innerIndex);
                } else {
                    outerIndex++;
                    innerIndex = 0;
                    searchNext();
                }
            } else {
                cur = null;
            }
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
            Vector2DIterator sol = new Flatten2DVector().new Vector2DIterator(test);
            assertTrue(sol.hasNext());
            assertEquals(1, (int)sol.next());
            sol.remove();
            List<Integer> res = new ArrayList<>();
            while (sol.hasNext()) {
                res.add(sol.next());
            }
            assertEquals(5, res.size());
            assertEquals(2, (int) res.get(0));
            assertEquals(4, (int) res.get(2));
            assertEquals(6, (int) res.get(4));
        }
    }
}
