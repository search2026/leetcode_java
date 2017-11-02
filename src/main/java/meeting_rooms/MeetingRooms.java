package meeting_rooms;

import common.Interval;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class MeetingRooms {
    /*
        Meeting Rooms
        Leetcode #252
        https://leetcode.com/discuss/questions/oj/meeting-rooms?sort=votes
        http://www.cnblogs.com/grandyang/p/5240774.html
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
        https://leetcode.com/discuss/questions/oj/meeting-rooms?sort=votes
        http://www.cnblogs.com/grandyang/p/5240774.html
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
            } catch (Exception e) {
                return false;
            }
            return true;
        }
    }

    /*
        Meeting Rooms II - Two Arrays
        Leetcode #253
        https://leetcode.com/discuss/questions/oj/meeting-rooms-ii?sort=votes
        http://www.cnblogs.com/grandyang/p/5244720.html
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
        https://leetcode.com/discuss/questions/oj/meeting-rooms-ii?sort=votes
        http://www.cnblogs.com/grandyang/p/5244720.html
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
                    pq.offer(intervals[i].end);
                } else {
                    pq.poll();
                    pq.offer(intervals[i].end);
                }
            }

            return rooms;
        }
    }

    /*
        Meeting Time
        Find time intervals, which have no meeting
        https://www.quora.com/What-is-the-algorithmic-approach-to-find-the-free-time-intervals-of-both-people-so-they-can-arrange-a-meeting-given-the-set-of-busy-time-intervals-of-two-people-as-in-a-calendar
        Difficulty: Medium
     */
    public class Solution_5 {
        class Point implements Comparable<Point> {
            int time;
            boolean isStart;
            Point(int time, boolean isStart) {
                this.time = time;
                this.isStart = isStart;
            }
            @Override
            public int compareTo(Point that) {
                if (this.time != that.time || this.isStart == that.isStart) {
                    return this.time - that.time;
                } else {
                    return this.isStart ? -1 : 1;
                }
            }
        }

        public List<Interval> getAvailableIntervals(List<List<Interval>> intervals, int k) {
            List<Interval> res = new ArrayList<>();
            List<Point> points = new ArrayList<>();

            for (List<Interval> intervalList : intervals) {
                for (Interval interval : intervalList) {
                    points.add(new Point(interval.start, true));
                    points.add(new Point(interval.end, false));
                }
            }
            Collections.sort(points);

            int count = 0;
            Integer availableStart = null;
            for (int i = 0; i < points.size(); i++) {
                Point point = points.get(i);
                if (point.isStart) {
                    count++;
                    if (availableStart == null && i == 0 && count <= intervals.size() - k) {
                        availableStart = point.time;
                    } else if (availableStart != null && count == intervals.size() - k + 1) {
                        res.add(new Interval(availableStart, point.time));
                        availableStart = null;
                    }
                } else {
                    count--;
                    if (count == intervals.size() - k && i < points.size() - 1) {
                        availableStart = point.time;
                    } else if (availableStart != null && i == points.size() - 1 && count <= intervals.size() - k) {
                        res.add(new Interval(availableStart, point.time));
                        availableStart = null;
                    }
                }
            }

            return res;
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
            assertFalse(sol.canAttendMeetings(intervals));
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

        @Test
        public void test4() {
            Solution_4 sol = new MeetingRooms().new Solution_4();
            Interval[] intervals = new Interval[]{
                    new Interval(0, 30),
                    new Interval(5, 10),
                    new Interval(15, 20)
            };
            assertEquals(2, sol.minMeetingRooms(intervals));
        }

        @Test
        public void test5() {
            Solution_5 sol = new MeetingRooms().new Solution_5();
            List<List<Interval>> intervals = new ArrayList<List<Interval>>() {{
               add(new ArrayList<Interval>() {{
                   add(new Interval(1, 3));
                   add(new Interval(6, 7));
               }});
                add(new ArrayList<Interval>() {{
                    add(new Interval(2, 4));
                }});
                add(new ArrayList<Interval>() {{
                    add(new Interval(2, 3));
                    add(new Interval(9, 12));
                }});
            }};
            List<Interval> res = sol.getAvailableIntervals(intervals, 3);
            assertEquals(2, res.size());
            assertEquals(4, res.get(0).start);
            assertEquals(6, res.get(0).end);
            assertEquals(7, res.get(1).start);
            assertEquals(9, res.get(1).end);
        }
    }
}

