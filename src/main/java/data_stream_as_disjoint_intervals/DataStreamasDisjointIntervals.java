package data_stream_as_disjoint_intervals;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import common.Interval;

import static org.junit.Assert.assertEquals;

public class DataStreamasDisjointIntervals {
    /*
        Data Stream as Disjoint Intervals - Insert Intervals
        Leetcode #352
        https://leetcode.com/problems/data-stream-as-disjoint-intervals/
        Difficulty: Hard
     */
    public class SummaryRanges {
        List<Interval> rslt;

        public SummaryRanges() {
            rslt = new ArrayList<Interval>();
        }

        public void addNum(int val) {
            int start = 0;
            List<Interval> list = new ArrayList<Interval>();
            Interval item = new Interval(val, val);
            for (int i = 0; i < rslt.size(); i++) {
                Interval temp = rslt.get(i);
                if (temp.end + 1 < item.start) {
                    list.add(temp);
                } else if (temp.start - 1 > item.end) {
                    list.add(item);
                    item = temp;
                } else {
                    item.start = Math.min(item.start, temp.start);
                    item.end = Math.max(item.end, temp.end);
                }
            }
            list.add(item);
            rslt = list;
        }

        public List<Interval> getIntervals() {
            return rslt;
        }
    }


    /*
        Data Stream as Disjoint Intervals - Treemap
        Leetcode #352
        https://leetcode.com/problems/data-stream-as-disjoint-intervals/
        Difficulty: Hard
     */
    public class SummaryRanges_2 {
        TreeMap<Integer, Interval> tree;

        /**
         * Initialize your data structure here.
         */
        public SummaryRanges_2() {
            tree = new TreeMap<>();
        }

        public void addNum(int val) {
            if (tree.containsKey(val)) return;
            Integer l = tree.lowerKey(val);
            Integer h = tree.higherKey(val);
            if (l != null && h != null && tree.get(l).end + 1 == val && h == val + 1) {
                tree.get(l).end = tree.get(h).end;
                tree.remove(h);
            } else if (l != null && tree.get(l).end + 1 >= val) {
                tree.get(l).end = Math.max(tree.get(l).end, val);
            } else if (h != null && h == val + 1) {
                tree.put(val, new Interval(val, tree.get(h).end));
                tree.remove(h);
            } else {
                tree.put(val, new Interval(val, val));
            }
        }

        public List<Interval> getIntervals() {
            return new ArrayList<>(tree.values());
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            //Solution sol = new DataStreamasDisjointIntervals().new Solution();
            assertEquals(1, 1);
            // Test case
            // input: ["SummaryRanges","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals","addNum","getIntervals"]
            // [[],[1],[],[3],[],[7],[],[2],[],[6],[]]
            // Output:
            // [null,null,[[1,1]],null,[[1,1],[3,3]],null,[[1,1],[3,3],[7,7]],null,[[1,3],[7,7]],null,[[1,3],[6,7]]]
        }
    }
}

