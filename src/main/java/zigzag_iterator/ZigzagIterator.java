package zigzag_iterator;

import java.util.List;

/*
    Zigzag Iterator
    http://buttercola.blogspot.com/2015/09/leetocode-zigzag-iterator.html
    Difficulty: Medium
 */
public class ZigzagIterator {
    private List<Integer> v1;
    private List<Integer> v2;
    private int i;
    private int j;
    private int listId;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
        this.i = 0;
        this.j = 0;
        this.listId = 0;
    }

    public int next() {
        int result = 0;
        if (i >= v1.size()) {
            result = v2.get(j);
            j++;
        } else if (j >= v2.size()) {
            result = v1.get(i);
            i++;
        } else {
            if (listId == 0) {
                result = v1.get(i);
                i++;
                listId = 1;
            } else {
                result = v2.get(j);
                j++;
                listId = 0;
            }
        }

        return result;
    }

    public boolean hasNext() {
        return i < v1.size() || j < v2.size();
    }

    public static class UnitTest {
    }
}

