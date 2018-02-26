package peeking_iterator;

import java.util.*;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    Peeking Iterator
    https://leetcode.com/problems/peeking-iterator/
    Difficulty: Medium
 */
public class PeekingIterator implements Iterator<Integer> {
    private Integer next;
    private Iterator<Integer> iter;
    private boolean noSuchElement;

    PeekingIterator(Iterator<Integer> iterator) {
        iter = iterator;
        advanceIter();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        // you should confirm with interviewer what to return/throw
        // if there are no more values
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (noSuchElement)
            throw new NoSuchElementException();
        Integer res = next;
        advanceIter();
        return res;
    }

    @Override
    public boolean hasNext() {
        return !noSuchElement;
    }

    private void advanceIter() {
        if (iter.hasNext()) {
            next = iter.next();
        } else {
            noSuchElement = true;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.add(3);
            PeekingIterator iter = new PeekingIterator(list.iterator());
            assertTrue(iter.hasNext());
            assertEquals(1, (int) iter.next());
            assertEquals(2, (int) iter.peek());
            assertEquals(2, (int) iter.next());
            assertEquals(3, (int) iter.peek());
            assertEquals(3, (int) iter.next());
            assertFalse(iter.hasNext());
        }
    }
}

