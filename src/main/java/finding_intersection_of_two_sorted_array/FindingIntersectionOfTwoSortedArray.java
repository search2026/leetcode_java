package finding_intersection_of_two_sorted_array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FindingIntersectionOfTwoSortedArray {
    /*
        Finding intersection of Two Sorted Array
        http://articles.leetcode.com/2010/03/here-is-phone-screening-question-from.html
        Difficulty: Easy
     */
    public class Solution {
        public List<Integer> findCommon(int[] a, int[] b) {
            List<Integer> rslt = new ArrayList<Integer>();

            if (a == null || a.length == 0 || b == null || b.length == 0) return rslt;

            int p1 = 0, p2 = 0;

            while (p1 < a.length && p2 < b.length) {
                if (a[p1] == b[p2]) {
                    rslt.add(a[p1]);
                    p1++;
                    p2++;
                } else if (a[p1] < b[p2]) {
                    p1++;
                } else {
                    p2++;
                }
            }

            return rslt;
        }
    }

    /*
        Find the Intersection of N Sorted Array
        http://stackoverflow.com/questions/5630685/efficient-algorithm-to-produce-the-n-way-intersection-of-sorted-arrays-in-c
        Difficulty: Medium
    */
    public class SolutionII {
        public List<Integer> findCommon(int[][] input) {
            //think about use a queue

            List<Integer> rslt = new ArrayList<Integer>();

            if (input == null || input.length == 0) return rslt;

            for (int i = 0; i < input.length; i++) {
                // a null array make no intersection
                if (input[i] == null || input[i].length == 0) return rslt;
            }

            int size = input.length;
            int[] p = new int[size];

            for (int i = 0; i < size; i++) {
                p[i] = 0;
            }

            // the common one must exists in every row
            // use the first row's element as initial value
            // increase all other rows' pointers until it is equal or larger than initial value
            for (int i = 0; i < input[0].length; i++) {
                int initial = input[0][i];
                boolean findEqual = true;

                for (int j = 1; j < size; j++) {
                    while (p[j] < input[j].length && input[j][p[j]] < initial) p[j]++;
                    if (p[j] >= input[j].length) {
                        findEqual = false;
                    } else if (input[j][p[j]] != initial) {
                        findEqual = false;
                    }
                }

                if (findEqual) rslt.add(initial);
            }

            return rslt;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new FindingIntersectionOfTwoSortedArray().new Solution();
            int[] a = {1, 3, 4, 5, 6, 9, 10};
            int[] b = {2, 3, 5, 7};
            System.out.println(sol.findCommon(a, b));

            SolutionII sol2 = new FindingIntersectionOfTwoSortedArray().new SolutionII();
            int[][] test = new int[][]{
                    a,
                    b,
                    new int[]{0, 3, 5}
            };
            System.out.println(sol2.findCommon(test));

            assertTrue(true);
        }
    }
}
