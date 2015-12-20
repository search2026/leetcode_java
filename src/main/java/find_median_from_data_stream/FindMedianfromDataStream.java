package find_median_from_data_stream;

import org.junit.Test;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.Assert.*;

public class FindMedianfromDataStream {
    /*
        Find Median from Data Stream
        https://leetcode.com/problems/find-median-from-data-stream/
        Difficulty: Medium
     */
    public class MedianFinder {
        Queue<Integer> q = new PriorityQueue(), z = q, t,
                Q = new PriorityQueue(Collections.reverseOrder());

        public void addNum(int num) {
            (t = Q).add(num);
            (Q = q).add((q = t).poll());
        }

        public double findMedian() {
            return (Q.peek() + z.peek()) / 2.;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            MedianFinder sol = new FindMedianfromDataStream().new MedianFinder();
        }
    }
}
