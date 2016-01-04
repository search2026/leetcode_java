package permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    /*
        Permutations - Iterative
        https://leetcode.com/problems/permutations/
        Difficulty: Medium
    */
    public class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> rslt = new ArrayList<List<Integer>>();
            rslt.add(new ArrayList<Integer>());

            for (int i = 0; i < nums.length; i++) {
                ArrayList<ArrayList<Integer>> curr = new ArrayList<ArrayList<Integer>>();

                for (List<Integer> l : rslt) {
                    for (int j = 0; j < l.size() + 1; j++) {
                        l.add(j, nums[i]);
                        ArrayList<Integer> temp = new ArrayList<Integer>(l);
                        l.remove(j);
                    }
                }

                rslt = new ArrayList<List<Integer>>(curr);
            }

            return rslt;
        }
    }

    /*
        Permutations - Recursive
        https://leetcode.com/problems/permutations/
        Difficulty: Medium
    */
    public class Solution_2 {
        private void swap(int[] num, int i, int j) {
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }

        private void reverse(int[] num, int begin, int end) {
            end--;
            while (begin < end) {
                swap(num, begin++, end--);
            }
        }

        private boolean nextPermutation(int[] num) {
            if (num.length <= 1) {
                return false;
            }
            int i = num.length - 1;
            while (true) {
                i--;
                if (num[i] < num[i + 1]) {
                    int j = num.length;
                    while (num[i] >= num[--j]) {
                    }
                    swap(num, i, j);
                    reverse(num, i + 1, num.length);
                    return true;
                }
                if (i == 0) {
                    reverse(num, 0, num.length);
                    return false;
                }
            }
        }

        public List<List<Integer>> permute(int[] num) {
            Arrays.sort(num);
            List<List<Integer>> rslt = new ArrayList<List<Integer>>();
            do {
                ArrayList<Integer> l = new ArrayList<Integer>();
                for (int n : num) {
                    l.add(n);
                }
                rslt.add(l);
            } while (nextPermutation(num));
            return rslt;
        }
    }

    /*
        Permutations II
        https://leetcode.com/problems/permutations-ii/
        Difficulty: Medium
    */
    public class Solution_3 {
        private void swap(int[] num, int i, int j) {
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }

        private void reverse(int[] num, int begin, int end) {
            end--;
            while (begin < end) {
                swap(num, begin++, end--);
            }
        }

        private boolean nextPermutation(int[] num) {
            if (num.length <= 1) {
                return false;
            }
            int i = num.length - 1;
            while (true) {
                i--;
                if (num[i] < num[i + 1]) {
                    int j = num.length;
                    while (num[i] >= num[--j]) {
                    }
                    swap(num, i, j);
                    reverse(num, i + 1, num.length);
                    return true;
                }
                if (i == 0) {
                    reverse(num, 0, num.length);
                    return false;
                }
            }
        }

        public List<List<Integer>> permuteUnique(int[] num) {
            Arrays.sort(num);
            List<List<Integer>> rslt = new ArrayList<List<Integer>>();
            do {
                ArrayList<Integer> l = new ArrayList<Integer>();
                for (int n : num) {
                    l.add(n);
                }
                rslt.add(l);
            } while (nextPermutation(num));
            return rslt;
        }
    }

    public static class UnitTest {

    }
}
