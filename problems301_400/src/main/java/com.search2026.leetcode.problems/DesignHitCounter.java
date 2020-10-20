package com.search2026.leetcode.problems;

import java.util.ArrayDeque;
import java.util.Queue;

public class DesignHitCounter {

    /*
        Design Hit Counter
        Leetcode #362
        https://github.com/search2026/leetcode_java/blob/master/resources/DesignHitCounter.md
        Difficulty: Medium
     */
    public class HitCounter {
        private int[] times;
        private int[] hits;
        private final int CHECK_RANGE_SECONDS = 300;

        /** Initialize your data structure here. */
        public HitCounter() {
            times = new int[CHECK_RANGE_SECONDS];
            hits = new int[CHECK_RANGE_SECONDS];
        }

        /** Record a hit.
         @param timestamp - The current timestamp (in seconds granularity). */
        public void hit(int timestamp) {
            int index = timestamp % CHECK_RANGE_SECONDS;
            if (times[index] != timestamp) {
                times[index] = timestamp;
                hits[index] = 1;
            } else {
                hits[index]++;
            }
        }

        /** Return the number of hits in the past 5 minutes.
         @param timestamp - The current timestamp (in seconds granularity). */
        public int getHits(int timestamp) {
            int count = 0;
            for (int i = 0; i < CHECK_RANGE_SECONDS; i++) {
                if (timestamp - times[i] < CHECK_RANGE_SECONDS) {
                    count += hits[i];
                }
            }
            return count;
        }
    }

    /*
        Design Hit Counter - Queue
        Leetcode #362
        https://github.com/search2026/leetcode_java/blob/master/resources/DesignHitCounter.md
        Difficulty: Medium
     */
    public class HitCounter_2 {
        Queue<Integer> q;
        private final int CHECK_RANGE_SECONDS = 300;

        /** Initialize your data structure here. */
        public HitCounter_2() {
            q = new ArrayDeque<>();
        }

        /** Record a hit.
         @param timestamp - The current timestamp (in seconds granularity). */
        public void hit(int timestamp) {
            q.offer(timestamp);
        }

        /** Return the number of hits in the past 5 minutes.
         @param timestamp - The current timestamp (in seconds granularity). */
        public int getHits(int timestamp) {
            while(!q.isEmpty() && timestamp - q.peek() >= CHECK_RANGE_SECONDS) {
                q.poll();
            }
            return q.size();
        }
    }

}
