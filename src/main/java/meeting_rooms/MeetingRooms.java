package meeting_rooms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import common.Interval;

public class MeetingRooms {
    /*
        Meeting Rooms
        http://buttercola.blogspot.com/2015/08/leetcode-meeting-rooms.html
        Difficulty: Easy
     */
    public class Solution {
        public boolean canAttendMeetings(Interval[] intervals) {
            if (intervals == null || intervals.length == 0) {
                return true;
            }

            // Sort according to the start time
            Arrays.sort(intervals, new IntervalComparator());

            Interval prev = intervals[0];
            for (int i = 1; i < intervals.length; i++) {
                Interval curr = intervals[i];
                if (isOverlapped(prev, curr)) {
                    return false;
                }
                prev = curr;
            }

            return true;
        }

        public class IntervalComparator implements Comparator<Interval> {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        }

        private boolean isOverlapped(Interval a, Interval b) {
            return a.end > b.start;
        }
    }

    /*
       Meeting Rooms II
       http://buttercola.blogspot.com/2015/08/leetcode-meeting-rooms-ii.html
       Difficulty: Medium
    */
    public class SolutionII {
        public int minMeetingRooms(Interval[] intervals) {
            if (intervals == null || intervals.length == 0) {
                return 0;
            }

            int len = intervals.length;
            int[] startTime = new int[len];
            int[] endTime = new int[len];

            for (int i = 0; i < len; i++) {
                Interval curr = intervals[i];
                startTime[i] = curr.start;
                endTime[i] = curr.end;
            }

            // Sort the start and end time
            Arrays.sort(startTime);
            Arrays.sort(endTime);

            int activeMeetings = 0;
            int numMeetingRooms = 0;

            int i = 0;
            int j = 0;

            while (i < len && j < len) {
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
       Meeting Rooms II
       http://buttercola.blogspot.com/2015/08/leetcode-meeting-rooms-ii.html
       Difficulty: Medium
    */
    public class SolutionIIPQ {
        public int minMeetingRooms(Interval[] intervals) {
            if (intervals == null || intervals.length == 0) {
                return 0;
            }

            Arrays.sort(intervals, new IntervalComparator());

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int numRooms = 1;

            pq.offer(intervals[0].end);

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

        public class IntervalComparator implements Comparator<Interval> {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        }
    }

    public static class UnitTest {

    }
}

