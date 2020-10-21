package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms {

    /*
        Meeting Rooms
        Leetcode #252
        https://github.com/search2026/leetcode_java/blob/master/problems201_300/resources/MeetingRooms.md
        Difficulty: Easy
     */
    public class Solution {
        public boolean canAttendMeetings(Interval[] intervals) {
            if (intervals == null || intervals.length == 0) return true;

            Arrays.sort(intervals, (Interval o1, Interval o2) -> (o1.start - o2.start));
            Interval prev = intervals[0];
            for (int i = 1; i < intervals.length; i++) {
                Interval cur = intervals[i];
                if (prev.end > cur.start) {
                    return false;
                }
                prev = cur;
            }

            return true;
        }
    }

    /*
        Meeting Rooms
        Leetcode #252
        https://github.com/search2026/leetcode_java/blob/master/problems201_300/resources/MeetingRooms.md
        Difficulty: Easy
     */
    public class Solution_2 {
        private class IntervalComparator implements Comparator<Interval> {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start && o1.end <= o2.start)
                    return -1;
                else if (o1.start > o2.start && o1.start >= o2.end)
                    return 1;
                throw new RuntimeException();
            }
        }

        public boolean canAttendMeetings(Interval[] intervals) {
            try {
                Arrays.sort(intervals, new IntervalComparator());
                Interval prev = intervals[0];
                for (int i = 1; i < intervals.length; i++) {
                    Interval cur = intervals[i];
                    if (prev.end > cur.start) {
                        return false;
                    }
                    prev = cur;
                }
            } catch (Exception e) {
                return false;
            }
            return true;
        }
    }

    /*
        Meeting Rooms II - Two Arrays
        Leetcode #253
        https://github.com/search2026/leetcode_java/blob/master/problems201_300/resources/MeetingRoomsII.md
        Difficulty: Medium
    */
    public class Solution_3 {
        public int minMeetingRooms(Interval[] intervals) {
            if (intervals == null) return 0;
            int n = intervals.length;
            if (n == 0) return 0;
            int[] startTime = new int[n];
            int[] endTime = new int[n];

            for (int i = 0; i < n; i++) {
                startTime[i] = intervals[i].start;
                endTime[i] = intervals[i].end;
            }

            Arrays.sort(startTime);
            Arrays.sort(endTime);

            int rooms = 0, endP = 0;
            for (int i = 0; i < n; i++) {
                if (startTime[i] < endTime[endP]) {
                    rooms++;
                } else {
                    endP++;
                }
            }

            return rooms;
        }
    }

    /*
        Meeting Rooms II - Priority Queue
        Leetcode #253
        https://github.com/search2026/leetcode_java/blob/master/problems201_300/resources/MeetingRoomsII.md
        Difficulty: Medium
    */
    public class Solution_4 {
        public int minMeetingRooms(Interval[] intervals) {
            if (intervals == null || intervals.length == 0) return 0;

            Arrays.sort(intervals, (Interval o1, Interval o2) -> (o1.start - o2.start));
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.offer(intervals[0].end);
            int rooms = 1;

            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i].start < pq.peek()) {
                    rooms++;
                } else {
                    pq.poll();
                }
                pq.offer(intervals[i].end);
            }

            return rooms;
        }
    }

}
