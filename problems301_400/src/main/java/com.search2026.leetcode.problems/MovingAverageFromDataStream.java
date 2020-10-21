package com.search2026.leetcode.problems;

import java.util.LinkedList;
import java.util.List;

public class MovingAverageFromDataStream {

    /*
        Moving Average from Data Stream - Queue
        Leetcode #346
        https://github.com/search2026/leetcode_java/blob/master/problems301_400/resources/MovingAverageFromDataStream.md
        Difficulty: Easy
     */
    public class MovingAverage {
        private int sum;
        private int size;
        private List<Integer> queue;

        public MovingAverage(int size) {
            this.sum = 0;
            this.size = size;
            this.queue = new LinkedList<>();
        }

        public double next(int val) {
            if (queue.size() < size) {
                sum = sum + val;
            } else {
                sum = sum - queue.remove(0) + val;
            }
            queue.add(val);
            return (double)sum / queue.size();
        }
    }

    /*
        Moving Average from Data Stream - Circular Buffer
        Leetcode #346
        https://github.com/search2026/leetcode_java/blob/master/resources/MovingAverageFromDataStream.md
        Difficulty: Easy
     */
    public class MovingAverage_2 {
        private int sum;
        private int pointer;
        private int[] circularBuffer;

        public MovingAverage_2(int size) {
            this.pointer = 0;
            this.sum = 0;
            this.circularBuffer = new int[size];
        }

        public double next(int val) {
            int i = pointer++ % circularBuffer.length;
            sum = sum - circularBuffer[i] + val;
            circularBuffer[i] = val;
            return (double)sum / (Math.min(pointer, circularBuffer.length));
        }
    }

}
