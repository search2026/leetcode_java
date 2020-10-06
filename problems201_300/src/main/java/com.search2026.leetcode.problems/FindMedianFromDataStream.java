package com.search2026.leetcode.problems;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    /*
        Find Median from Data Stream
        Leetcode #295
        https://leetcode.com/problems/find-median-from-data-stream/
        Difficulty: Medium
     */
    public class MedianFinder {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

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

}
