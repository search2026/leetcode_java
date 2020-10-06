package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Flatten2DVectorTests {

    @Test
    public void testSolution() {
        List<List<Integer>> test = new ArrayList<>();
        test.add(new ArrayList<>() {{
            add(1);
            add(2);
        }});
        test.add(new ArrayList<>() {{
            add(3);
        }});
        test.add(new ArrayList<>() {{
            add(4);
            add(5);
            add(6);
        }});
        Flatten2DVector.Solution it = new Flatten2DVector().new Solution(test);
        List<Integer> res = new ArrayList<>();
        while (it.hasNext()) {
            res.add(it.next());
        }
        assertEquals(6, res.size());
        assertEquals(1, (int) res.get(0));
        assertEquals(3, (int) res.get(2));
        assertEquals(6, (int) res.get(5));
    }

    @Test
    public void testSolution2() {
        List<List<Integer>> test = new ArrayList<>();
        test.add(new ArrayList<>() {{
            add(1);
            add(2);
        }});
        test.add(new ArrayList<>() {{
            add(3);
        }});
        test.add(new ArrayList<>() {{
            add(4);
            add(5);
            add(6);
        }});
        Flatten2DVector.Solution_2 it = new Flatten2DVector().new Solution_2(test);
        List<Integer> res = new ArrayList<>();
        while (it.hasNext()) {
            res.add(it.next());
        }
        assertEquals(6, res.size());
        assertEquals(1, (int) res.get(0));
        assertEquals(3, (int) res.get(2));
        assertEquals(6, (int) res.get(5));
    }

    @Test
    public void testSolution3() {
        List<List<Integer>> test = new ArrayList<>();
        test.add(new ArrayList<>() {{
            add(1);
            add(2);
        }});
        test.add(new ArrayList<>() {{
            add(3);
        }});
        test.add(new ArrayList<>() {{
            add(4);
            add(5);
            add(6);
        }});
        Flatten2DVector.Solution_3 it = new Flatten2DVector().new Solution_3(test);
        assertTrue(it.hasNext());
        assertEquals(1, (int) it.next());
        it.remove();
        List<Integer> res = new ArrayList<>();
        while (it.hasNext()) {
            res.add(it.next());
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
        it = new Flatten2DVector().new Solution_3(test);
        assertTrue(it.hasNext());
        assertEquals(1, (int) it.next());
        assertTrue(it.hasNext());
        assertEquals(2, (int) it.next());
        it.remove();
        assertTrue(it.hasNext());
        assertEquals(3, (int) it.next());
    }

    @Test
    public void testSolution4() {
        List<List<Integer>> test = new ArrayList<>();
        test.add(new ArrayList<>() {{
            add(1);
            add(2);
        }});
        test.add(new ArrayList<>() {{
            add(3);
        }});
        test.add(new ArrayList<>() {{
            add(4);
            add(5);
            add(6);
        }});
        Flatten2DVector.Solution_4 it = new Flatten2DVector().new Solution_4(test);
        assertTrue(it.hasNext());
        assertEquals(1, (int) it.next());
        it.remove();
        List<Integer> res = new ArrayList<>();
        while (it.hasNext()) {
            res.add(it.next());
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
        it = new Flatten2DVector().new Solution_4(test);
        assertTrue(it.hasNext());
        assertEquals(1, (int) it.next());
        assertTrue(it.hasNext());
        assertEquals(2, (int) it.next());
        it.remove();
        assertTrue(it.hasNext());
        assertEquals(3, (int) it.next());
    }

}

