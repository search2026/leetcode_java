package com.search2026.leetcode.problems;

import java.util.*;

public class IntersectionOfTwoArrays {

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
            int m = nums1.length;
            int n = nums2.length;

            Set<Integer> list = new HashSet<>();
            int p1 = 0, p2 = 0;
            while (p1 < m && p2 < n) {
                if (nums1[p1] < nums2[p2]) {
                    p1++;
                } else if (nums1[p1] > nums2[p2]) {
                    p2++;
                } else {
                    list.add(nums1[p1]);
                    p1++;
                    p2++;
                }
            }

            int[] res = new int[list.size()];
            int i = 0;
            for (Integer d : list) res[i++] = d;

            return res;
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

            int[] res = new int[hs1.size()];
            int i = 0;
            for (Integer d : hs1) res[i++] = d;

            return res;
        }
    }

    /*
        Intersection of Two Arrays - HashSet
        leetcode #349
        https://leetcode.com/problems/intersection-of-two-arrays/
        Difficulty: Easy
     */
    public class Solution_3 {
        private boolean binarySearch(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) return true;

                if (nums[mid] > target) right = mid - 1;
                else left = mid + 1;
            }
            return false;
        }

        public int[] intersection(int[] nums1, int[] nums2) {
            if (nums1 == null || nums1.length == 0) return new int[]{};
            if (nums2 == null || nums2.length == 0) return new int[]{};

            // should pick smaller one to do binary search
            Set<Integer> set = new HashSet<>();
            Arrays.sort(nums2);
            for (Integer num : nums1) {
                int idx = Arrays.binarySearch(nums2, num);
                if (idx >= 0) set.add(num);
//        if (binarySearch(nums2, num)) set.insert(num);
            }
            int i = 0;
            int[] res = new int[set.size()];
            for (Integer num : set) {
                res[i++] = num;
            }
            return res;
        }
    }

    /*
        Intersection of Two Arrays II - Two Pointers
        Leetcode 350
        https://leetcode.com/problems/intersection-of-two-arrays-ii/
        Difficulty: Medium
    */
    public class Solution_4 {
        public int[] intersect(int[] nums1, int[] nums2) {
            if (nums1 == null || nums1.length == 0) return new int[]{};
            if (nums2 == null || nums2.length == 0) return new int[]{};

            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int m = nums1.length;
            int n = nums2.length;

            List<Integer> list = new ArrayList<>();
            for (int p1 = 0, p2 = 0; p1 < m && p2 < n; ) {
                if (nums1[p1] < nums2[p2]) {
                    p1++;
                } else if (nums1[p1] > nums2[p2]) {
                    p2++;
                } else {
                    list.add(nums1[p1]);
                    p1++;
                    p2++;
                }
                if (p1 >= m || p2 >= n)
                    break;
            }

            int[] res = new int[list.size()];
            for (int i = 0; i < list.size(); i++) res[i] = list.get(i);

            return res;
        }
    }

    /*
        Intersection of Two Arrays II - HashMap
        Leetcode 350
        https://leetcode.com/problems/intersection-of-two-arrays-ii/
        Difficulty: Medium
    */
    public class Solution_5 {
        public int[] intersect(int[] nums1, int[] nums2) {
            if (nums1 == null || nums1.length == 0) return new int[]{};
            if (nums2 == null || nums2.length == 0) return new int[]{};

            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i = 0; i < nums1.length; i++) {
                int c = map.getOrDefault(nums1[i], 0) + 1;
                map.put(nums1[i], c);
            }

            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < nums2.length; i++) {
                if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                    list.add(nums2[i]);
                    map.put(nums2[i], map.get(nums2[i]) - 1);
                }
            }

            int[] res = new int[list.size()];
            for (int i = 0; i < list.size(); i++) res[i] = list.get(i);

            return res;
        }
    }

    /*
        Intersection of N Arrays - N Pointers
        http://stackoverflow.com/questions/5630685/efficient-algorithm-to-produce-the-n-way-intersection-of-sorted-arrays-in-c
        Difficulty: Medium
    */
    public class Solution_6 {
        public List<Integer> findCommon(int[][] input) {
            List<Integer> res = new ArrayList<Integer>();
            if (input == null || input.length == 0) return res;

            for (int i = 0; i < input.length; i++) {
                // a null array makes no intersection
                if (input[i] == null || input[i].length == 0) return res;
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

                if (findEqual) res.add(initial);
            }

            return res;
        }
    }

}
