package meeting_rooms;

import common.Interval;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class MeetingRooms {
    /*
        Meeting Rooms
        http://buttercola.blogspot.com/2015/08/leetcode-meeting-rooms.html
        Difficulty: Easy
     */
    public class Solution {
        public class IntervalComparator implements Comparator<Interval> {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        }

        public boolean canAttendMeetings(Interval[] intervals) {
            if (intervals == null || intervals.length == 0) return true;

            // Sort according to the start time
            Arrays.sort(intervals, new IntervalComparator());

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
       Meeting Rooms II
       http://buttercola.blogspot.com/2015/08/leetcode-meeting-rooms-ii.html
       Difficulty: Medium
    */
    public class Solution_2 {
        public int minMeetingRooms(Interval[] intervals) {
            if (intervals == null || intervals.length == 0) return 0;

            int n = intervals.length;
            int[] startTime = new int[n];
            int[] endTime = new int[n];

            for (int i = 0; i < n; i++) {
                Interval cur = intervals[i];
                startTime[i] = cur.start;
                endTime[i] = cur.end;
            }

            // Sort the start and end time
            Arrays.sort(startTime);
            Arrays.sort(endTime);

            int activeMeetings = 0;
            int numMeetingRooms = 0;

            int i = 0;
            int j = 0;

            while (i < n && j < n) {
                if (startTime[i] < endTime[j]) {
                    activeMeetings++;
                    numMeetingRooms = Math.max(numMeetingRooms, activeMeetings);
                    i++;
                } else {
                    activeMeetings--;
                    j++;
                }
            }

            return numMeetingRooms;
        }
    }

    /*
       Meeting Rooms II - Priority Queue
       http://buttercola.blogspot.com/2015/08/leetcode-meeting-rooms-ii.html
       Difficulty: Medium
    */
    public class Solution_3 {
        public class IntervalComparator implements Comparator<Interval> {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        }

        public int minMeetingRooms(Interval[] intervals) {
            if (intervals == null || intervals.length == 0) return 0;

            Arrays.sort(intervals, new IntervalComparator());

            PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
            pq.offer(intervals[0].end);

            int numRooms = 1;
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i].start < pq.peek()) {
                    numRooms++;
                    pq.offer(intervals[i].end);
                } else {
                    pq.poll();
                    pq.offer(intervals[i].end);
                }
            }

            return numRooms;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new MeetingRooms().new Solution();
            Interval[] intervals = new Interval[]{
                    new Interval(0, 30),
                    new Interval(5, 10),
                    new Interval(15, 20)
            };
            assertFalse(sol.canAttendMeetings(intervals));
        }

        @Test
        public void test2() {
            Solution_2 sol = new MeetingRooms().new Solution_2();
            Interval[] intervals = new Interval[]{
                    new Interval(0, 30),
                    new Interval(5, 10),
                    new Interval(15, 20)
            };
            assertEquals(2, sol.minMeetingRooms(intervals));
        }

        @Test
        public void test3() {
            Solution_3 sol = new MeetingRooms().new Solution_3();
            Interval[] intervals = new Interval[]{
                    new Interval(0, 30),
                    new Interval(5, 10),
                    new Interval(15, 20)
            };
            assertEquals(2, sol.minMeetingRooms(intervals));
        }
    }
}

