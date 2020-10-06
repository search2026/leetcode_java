package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.Interval;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MeetingRoomsTests {

    @Test
    public void testSolution() {
        MeetingRooms.Solution sol = new MeetingRooms().new Solution();
        Interval[] intervals = new Interval[]{
                new Interval(0, 30),
                new Interval(5, 10),
                new Interval(15, 20)
        };
        assertFalse(sol.canAttendMeetings(intervals));
    }

    @Test
    public void testSolution2() {
        MeetingRooms.Solution_2 sol = new MeetingRooms().new Solution_2();
        Interval[] intervals = new Interval[]{
                new Interval(0, 30),
                new Interval(5, 10),
                new Interval(15, 20)
        };
        assertFalse(sol.canAttendMeetings(intervals));
    }

    @Test
    public void testSolution3() {
        MeetingRooms.Solution_3 sol = new MeetingRooms().new Solution_3();
        Interval[] intervals = new Interval[]{
                new Interval(0, 30),
                new Interval(5, 10),
                new Interval(15, 20)
        };
        assertEquals(2, sol.minMeetingRooms(intervals));
    }

    @Test
    public void testSolution4() {
        MeetingRooms.Solution_4 sol = new MeetingRooms().new Solution_4();
        Interval[] intervals = new Interval[]{
                new Interval(0, 30),
                new Interval(5, 10),
                new Interval(15, 20)
        };
        assertEquals(2, sol.minMeetingRooms(intervals));
    }

}
