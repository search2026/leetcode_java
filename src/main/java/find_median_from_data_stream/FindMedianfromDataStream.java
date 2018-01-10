package find_median_from_data_stream;

import org.junit.Test;

import java.util.Collections;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

public class FindMedianfromDataStream {
    /*
        Find Median from Data Stream
        Leetcode #295
        https://leetcode.com/problems/find-median-from-data-stream/
        Difficulty: Medium
     */
    public class MedianFinder {
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());

        public void addNum(int num) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
            if (maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }

        public double findMedian() {
            return maxHeap.size() == minHeap.size()
                    ? (maxHeap.peek() + minHeap.peek()) / 2.0
                    : maxHeap.peek();
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            MedianFinder sol = new FindMedianfromDataStream().new MedianFinder();
            sol.addNum(2);
            sol.addNum(3);
            assertEquals(2.5, sol.findMedian(), 1E-03);
            sol.addNum(4);
            assertEquals(3, sol.findMedian(), 1E-03);
        }
    }
}
