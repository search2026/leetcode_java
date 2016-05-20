package intersection_of_two_arrays;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class IntersectionofTwoArrays {
    /*
        Intersection of Two Arrays - Two Pointers
        leetcode #349
        https://leetcode.com/problems/intersection-of-two-arrays/
        Difficulty: Easy
     */
    public class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            if (nums1 == null || nums1.length == 0) return new int[]{};
            if (nums2 == null || nums2.length == 0) return new int[]{};

            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int m= nums1.length;
            int n= nums2.length;

            List<Integer> intersec = new ArrayList<>();
            for (int p1=0, p2=0; p1<m&&p2<n;) {
                if (nums1[p1] < nums2[p2]) {
                    do{p1++;} while (p1<m && nums1[p1]==nums1[p1-1]);
                } else if (nums1[p1] > nums2[p2]) {
                    do{p2++;} while (p2<n && nums2[p2]==nums2[p2-1]);
                } else {
                    intersec.add(nums1[p1]);
                    do{p1++;} while (p1<m && nums1[p1]==nums1[p1-1]);
                    do{p2++;} while (p2<n && nums2[p2]==nums2[p2-1]);
                }
                if (p1>=m || p2>=n)
                    break;
            }

            int[] rslt = new int[intersec.size()];
            int i = 0;
            for (Integer d : intersec) {
                rslt[i++] = d;
            }
            return rslt;
        }
    }

    /*
        Intersection of Two Arrays - HashSet
        leetcode #349
        https://leetcode.com/problems/intersection-of-two-arrays/
        Difficulty: Easy
     */
    public class Solution_2 {
        public int[] intersection(int[] nums1, int[] nums2) {
            if (nums1 == null || nums1.length == 0) return new int[]{};
            if (nums2 == null || nums2.length == 0) return new int[]{};

            Set<Integer> hs1 = new HashSet<>();
            for (int n : nums1) hs1.add(n);

            Set<Integer> hs2 = new HashSet<>();
            for (int n : nums2) hs2.add(n);

            hs1.retainAll(hs2);

            int[] rslt = new int[hs1.size()];
            int i = 0;
            for (Integer d : hs1) {
                rslt[i++] = d;
            }
            return rslt;
        }
    }

    /*
        Intersection of N Arrays - N Pointers
        http://stackoverflow.com/questions/5630685/efficient-algorithm-to-produce-the-n-way-intersection-of-sorted-arrays-in-c
        Difficulty: Medium
    */
    public class Solution_3 {
        public List<Integer> findCommon(int[][] input) {
            List<Integer> rslt = new ArrayList<Integer>();
            if (input == null || input.length == 0) return rslt;

            for (int i = 0; i < input.length; i++) {
                // a null array makes no intersection
                if (input[i] == null || input[i].length == 0) return rslt;
            }

            int size = input.length;
            int[] p = new int[size];

            for (int i = 0; i < size; i++) p[i] = 0;

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
            Solution sol = new IntersectionofTwoArrays().new Solution();
            int[] a = {1, 2, 2, 1};
            int[] b = {2, 2};
            assertEquals(1, 1);
        }

        @Test
        public void test2() {
            Solution_2 sol = new IntersectionofTwoArrays().new Solution_2();
            int[] a = {1, 2, 2, 1};
            int[] b = {2, 2};
            assertEquals(1, 1);
        }
    }
}

